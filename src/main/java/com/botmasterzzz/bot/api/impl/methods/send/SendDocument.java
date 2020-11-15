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

public class SendDocument extends PartialBotApiMethod<Message> {

    public static final String PATH = "senddocument";

    public static final String CHATID_FIELD = "chat_id";
    public static final String DOCUMENT_FIELD = "document";
    public static final String CAPTION_FIELD = "caption";
    public static final String DISABLENOTIFICATION_FIELD = "disable_notification";
    public static final String REPLYTOMESSAGEID_FIELD = "reply_to_message_id";
    public static final String REPLYMARKUP_FIELD = "reply_markup";
    public static final String PARSEMODE_FIELD = "parse_mode";
    public static final String THUMB_FIELD = "thumb";

    private String chatId;
    private InputFile document;
    private String caption;
    private Boolean disableNotification;
    private Integer replyToMessageId;
    private ReplyKeyboard replyMarkup;
    private String parseMode;
    private String mediaName;

    private InputFile thumb;

    public SendDocument() {
        super();
    }

    public String getChatId() {
        return chatId;
    }

    public SendDocument setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SendDocument setChatId(Long chatId) {
        Objects.requireNonNull(chatId);
        this.chatId = chatId.toString();
        return this;
    }

    public InputFile getDocument() {
        return document;
    }

    public SendDocument setDocument(String document) {
        this.document = new InputFile(document);
        return this;
    }

    public SendDocument setDocumentFile(File file) {
        Objects.requireNonNull(file, "documentName cannot be null!");
        this.document = new InputFile(file, file.getName());
        return this;
    }

    public SendDocument setDocumentInput(InputFile document) {
        Objects.requireNonNull(document, "document cannot be null!");
        this.document = document;
        return this;
    }

    public SendDocument setDocumentOverLoaded(String documentName, InputStream inputStream) {
        Objects.requireNonNull(documentName, "documentName cannot be null!");
        Objects.requireNonNull(inputStream, "inputStream cannot be null!");
        this.document = new InputFile(inputStream, documentName);
        return this;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public SendDocument setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return this;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public SendDocument enableNotification() {
        this.disableNotification = false;
        return this;
    }

    public SendDocument disableNotification() {
        this.disableNotification = true;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public SendDocument setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public ReplyKeyboard getReplyMarkup() {
        return replyMarkup;
    }

    public SendDocument setReplyMarkup(ReplyKeyboard replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public SendDocument setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public InputFile getThumb() {
        return thumb;
    }

    public SendDocument setThumb(InputFile thumb) {
        this.thumb = thumb;
        return this;
    }

    public SendDocument setThumb(String thumb) {
        this.thumb = new InputFile(thumb);
        return this;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
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
                throw new TelegramApiRequestException("Error sending document", result);
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

        if (document == null) {
            throw new TelegramApiValidationException("Document parameter can't be empty", this);
        }

        document.validate();

        if (thumb != null) {
            thumb.validate();
        }

        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "SendDocument{" +
                "chatId='" + chatId + '\'' +
                ", document=" + document +
                ", caption='" + caption + '\'' +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                ", replyMarkup=" + replyMarkup +
                ", parseMode='" + parseMode + '\'' +
                ", mediaName='" + mediaName + '\'' +
                ", thumb=" + thumb +
                '}';
    }
}
