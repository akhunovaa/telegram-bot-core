package com.botmasterzzz.bot.api.impl.objects.inlinequery;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.Location;
import com.botmasterzzz.bot.api.impl.objects.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChosenInlineQuery implements BotApiObject {

    private static final String RESULTID_FIELD = "result_id";
    private static final String FROM_FIELD = "from";
    private static final String LOCATION_FIELD = "location";
    private static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
    private static final String QUERY_FIELD = "query";

    @JsonProperty(RESULTID_FIELD)
    private String resultId;
    @JsonProperty(FROM_FIELD)
    private User from;
    @JsonProperty(LOCATION_FIELD)
    private Location location;
    @JsonProperty(INLINE_MESSAGE_ID_FIELD)
    private String inlineMessageId;
    @JsonProperty(QUERY_FIELD)
    private String query;

    public ChosenInlineQuery() {
        super();
    }

    public String getResultId() {
        return resultId;
    }

    public User getFrom() {
        return from;
    }

    public Location getLocation() {
        return location;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return "ChosenInlineQuery{" +
                "resultId='" + resultId + '\'' +
                ", from=" + from +
                ", location=" + location +
                ", inlineMessageId=" + inlineMessageId +
                ", query='" + query + '\'' +
                '}';
    }
}