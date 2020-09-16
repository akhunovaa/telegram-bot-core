package com.botmasterzzz.bot.api.impl.objects.inlinequery;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.Location;
import com.botmasterzzz.bot.api.impl.objects.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQuery implements BotApiObject {
    private static final String ID_FIELD = "id";
    private static final String FROM_FIELD = "from";
    private static final String LOCATION_FIELD = "location";
    private static final String QUERY_FIELD = "query";
    private static final String OFFSET_FIELD = "offset";

    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(FROM_FIELD)
    private User from;
    @JsonProperty(LOCATION_FIELD)
    private Location location;
    @JsonProperty(QUERY_FIELD)
    private String query;
    @JsonProperty(OFFSET_FIELD)
    private String offset;

    public InlineQuery() {
        super();
    }

    public String getId() {
        return id;
    }

    public User getFrom() {
        return from;
    }

    public Location getLocation() {
        return location;
    }

    public String getQuery() {
        return query;
    }

    public String getOffset() {
        return offset;
    }

    public boolean hasQuery() {
        return query != null && !query.isEmpty();
    }

    public boolean hasLocation() {
        return location != null;
    }

    @Override
    public String toString() {
        return "InlineQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", location=" + location +
                ", query='" + query + '\'' +
                ", offset='" + offset + '\'' +
                '}';
    }
}
