package com.botmasterzzz.bot.bot;

import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.api.impl.methods.send.SendPhoto;
import com.botmasterzzz.bot.api.impl.objects.InputFile;
import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.exceptions.TelegramApiException;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.botmasterzzz.bot.updatehandlers.SentCallback;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.botmasterzzz.bot.Constants.SOCKET_TIMEOUT;

public abstract class DefaultSender extends Sender{

    private static final ContentType TEXT_PLAIN_CONTENT_TYPE = ContentType.create("text/plain", StandardCharsets.UTF_8);

    private final ExecutorService exe;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final DefaultBotOptions options;
    private volatile CloseableHttpClient httpclient;
    private volatile RequestConfig requestConfig;

    protected DefaultSender(DefaultBotOptions options) {
        super();
        this.exe = Executors.newFixedThreadPool(options.getMaxThreads());
        this.options = options;
        httpclient = HttpClientBuilder.create()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .setConnectionTimeToLive(70, TimeUnit.SECONDS)
                .setMaxConnTotal(100)
                .build();

        requestConfig = options.getRequestConfig();

        if (requestConfig == null) {
            requestConfig = RequestConfig.copy(RequestConfig.custom().build())
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .setConnectTimeout(SOCKET_TIMEOUT)
                    .setConnectionRequestTimeout(SOCKET_TIMEOUT)
//                    .setProxy(new HttpHost(options.getProxyHost(), options.getProxyPort(), options.getProxyType()))
                    .build();
        }
    }

    public abstract String getBotToken();

    public final DefaultBotOptions getOptions() {
        return options;
    }

    @Override
    public final Message execute(SendPhoto sendPhoto) throws TelegramApiException {
        assertParamNotNull(sendPhoto, "sendPhoto");

        sendPhoto.validate();
        try {
            String url = getBaseUrl() + SendPhoto.PATH;
            HttpPost httppost = configuredHttpPost(url);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setLaxMode();
            builder.setCharset(StandardCharsets.UTF_8);
            builder.addTextBody(SendPhoto.CHATID_FIELD, sendPhoto.getChatId(), TEXT_PLAIN_CONTENT_TYPE);
            addInputFile(builder, sendPhoto.getPhoto(), SendPhoto.PHOTO_FIELD, true);

            if (sendPhoto.getReplyMarkup() != null) {
                builder.addTextBody(SendPhoto.REPLYMARKUP_FIELD, objectMapper.writeValueAsString(sendPhoto.getReplyMarkup()), TEXT_PLAIN_CONTENT_TYPE);
            }
            if (sendPhoto.getReplyToMessageId() != null) {
                builder.addTextBody(SendPhoto.REPLYTOMESSAGEID_FIELD, sendPhoto.getReplyToMessageId().toString(), TEXT_PLAIN_CONTENT_TYPE);
            }
            if (sendPhoto.getCaption() != null) {
                builder.addTextBody(SendPhoto.CAPTION_FIELD, sendPhoto.getCaption(), TEXT_PLAIN_CONTENT_TYPE);
                if (sendPhoto.getParseMode() != null) {
                    builder.addTextBody(SendPhoto.PARSEMODE_FIELD, sendPhoto.getParseMode(), TEXT_PLAIN_CONTENT_TYPE);
                }
            }
            if (sendPhoto.getDisableNotification() != null) {
                builder.addTextBody(SendPhoto.DISABLENOTIFICATION_FIELD, sendPhoto.getDisableNotification().toString(), TEXT_PLAIN_CONTENT_TYPE);
            }
            HttpEntity multipart = builder.build();
            httppost.setEntity(multipart);

            return sendPhoto.deserializeResponse(sendHttpPostRequest(httppost));
        } catch (IOException e) {
            throw new TelegramApiException("Unable to send photo", e);
        }
    }

    @Override
    protected final <T extends Serializable, Method extends BotApiMethod<T>, Callback extends SentCallback<T>> void sendApiMethodAsync(Method method, Callback callback) {
        //noinspection Convert2Lambda
        exe.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String responseContent = sendMethodRequest(method);
                    try {
                        callback.onResult(method, method.deserializeResponse(responseContent));
                    } catch (TelegramApiRequestException e) {
                        callback.onError(method, e);
                    }
                } catch (IOException | TelegramApiValidationException e) {
                    callback.onException(method, e);
                }

            }
        });
    }

    @Override
    protected final <T extends Serializable, Method extends BotApiMethod<T>> T sendApiMethod(Method method) throws TelegramApiException {
        try {
            String responseContent = sendMethodRequest(method);
            return method.deserializeResponse(responseContent);
        } catch (IOException e) {
            throw new TelegramApiException("Unable to execute " + method.getMethod() + " method", e);
        }
    }

    private <T extends Serializable, Method extends BotApiMethod<T>> String sendMethodRequest(Method method) throws TelegramApiValidationException, IOException {
        method.validate();
        String url = getBaseUrl() + method.getMethod();
        HttpPost httppost = configuredHttpPost(url);
        httppost.addHeader("charset", StandardCharsets.UTF_8.name());
        httppost.setEntity(new StringEntity(objectMapper.writeValueAsString(method), ContentType.APPLICATION_JSON));
        return sendHttpPostRequest(httppost);
    }

    private String sendHttpPostRequest(HttpPost httppost) throws IOException {
        try (CloseableHttpResponse response = httpclient.execute(httppost)) {
            HttpEntity ht = response.getEntity();
            BufferedHttpEntity buf = new BufferedHttpEntity(ht);
            return EntityUtils.toString(buf, StandardCharsets.UTF_8);
        }
    }

    private HttpPost configuredHttpPost(String url) {
        HttpPost httppost = new HttpPost(url);
        httppost.setConfig(requestConfig);
        return httppost;
    }

    private void addInputFile(MultipartEntityBuilder builder, InputFile file, String fileField, boolean addField) {
        if (file.isNew()) {
            if (file.getNewMediaFile() != null) {
                builder.addBinaryBody(file.getMediaName(), file.getNewMediaFile(), ContentType.APPLICATION_OCTET_STREAM, file.getMediaName());
            } else if (file.getNewMediaStream() != null) {
                builder.addBinaryBody(file.getMediaName(), file.getNewMediaStream(), ContentType.APPLICATION_OCTET_STREAM, file.getMediaName());
            }
        }

        if (addField) {
            builder.addTextBody(fileField, file.getAttachName(), TEXT_PLAIN_CONTENT_TYPE);
        }
    }

    protected String getBaseUrl() {
        return options.getBaseUrl() + getBotToken() + "/";
    }

    private void assertParamNotNull(Object param, String paramName) throws TelegramApiException {
        if (param == null) {
            throw new TelegramApiException("Parameter " + paramName + " can not be null");
        }
    }


}
