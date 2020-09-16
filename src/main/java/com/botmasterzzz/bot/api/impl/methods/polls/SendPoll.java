package com.botmasterzzz.bot.api.impl.methods.polls;

import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ReplyKeyboard;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class SendPoll extends BotApiMethod<Message> {
    public static final String PATH = "sendPoll";

    private static final String CHATID_FIELD = "chat_id";
    private static final String QUESTION_FIELD = "question";
    private static final String OPTIONS_FIELD = "options";
    private static final String DISABLENOTIFICATION_FIELD = "disable_notification";
    private static final String REPLYTOMESSAGEID_FIELD = "reply_to_message_id";
    private static final String REPLYMARKUP_FIELD = "reply_markup";


    @JsonProperty(CHATID_FIELD)
    private String chatId;
    @JsonProperty(QUESTION_FIELD)
    private String question;
    @JsonProperty(OPTIONS_FIELD)
    private List<String> options;
    @JsonProperty(DISABLENOTIFICATION_FIELD)
    private Boolean disableNotification;
    @JsonProperty(REPLYTOMESSAGEID_FIELD)
    private Integer replyToMessageId;
    @JsonProperty(REPLYMARKUP_FIELD)
    private ReplyKeyboard replyMarkup;

    public SendPoll() {
        super();
    }

    public SendPoll(String chatId, String question, List<String> options) {
        this.chatId = checkNotNull(chatId);
        this.question = checkNotNull(question);
        this.options = checkNotNull(options);
    }

    public SendPoll(Long chatId, String question, List<String> options) {
        this.chatId = checkNotNull(chatId).toString();
        this.question = checkNotNull(question);
        this.options = checkNotNull(options);
    }

    public String getChatId() {
        return chatId;
    }

    public SendPoll setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SendPoll setChatId(Long chatId) {
        Objects.requireNonNull(chatId);
        this.chatId = chatId.toString();
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public SendPoll setQuestion(String question) {
        this.question = question;
        return this;
    }

    public List<String> getOptions() {
        return options;
    }

    public SendPoll setOptions(List<String> options) {
        this.options = options;
        return this;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public SendPoll setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return this;
    }

    public ReplyKeyboard getReplyMarkup() {
        return replyMarkup;
    }

    public SendPoll setReplyMarkup(ReplyKeyboard replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }


    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public SendPoll enableNotification() {
        this.disableNotification = null;
        return this;
    }

    public SendPoll disableNotification() {
        this.disableNotification = true;
        return this;
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Message deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Message> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Message>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error sending poll", result);
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
        if (question == null || question.isEmpty()) {
            throw new TelegramApiValidationException("Question parameter can't be empty", this);
        }
        if (options == null || options.isEmpty()) {
            throw new TelegramApiValidationException("Options parameter can't be empty", this);
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof SendPoll)) {
            return false;
        }
        SendPoll sendMessage = (SendPoll) o;
        return Objects.equals(chatId, sendMessage.chatId)
                && Objects.equals(disableNotification, sendMessage.disableNotification)
                && Objects.equals(question, sendMessage.question)
                && Objects.equals(options, sendMessage.options)
                && Objects.equals(replyMarkup, sendMessage.replyMarkup)
                && Objects.equals(replyToMessageId, sendMessage.replyToMessageId)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                chatId,
                disableNotification,
                options,
                replyMarkup,
                replyToMessageId,
                question);
    }

    @Override
    public String toString() {
        return "SendPoll{" +
                "chatId='" + chatId + '\'' +
                ", question='" + question + '\'' +
                ", options=" + options +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                ", replyMarkup=" + replyMarkup +
                '}';
    }
}