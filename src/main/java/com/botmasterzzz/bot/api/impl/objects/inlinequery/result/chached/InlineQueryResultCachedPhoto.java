package com.botmasterzzz.bot.api.impl.objects.inlinequery.result.chached;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.result.InlineQueryResult;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultCachedPhoto implements InlineQueryResult {
    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String PHOTOFILEID_FIELD = "photo_file_id";
    private static final String TITLE_FIELD = "title";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String CAPTION_FIELD = "caption";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(TYPE_FIELD)
    private final String type = "photo";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(PHOTOFILEID_FIELD)
    private String photoFileId;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(DESCRIPTION_FIELD)
    private String description;
    @JsonProperty(CAPTION_FIELD)
    private String caption;
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode;

    public InlineQueryResultCachedPhoto() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultCachedPhoto setId(String id) {
        this.id = id;
        return this;
    }

    public String getPhotoFileId() {
        return photoFileId;
    }

    public InlineQueryResultCachedPhoto setPhotoFileId(String photoFileId) {
        this.photoFileId = photoFileId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultCachedPhoto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InlineQueryResultCachedPhoto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultCachedPhoto setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultCachedPhoto setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultCachedPhoto setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public InlineQueryResultCachedPhoto setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (photoFileId == null || photoFileId.isEmpty()) {
            throw new TelegramApiValidationException("PhotoFileId parameter can't be empty", this);
        }
        if (inputMessageContent != null) {
            inputMessageContent.validate();
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "InlineQueryResultCachedPhoto{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", photoFileId='" + photoFileId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", caption='" + caption + '\'' +
                ", inputMessageContent=" + inputMessageContent +
                ", replyMarkup=" + replyMarkup +
                ", parseMode='" + parseMode + '\'' +
                '}';
    }
}
