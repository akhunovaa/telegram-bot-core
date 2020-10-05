package com.botmasterzzz.bot.api.impl.methods.polls;

import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.polls.Poll;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class StopPoll extends BotApiMethod<Poll> {
    public static final String PATH = "stopPoll";

    private static final String CHATID_FIELD = "chat_id";
    private static final String MESSAGEID_FIELD = "message_id";

    @JsonProperty(CHATID_FIELD)
    private String chatId;
    @JsonProperty(MESSAGEID_FIELD)
    private Integer messageId;

    public StopPoll() {
        super();
    }

    public StopPoll(String chatId, Integer messageId) {
        this.chatId = checkNotNull(chatId);
        this.messageId = checkNotNull(messageId);
    }

    public StopPoll(Long chatId, Integer messageId) {
        this.chatId = checkNotNull(chatId).toString();
        this.messageId = checkNotNull(messageId);
    }

    public String getChatId() {
        return chatId;
    }

    public StopPoll setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public StopPoll setChatId(Long chatId) {
        Objects.requireNonNull(chatId);
        this.chatId = chatId.toString();
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public StopPoll setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Poll deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Poll> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Poll>>() {
                    });
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error stopping poll", result);
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
        if (messageId == null || messageId == 0) {
            throw new TelegramApiValidationException("Message Id parameter can't be empty", this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof StopPoll)) {
            return false;
        }
        StopPoll sendMessage = (StopPoll) o;
        return Objects.equals(chatId, sendMessage.chatId)
                && Objects.equals(messageId, sendMessage.messageId)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                chatId,
                messageId);
    }

    @Override
    public String toString() {
        return "StopPoll{" +
                "chatId='" + chatId + '\'' +
                ", messageId=" + messageId +
                '}';
    }
}