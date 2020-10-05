package com.botmasterzzz.bot.api.impl.methods.send;

import com.botmasterzzz.bot.api.impl.methods.PartialBotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.InputFile;
import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ReplyKeyboard;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class SendVideoNote extends PartialBotApiMethod<Message> {
    public static final String PATH = "sendvideonote";

    public static final String CHATID_FIELD = "chat_id";
    public static final String VIDEONOTE_FIELD = "video_note";
    public static final String DURATION_FIELD = "duration";
    public static final String LENGTH_FIELD = "length";
    public static final String DISABLENOTIFICATION_FIELD = "disable_notification";
    public static final String REPLYTOMESSAGEID_FIELD = "reply_to_message_id";
    public static final String REPLYMARKUP_FIELD = "reply_markup";
    public static final String THUMB_FIELD = "thumb";

    private String chatId;
    private InputFile videoNote;
    private Integer duration;
    private Integer length;
    private Boolean disableNotification;
    private Integer replyToMessageId;
    private ReplyKeyboard replyMarkup;

    private InputFile thumb;

    public SendVideoNote() {
        super();
    }


    public SendVideoNote(String chatId, String videoNote) {
        this.chatId = checkNotNull(chatId);
        this.setVideoNote(checkNotNull(videoNote));
    }

    public SendVideoNote(Long chatId, String videoNote) {

        this.chatId = checkNotNull(chatId).toString();
        this.setVideoNote(checkNotNull(videoNote));
    }

    public SendVideoNote(String chatId, File videoNote) {
        this.chatId = checkNotNull(chatId);
        this.setVideoNote(videoNote);
    }

    public SendVideoNote(Integer chatId, File videoNote) {
        this.chatId = checkNotNull(chatId).toString();
        this.setVideoNote(videoNote);
    }

    public SendVideoNote(String chatId, String videoNoteName, InputStream videoNote) {
        this.chatId = checkNotNull(chatId);
        this.setVideoNote(videoNoteName, videoNote);
    }

    public SendVideoNote(Integer chatId, String videoNoteName, InputStream videoNote) {
        this.setVideoNote(videoNoteName, videoNote);
    }

    public String getChatId() {
        return chatId;
    }

    public SendVideoNote setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SendVideoNote setChatId(Long chatId) {
        Objects.requireNonNull(chatId);
        this.chatId = chatId.toString();
        return this;
    }

    public InputFile getVideoNote() {
        return videoNote;
    }

    public SendVideoNote setVideoNote(String videoNote) {
        this.videoNote = new InputFile(videoNote);
        return this;
    }

    public SendVideoNote setVideoNote(InputFile videoNote) {
        Objects.requireNonNull(videoNote, "videoNote cannot be null!");
        this.videoNote = videoNote;
        return this;
    }

    public SendVideoNote setVideoNote(File file) {
        Objects.requireNonNull(file, "file cannot be null!");
        this.videoNote = new InputFile(file, file.getName());
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public SendVideoNote setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SendVideoNote setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public SendVideoNote setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return this;
    }

    public ReplyKeyboard getReplyMarkup() {
        return replyMarkup;
    }

    public SendVideoNote setReplyMarkup(ReplyKeyboard replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public SendVideoNote enableNotification() {
        this.disableNotification = false;
        return this;
    }

    public SendVideoNote disableNotification() {
        this.disableNotification = true;
        return this;
    }

    public SendVideoNote setVideoNote(String videoName, InputStream inputStream) {
        Objects.requireNonNull(videoName, "videoName cannot be null!");
        Objects.requireNonNull(inputStream, "inputStream cannot be null!");
        this.videoNote = new InputFile(inputStream, videoName);
        return this;
    }

    public InputFile getThumb() {
        return thumb;
    }

    public SendVideoNote setThumb(InputFile thumb) {
        this.thumb = thumb;
        return this;
    }

    @Override
    public Message deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Message> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Message>>() {
                    });
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error sending video note", result);
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

        if (videoNote == null) {
            throw new TelegramApiValidationException("VideoNote parameter can't be empty", this);
        }

        videoNote.validate();

        if (thumb != null) {
            thumb.validate();
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "SendVideoNote{" +
                "chatId='" + chatId + '\'' +
                ", videoNote=" + videoNote +
                ", duration=" + duration +
                ", length=" + length +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                ", replyMarkup=" + replyMarkup +
                ", thumb=" + thumb +
                '}';
    }
}