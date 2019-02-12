package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.Serializable;

public class StopMessageLiveLocation extends BotApiMethod<Serializable> {
    public static final String PATH = "stopMessageLiveLocation";

    private static final String CHATID_FIELD = "chat_id";
    private static final String MESSAGEID_FIELD = "message_id";
    private static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
    private static final String REPLYMARKUP_FIELD = "reply_markup";

    @JsonProperty(CHATID_FIELD)
    private String chatId;

    @JsonProperty(MESSAGEID_FIELD)
    private Integer messageId;

    @JsonProperty(INLINE_MESSAGE_ID_FIELD)
    private String inlineMessageId;
    @JsonProperty(REPLYMARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;

    public StopMessageLiveLocation() {
        super();
    }

    public String getChatId() {
        return chatId;
    }

    public StopMessageLiveLocation setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public StopMessageLiveLocation setChatId(Long chatId) {
        this.chatId = chatId.toString();
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public StopMessageLiveLocation setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public StopMessageLiveLocation setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public StopMessageLiveLocation setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Serializable deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Message> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Message>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error stopping message live location", result);
            }
        } catch (IOException e) {
            try {
                ApiResponse<Boolean> result = OBJECT_MAPPER.readValue(answer,
                        new TypeReference<ApiResponse<Boolean>>() {
                        });
                if (result.getOk()) {
                    return result.getResult();
                } else {
                    throw new TelegramApiRequestException("Error stopping message live location", result);
                }
            } catch (IOException e2) {
                throw new TelegramApiRequestException("Unable to deserialize response", e);
            }
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (inlineMessageId == null) {
            if (chatId == null) {
                throw new TelegramApiValidationException("ChatId parameter can't be empty if inlineMessageId is not present", this);
            }
            if (messageId == null) {
                throw new TelegramApiValidationException("MessageId parameter can't be empty if inlineMessageId is not present", this);
            }
        } else {
            if (chatId != null) {
                throw new TelegramApiValidationException("ChatId parameter must be empty if inlineMessageId is provided", this);
            }
            if (messageId != null) {
                throw new TelegramApiValidationException("MessageId parameter must be empty if inlineMessageId is provided", this);
            }
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "StopMessageLiveLocation{" +
                "chatId='" + chatId + '\'' +
                ", messageId=" + messageId +
                ", inlineMessageId='" + inlineMessageId + '\'' +
                ", replyMarkup=" + replyMarkup +
                '}';
    }
}
