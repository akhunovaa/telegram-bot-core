package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseParameters implements BotApiObject {

    private static final String RETRYAFTER_FIELD = "retry_after";

    @JsonProperty(RETRYAFTER_FIELD)
    private Integer retryAfter;

    public ResponseParameters() {
        super();
    }

    public Integer getRetryAfter() {
        return retryAfter;
    }

    @Override
    public String toString() {
        return "ResponseParameters{" +
                "retryAfter=" + retryAfter +
                '}';
    }
}
