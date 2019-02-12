package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageEntity implements BotApiObject {
    private static final String TYPE_FIELD = "type";
    private static final String OFFSET_FIELD = "offset";
    private static final String LENGTH_FIELD = "length";
    private static final String URL_FIELD = "url";
    private static final String USER_FIELD = "user";
    @JsonProperty(TYPE_FIELD)
    private String type;
    @JsonProperty(OFFSET_FIELD)
    private Integer offset;
    @JsonProperty(LENGTH_FIELD)
    private Integer length;
    @JsonProperty(URL_FIELD)
    private String url;
    @JsonProperty(USER_FIELD)
    private User user;
    @JsonIgnore
    private String text;

    public MessageEntity() {
        super();
    }

    public String getType() {
        return type;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLength() {
        return length;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    protected void computeText(String message) {
        if (message != null) {
            text = message.substring(offset, offset + length);
        }
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "type='" + type + '\'' +
                ", offset=" + offset +
                ", length=" + length +
                ", url=" + url +
                ", user=" + user +
                '}';
    }
}
