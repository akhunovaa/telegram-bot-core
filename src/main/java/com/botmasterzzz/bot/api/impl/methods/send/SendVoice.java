package com.botmasterzzz.bot.api.impl.methods.send;

import com.botmasterzzz.bot.api.impl.methods.PartialBotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.InputFile;
import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ReplyKeyboard;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class SendVoice  extends PartialBotApiMethod<Message> {
    public static final String PATH = "sendvoice";

    public static final String CHATID_FIELD = "chat_id";
    public static final String VOICE_FIELD = "voice";
    public static final String DISABLENOTIFICATION_FIELD = "disable_notification";
    public static final String REPLYTOMESSAGEID_FIELD = "reply_to_message_id";
    public static final String REPLYMARKUP_FIELD = "reply_markup";
    public static final String DURATION_FIELD = "duration";
    public static final String CAPTION_FIELD = "caption";
    public static final String PARSEMODE_FIELD = "parse_mode";

    private String chatId;
    private InputFile voice;
    private Boolean disableNotification;
    private Integer replyToMessageId;
    private ReplyKeyboard replyMarkup;
    private Integer duration;
    private String caption;
    private String parseMode;

    public SendVoice() {
        super();
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public SendVoice enableNotification() {
        this.disableNotification = false;
        return this;
    }

    public SendVoice disableNotification() {
        this.disableNotification = true;
        return this;
    }

    public String getChatId() {
        return chatId;
    }

    public SendVoice setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SendVoice setChatId(Long chatId) {
        Objects.requireNonNull(chatId);
        this.chatId = chatId.toString();
        return this;
    }

    public InputFile getVoice() {
        return voice;
    }

    public SendVoice setVoice(String voice) {
        Objects.requireNonNull(voice, "voice cannot be null!");
        this.voice = new InputFile(voice);
        return this;
    }

    public SendVoice setVoice(File voice) {
        Objects.requireNonNull(voice, "voice cannot be null!");
        this.voice = new InputFile(voice, voice.getName());
        return this;
    }

    public SendVoice setVoice(InputFile voice) {
        Objects.requireNonNull(voice, "voice cannot be null!");
        this.voice = voice;
        return this;
    }

    public SendVoice setVoice(String voiceName, InputStream inputStream) {
        Objects.requireNonNull(voiceName, "voiceName cannot be null!");
        Objects.requireNonNull(inputStream, "inputStream cannot be null!");
        this.voice = new InputFile(inputStream, voiceName);
        return this;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public SendVoice setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return this;
    }

    public ReplyKeyboard getReplyMarkup() {
        return replyMarkup;
    }

    public SendVoice setReplyMarkup(ReplyKeyboard replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SendVoice setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public SendVoice setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public SendVoice setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public Message deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Message> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Message>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error sending voice", result);
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

        if (voice == null) {
            throw new TelegramApiValidationException("Voice parameter can't be empty", this);
        }

        voice.validate();

        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "SendVoice{" +
                "chatId='" + chatId + '\'' +
                ", voice=" + voice +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                ", replyMarkup=" + replyMarkup +
                ", duration=" + duration +
                ", caption='" + caption + '\'' +
                ", parseMode='" + parseMode + '\'' +
                '}';
    }
}
