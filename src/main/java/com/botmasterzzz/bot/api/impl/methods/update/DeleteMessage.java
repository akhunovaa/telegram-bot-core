package com.botmasterzzz.bot.api.impl.methods.update;

import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Objects;

public class DeleteMessage extends BotApiMethod<Boolean> {
    public static final String PATH = "deleteMessage";

    private static final String CHATID_FIELD = "chat_id";
    private static final String MESSAGEID_FIELD = "message_id";

    @JsonProperty(CHATID_FIELD)
    private String chatId;

    @JsonProperty(MESSAGEID_FIELD)
    private Integer messageId;

    public DeleteMessage() {
        super();
    }

    public DeleteMessage(String chatId, Integer messageId) {
        this.chatId = chatId;
        this.messageId = messageId;
    }

    public DeleteMessage(Long chatId, Integer messageId) {
        this.chatId = chatId.toString();
        this.messageId = messageId;
    }

    public String getChatId() {
        return chatId;
    }

    public DeleteMessage setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public DeleteMessage setChatId(Long chatId) {
        Objects.requireNonNull(chatId);
        this.chatId = chatId.toString();
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public DeleteMessage setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Boolean deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Boolean> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Boolean>>() {
                    });
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error deleting message", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (chatId == null) {
            throw new TelegramApiValidationException("ChatId parameter can't be empty", this);
        }
        if (messageId == null) {
            throw new TelegramApiValidationException("MessageId parameter can't be empty", this);
        }
    }

    @Override
    public String toString() {
        return "DeleteMessage{" +
                "chatId='" + chatId + '\'' +
                ", messageId=" + messageId +
                '}';
    }
}
