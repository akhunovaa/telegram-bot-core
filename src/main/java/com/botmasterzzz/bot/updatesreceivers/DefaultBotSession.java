package com.botmasterzzz.bot.updatesreceivers;

import com.botmasterzzz.bot.Constants;
import com.botmasterzzz.bot.api.impl.methods.GetUpdates;
import com.botmasterzzz.bot.api.impl.objects.Update;
import com.botmasterzzz.bot.bot.DefaultBotOptions;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.generic.*;
import com.botmasterzzz.bot.logging.BotLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

import static com.botmasterzzz.bot.Constants.SOCKET_TIMEOUT;

public class DefaultBotSession implements BotSession {

  private static final String LOGTAG = "BOTSESSION";

  private volatile boolean running = false;

  private final ConcurrentLinkedDeque<Update> receivedUpdates = new ConcurrentLinkedDeque<>();
  private final ObjectMapper objectMapper = new ObjectMapper();

  private ReaderThread readerThread;
  private HandlerThread handlerThread;
  private PollBot callback;
  private String token;
  private int lastReceivedUpdate = 0;
  private DefaultBotOptions options;
  private UpdatesSupplier updatesSupplier;

  @Override
  public void setOptions(BotOptions options) {
    if (this.options != null) {
      throw new InvalidParameterException("BotOptions has already been set");
    }
    this.options = (DefaultBotOptions) options;
  }

  @Override
  public void setToken(String token) {
    if (this.token != null) {
      throw new InvalidParameterException("Token has already been set");
    }
    this.token = token;
  }

  @Override
  public void setCallback(PollBot callback) {
    if (this.callback != null) {
      throw new InvalidParameterException("Callback has already been set");
    }
    this.callback = callback;
  }

  @Override
  public void start() {
    if (running) {
      throw new IllegalStateException("Session already running");
    }

    running = true;

    lastReceivedUpdate = 0;

    readerThread = new ReaderThread(updatesSupplier, this);
    readerThread.setName("Telegram Connection");
    readerThread.start();

    handlerThread = new HandlerThread();
    handlerThread.setName("Telegram Executor");
    handlerThread.start();
  }

  @Override
  public void stop() {
    if (!running) {
      throw new IllegalStateException("Session already stopped");
    }

    running = false;

    if (readerThread != null) {
      readerThread.interrupt();
    }

    if (handlerThread != null) {
      handlerThread.interrupt();
    }

    if (callback != null) {
      callback.onClosing();
    }
  }

  @Override
  public synchronized boolean isRunning() {
    return running;
  }

  private class ReaderThread extends Thread implements UpdatesReader {

    private final UpdatesSupplier updatesSupplier;
    private final Object lock;
    private CloseableHttpClient httpclient;
    private ExponentialBackOff exponentialBackOff;
    private RequestConfig requestConfig;

    public ReaderThread(UpdatesSupplier updatesSupplier, Object lock) {
      this.updatesSupplier =
          Optional.ofNullable(updatesSupplier).orElse(this::getUpdatesFromServer);
      this.lock = lock;
    }

    private List<Update> getUpdatesFromServer() throws IOException {
      GetUpdates request =
          new GetUpdates()
              .setLimit(100)
              .setTimeout(Constants.GETUPDATES_TIMEOUT)
              .setOffset(lastReceivedUpdate + 1);

      if (options.getAllowedUpdates() != null) {
        request.setAllowedUpdates(options.getAllowedUpdates());
      }

      String url = options.getBaseUrl() + token + "/" + GetUpdates.PATH;
      // http client
      HttpPost httpPost = new HttpPost(url);
      httpPost.addHeader("charset", StandardCharsets.UTF_8.name());
      httpPost.setConfig(requestConfig);
      httpPost.setEntity(
          new StringEntity(objectMapper.writeValueAsString(request), ContentType.APPLICATION_JSON));

      try (CloseableHttpResponse response =
          httpclient.execute(httpPost, options.getHttpContext())) {
        HttpEntity ht = response.getEntity();
        BufferedHttpEntity buf = new BufferedHttpEntity(ht);
        String responseContent = EntityUtils.toString(buf, StandardCharsets.UTF_8);

        if (response.getStatusLine().getStatusCode() >= 500) {
          BotLogger.warn(LOGTAG, responseContent);
          synchronized (lock) {
            lock.wait(500);
          }
        } else {
          try {
            List<Update> updates = request.deserializeResponse(responseContent);
            exponentialBackOff.reset();
            return updates;
          } catch (JSONException e) {
            BotLogger.severe(responseContent, LOGTAG, e);
          }
        }
      } catch (SocketException | InvalidObjectException | TelegramApiRequestException e) {
        BotLogger.severe(LOGTAG, e);
      } catch (SocketTimeoutException e) {
        BotLogger.fine(LOGTAG, e);
      } catch (InterruptedException e) {
        BotLogger.fine(LOGTAG, e);
        interrupt();
      }
      return Collections.emptyList();
    }

    @Override
    public synchronized void start() {
      httpclient =
          HttpClientBuilder.create()
              .setSSLHostnameVerifier(new NoopHostnameVerifier())
              .setConnectionTimeToLive(70, TimeUnit.SECONDS)
              .setMaxConnTotal(100)
              .build();
      requestConfig = options.getRequestConfig();
      exponentialBackOff = options.getExponentialBackOff();

      if (exponentialBackOff == null) {
        exponentialBackOff = new ExponentialBackOff();
      }

      if (requestConfig == null) {
        requestConfig =
            RequestConfig.copy(RequestConfig.custom().build())
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectTimeout(SOCKET_TIMEOUT)
                .setConnectionRequestTimeout(SOCKET_TIMEOUT)
//                .setProxy(
//                    new HttpHost(
//                        options.getProxyHost(),
//                        options.getProxyPort(),
//                        options.getProxyType()))
                .build();
      }

      super.start();
    }

    @Override
    public void interrupt() {
      if (httpclient != null) {
        try {
          httpclient.close();
        } catch (IOException e) {
          BotLogger.warn(LOGTAG, e);
        }
      }
      super.interrupt();
    }

    @Override
    public void run() {
      setPriority(Thread.MIN_PRIORITY);
      while (running) {
        try {
          GetUpdates request =
              new GetUpdates()
                  .setLimit(100)
                  .setTimeout(Constants.GETUPDATES_TIMEOUT)
                  .setOffset(lastReceivedUpdate + 1);

          if (options.getAllowedUpdates() != null) {
            request.setAllowedUpdates(options.getAllowedUpdates());
          }

          String url = options.getBaseUrl() + token + "/" + GetUpdates.PATH;
          HttpPost httpPost = new HttpPost(url);
          httpPost.addHeader("charset", StandardCharsets.UTF_8.name());
          httpPost.setConfig(requestConfig);
          httpPost.setEntity(
              new StringEntity(
                  objectMapper.writeValueAsString(request), ContentType.APPLICATION_JSON));

          try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
            HttpEntity ht = response.getEntity();
            BufferedHttpEntity buf = new BufferedHttpEntity(ht);
            String responseContent = EntityUtils.toString(buf, StandardCharsets.UTF_8);

            if (response.getStatusLine().getStatusCode() >= 500) {
              BotLogger.warn(LOGTAG, responseContent);
              synchronized (this) {
                this.wait(500);
              }
            } else {
              try {
                List<Update> updates = request.deserializeResponse(responseContent);
                exponentialBackOff.reset();
                if (updates.isEmpty()) {
                  synchronized (this) {
                    this.wait(500);
                  }
                } else {
                  updates.removeIf(x -> x.getUpdateId() < lastReceivedUpdate);
                  lastReceivedUpdate =
                      updates
                          .parallelStream()
                          .map(Update::getUpdateId)
                          .max(Integer::compareTo)
                          .orElse(0);
                  receivedUpdates.addAll(updates);
                  synchronized (receivedUpdates) {
                    receivedUpdates.notifyAll();
                  }
                }
              } catch (JSONException e) {
                BotLogger.severe(responseContent, LOGTAG, e);
              }
            }
          } catch (SocketTimeoutException e) {
            BotLogger.fine(LOGTAG, e);
          } catch (InvalidObjectException | TelegramApiRequestException e) {
            BotLogger.severe(LOGTAG, e);
          }
        } catch (InterruptedException e) {
          if (!running) {
            receivedUpdates.clear();
          }
          BotLogger.debug(LOGTAG, e);
        } catch (Exception global) {
          BotLogger.severe(LOGTAG, global);
          requestConfig =
                  RequestConfig.copy(RequestConfig.custom().build())
                          .setSocketTimeout(SOCKET_TIMEOUT)
                          .setConnectTimeout(SOCKET_TIMEOUT)
                          .setConnectionRequestTimeout(SOCKET_TIMEOUT)
//                          .setProxy(
//                                  new HttpHost(
//                                          options.getProxyHost(),
//                                          options.getProxyPort(),
//                                          options.getProxyType()))
                          .build();
          try {
            synchronized (this) {
              this.wait(exponentialBackOff.nextBackOffMillis());
            }
          } catch (InterruptedException e) {
            if (!running) {
              receivedUpdates.clear();
            }
            BotLogger.debug(LOGTAG, e);
          }
        }
      }
      BotLogger.debug(LOGTAG, "Reader thread has being closed");
    }
  }

  private class HandlerThread extends Thread implements UpdatesHandler {
    @Override
    public void run() {
      setPriority(Thread.MIN_PRIORITY);
      while (running) {
        try {
          Update update = receivedUpdates.pollLast();
          if (update == null) {
            synchronized (receivedUpdates) {
              receivedUpdates.wait();
              update = receivedUpdates.pollLast();
              if (update == null) {
                continue;
              }
            }
          }
          callback.onUpdateReceived(update);
        } catch (InterruptedException e) {
          BotLogger.debug(LOGTAG, e);
        } catch (Exception e) {
          BotLogger.severe(LOGTAG, e);
        }
      }
      BotLogger.debug(LOGTAG, "Handler thread has being closed");
    }
  }

  public interface UpdatesSupplier {

    List<Update> getUpdates() throws Exception;
  }

  public UpdatesSupplier getUpdatesSupplier() {
    return updatesSupplier;
  }

  private List<Update> getUpdateList() {
    List<Update> updates = new ArrayList<>();
    for (Iterator<Update> it = receivedUpdates.iterator(); it.hasNext(); ) {
      updates.add(it.next());
      it.remove();
    }
    return updates;
  }

  public void setUpdatesSupplier(UpdatesSupplier updatesSupplier) {
    this.updatesSupplier = updatesSupplier;
  }
}
