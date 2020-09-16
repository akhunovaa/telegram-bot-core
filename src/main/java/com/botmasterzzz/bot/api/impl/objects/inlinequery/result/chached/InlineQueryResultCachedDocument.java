package com.botmasterzzz.bot.api.impl.objects.inlinequery.result.chached;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.result.InlineQueryResult;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultCachedDocument implements InlineQueryResult {

    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String TITLE_FIELD = "title";
    private static final String DOCUMENT_FILE_ID_FIELD = "document_file_id";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String CAPTION_FIELD = "caption";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(TYPE_FIELD)
    private final String type = "document";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(DOCUMENT_FILE_ID_FIELD)
    private String documentFileId;
    @JsonProperty(DESCRIPTION_FIELD)
    private String description;
    @JsonProperty(CAPTION_FIELD)
    private String caption;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent;
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode;

    public InlineQueryResultCachedDocument() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultCachedDocument setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultCachedDocument setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDocumentFileId() {
        return documentFileId;
    }

    public InlineQueryResultCachedDocument setDocumentFileId(String documentFileId) {
        this.documentFileId = documentFileId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InlineQueryResultCachedDocument setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultCachedDocument setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultCachedDocument setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultCachedDocument setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public InlineQueryResultCachedDocument setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (documentFileId == null || documentFileId.isEmpty()) {
            throw new TelegramApiValidationException("DocumentFileId parameter can't be empty", this);
        }
        if (title == null || title.isEmpty()) {
            throw new TelegramApiValidationException("Title parameter can't be empty", this);
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
        return "InlineQueryResultCachedDocument{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", documentFileId='" + documentFileId + '\'' +
                ", description='" + description + '\'' +
                ", caption='" + caption + '\'' +
                ", replyMarkup=" + replyMarkup +
                ", inputMessageContent=" + inputMessageContent +
                ", parseMode='" + parseMode + '\'' +
                '}';
    }
}
