package com.botmasterzzz.bot.api.impl.methods.send;

import com.botmasterzzz.bot.api.impl.methods.ActionType;
import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Objects;

public class SendChatAction extends BotApiMethod<Boolean> {

    public static final String PATH = "sendChatAction";

    public static final String CHATID_FIELD = "chat_id";
    public static final String ACTION_FIELD = "action";

    @JsonProperty(CHATID_FIELD)
    private String chatId;

    @JsonProperty(ACTION_FIELD)
    private String action;

    public SendChatAction() {
        super();
    }

    public SendChatAction(String chatId, String action) {
        this.chatId = chatId;
        this.action = action;
    }

    public SendChatAction(Long chatId, String action) {
        this.chatId = chatId.toString();
        this.action = action;
    }

    public String getChatId() {
        return chatId;
    }

    public SendChatAction setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SendChatAction setChatId(Long chatId) {
        Objects.requireNonNull(chatId);
        this.chatId = chatId.toString();
        return this;
    }

    @JsonIgnore
    public ActionType getAction() {
        return ActionType.get(action);
    }

    @JsonIgnore
    public SendChatAction setAction(ActionType action) {
        this.action = action.toString();
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
                throw new TelegramApiRequestException("Error sending chat action", result);
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
        if (action == null) {
            throw new TelegramApiValidationException("Action parameter can't be empty", this);
        }
    }

    @Override
    public String toString() {
        return "SendChatAction{" +
                "chatId='" + chatId + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
