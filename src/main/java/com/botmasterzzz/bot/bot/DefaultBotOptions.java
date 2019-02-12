package com.botmasterzzz.bot.bot;

import com.botmasterzzz.bot.Constants;
import com.botmasterzzz.bot.generic.BotOptions;
import com.botmasterzzz.bot.updatesreceivers.ExponentialBackOff;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;

import java.util.List;

public class DefaultBotOptions implements BotOptions {
  private int maxThreads;
  private RequestConfig requestConfig;
  private volatile HttpContext httpContext;
  private ExponentialBackOff exponentialBackOff;
  private Integer maxWebhookConnections;
  private String baseUrl;
  private List<String> allowedUpdates;
  private ProxyType proxyType;
  private String proxyHost;
  private int proxyPort;

  public enum ProxyType {
    NO_PROXY,
    HTTP
  }

  public DefaultBotOptions() {
    maxThreads = 1;
    baseUrl = Constants.BASE_URL;
    httpContext = HttpClientContext.create();
    proxyType = ProxyType.NO_PROXY;
  }

  @Override
  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public void setMaxThreads(int maxThreads) {
    this.maxThreads = maxThreads;
  }

  public int getMaxThreads() {
    return maxThreads;
  }

  public RequestConfig getRequestConfig() {
    return requestConfig;
  }

  public Integer getMaxWebhookConnections() {
    return maxWebhookConnections;
  }

  public HttpContext getHttpContext() {
    return httpContext;
  }

  public void setHttpContext(HttpContext httpContext) {
    this.httpContext = httpContext;
  }

  public void setMaxWebhookConnections(Integer maxWebhookConnections) {
    this.maxWebhookConnections = maxWebhookConnections;
  }

  public List<String> getAllowedUpdates() {
    return allowedUpdates;
  }

  public void setAllowedUpdates(List<String> allowedUpdates) {
    this.allowedUpdates = allowedUpdates;
  }

  public void setRequestConfig(RequestConfig requestConfig) {
    this.requestConfig = requestConfig;
  }

  public ExponentialBackOff getExponentialBackOff() {
    return exponentialBackOff;
  }

  public void setExponentialBackOff(ExponentialBackOff exponentialBackOff) {
    this.exponentialBackOff = exponentialBackOff;
  }

  public String getProxyType() {
    return proxyType.name().toUpperCase();
  }

  public void setProxyType(ProxyType proxyType) {
    this.proxyType = proxyType;
  }

  public String getProxyHost() {
    return proxyHost;
  }

  public void setProxyHost(String proxyHost) {
    this.proxyHost = proxyHost;
  }

  public int getProxyPort() {
    return proxyPort;
  }

  public void setProxyPort(int proxyPort) {
    this.proxyPort = proxyPort;
  }
}
