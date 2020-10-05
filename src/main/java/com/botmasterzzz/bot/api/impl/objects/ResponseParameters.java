package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseParameters implements BotApiObject {

    private static final String MIGRATETOCHATID_FIELD = "migrate_to_chat_id";
    private static final String RETRYAFTER_FIELD = "retry_after";

    @JsonProperty(MIGRATETOCHATID_FIELD)
    private Long migrateToChatId;

    @JsonProperty(RETRYAFTER_FIELD)
    private Integer retryAfter;

    public ResponseParameters() {
        super();
    }

    public Long getMigrateToChatId() {
        return migrateToChatId;
    }

    public Integer getRetryAfter() {
        return retryAfter;
    }

    @Override
    public String toString() {
        return "ResponseParameters{" +
                "migrateToChatId=" + migrateToChatId +
                ", retryAfter=" + retryAfter +
                '}';
    }
}