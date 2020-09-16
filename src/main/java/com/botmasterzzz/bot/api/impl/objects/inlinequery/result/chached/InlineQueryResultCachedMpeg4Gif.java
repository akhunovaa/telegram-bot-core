package com.botmasterzzz.bot.api.impl.objects.inlinequery.result.chached;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.result.InlineQueryResult;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultCachedMpeg4Gif implements InlineQueryResult {

    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String MPEG4_FILE_ID_FIELD = "mpeg4_file_id";
    private static final String TITLE_FIELD = "title";
    private static final String CAPTION_FIELD = "caption";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(TYPE_FIELD)
    private final String type = "mpeg4_gif";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(MPEG4_FILE_ID_FIELD)
    private String mpeg4FileId;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(CAPTION_FIELD)
    private String caption;
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode;

    public InlineQueryResultCachedMpeg4Gif() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultCachedMpeg4Gif setId(String id) {
        this.id = id;
        return this;
    }

    public String getMpeg4FileId() {
        return mpeg4FileId;
    }

    public InlineQueryResultCachedMpeg4Gif setMpeg4FileId(String mpeg4FileId) {
        this.mpeg4FileId = mpeg4FileId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultCachedMpeg4Gif setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultCachedMpeg4Gif setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultCachedMpeg4Gif setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultCachedMpeg4Gif setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public InlineQueryResultCachedMpeg4Gif setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (mpeg4FileId == null || mpeg4FileId.isEmpty()) {
            throw new TelegramApiValidationException("Mpeg4FileId parameter can't be empty", this);
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
        return "InlineQueryResultCachedMpeg4Gif{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", mpeg4FileId='" + mpeg4FileId + '\'' +
                ", title='" + title + '\'' +
                ", caption='" + caption + '\'' +
                ", inputMessageContent=" + inputMessageContent +
                ", replyMarkup=" + replyMarkup +
                ", parseMode='" + parseMode + '\'' +
                '}';
    }
}
