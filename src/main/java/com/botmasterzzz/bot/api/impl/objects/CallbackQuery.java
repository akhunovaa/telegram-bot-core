package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CallbackQuery implements BotApiObject {

    private static final String ID_FIELD = "id";
    private static final String FROM_FIELD = "from";
    private static final String MESSAGE_FIELD = "message";
    private static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
    private static final String DATA_FIELD = "data";
    private static final String GAMESHORTNAME_FIELD = "game_short_name";
    private static final String CHAT_INSTANCE_FIELD = "chat_instance";

    @JsonProperty(ID_FIELD)
    private String id; ///< Unique identifier for this query
    @JsonProperty(FROM_FIELD)
    private User from; ///< Sender

    @JsonProperty(MESSAGE_FIELD)
    private Message message;
    @JsonProperty(INLINE_MESSAGE_ID_FIELD)
    private String inlineMessageId; ///< Optional. Identifier of the message sent via the bot in inline mode, that originated the query

    @JsonProperty(DATA_FIELD)
    private String data;

    @JsonProperty(GAMESHORTNAME_FIELD)
    private String gameShortName;

    @JsonProperty(CHAT_INSTANCE_FIELD)
    private String chatInstance;

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

    public String getInlineMessageId() {
        return this.inlineMessageId;
    }

    public String getData() {
        return data;
    }

    public String getGameShortName() {
        return gameShortName;
    }

    public String getChatInstance() {
        return chatInstance;
    }

    @Override
    public String toString() {
        return "CallbackQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", message=" + message +
                ", inlineMessageId='" + inlineMessageId + '\'' +
                ", data='" + data + '\'' +
                ", gameShortName='" + gameShortName + '\'' +
                ", chatInstance='" + chatInstance + '\'' +
                '}';
    }
}
