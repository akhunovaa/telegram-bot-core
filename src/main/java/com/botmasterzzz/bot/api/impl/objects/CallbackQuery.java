package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CallbackQuery implements BotApiObject {

    private static final String ID_FIELD = "id";
    private static final String FROM_FIELD = "from";
    private static final String MESSAGE_FIELD = "message";
    private static final String DATA_FIELD = "data";

    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(FROM_FIELD)
    private User from;
    @JsonProperty(MESSAGE_FIELD)
    private Message message;
    @JsonProperty(DATA_FIELD)
    private String data;

    public CallbackQuery() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public User getFrom() {
        return this.from;
    }

    public Message getMessage() {
        return this.message;
    }


    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CallbackQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", message=" + message +
                ", data='" + data + '\'' +
                '}';
    }
}
