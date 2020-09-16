package com.botmasterzzz.bot.api.impl.objects.inlinequery.result;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultMpeg4Gif implements InlineQueryResult {

    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String MPEG4URL_FIELD = "mpeg4_url";
    private static final String MPEG4WIDTH_FIELD = "mpeg4_width";
    private static final String MPEG4HEIGHT_FIELD = "mpeg4_height";
    private static final String THUMBURL_FIELD = "thumb_url";
    private static final String TITLE_FIELD = "title";
    private static final String CAPTION_FIELD = "caption";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String MPEG4_DURATION_FIELD = "mpeg4_duration";
    private static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(TYPE_FIELD)
    private final String type = "mpeg4_gif";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(MPEG4URL_FIELD)
    private String mpeg4Url;
    @JsonProperty(MPEG4WIDTH_FIELD)
    private Integer mpeg4Width;
    @JsonProperty(MPEG4HEIGHT_FIELD)
    private Integer mpeg4Height;
    @JsonProperty(THUMBURL_FIELD)
    private String thumbUrl;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(CAPTION_FIELD)
    private String caption;
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;
    @JsonProperty(MPEG4_DURATION_FIELD)
    private Integer mpeg4Duration;
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode;

    public InlineQueryResultMpeg4Gif() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultMpeg4Gif setId(String id) {
        this.id = id;
        return this;
    }

    public String getMpeg4Url() {
        return mpeg4Url;
    }

    public InlineQueryResultMpeg4Gif setMpeg4Url(String mpeg4Url) {
        this.mpeg4Url = mpeg4Url;
        return this;
    }

    public Integer getMpeg4Width() {
        return mpeg4Width;
    }

    public InlineQueryResultMpeg4Gif setMpeg4Width(Integer mpeg4Width) {
        this.mpeg4Width = mpeg4Width;
        return this;
    }

    public Integer getMpeg4Height() {
        return mpeg4Height;
    }

    public InlineQueryResultMpeg4Gif setMpeg4Height(Integer mpeg4Height) {
        this.mpeg4Height = mpeg4Height;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultMpeg4Gif setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultMpeg4Gif setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultMpeg4Gif setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultMpeg4Gif setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultMpeg4Gif setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public Integer getMpeg4Duration() {
        return mpeg4Duration;
    }

    public InlineQueryResultMpeg4Gif setMpeg4Duration(Integer mpeg4Duration) {
        this.mpeg4Duration = mpeg4Duration;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public InlineQueryResultMpeg4Gif setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (mpeg4Url == null || mpeg4Url.isEmpty()) {
            throw new TelegramApiValidationException("Mpeg4Url parameter can't be empty", this);
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
        return "InlineQueryResultMpeg4Gif{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", mpeg4Url='" + mpeg4Url + '\'' +
                ", mpeg4Width=" + mpeg4Width +
                ", mpeg4Height=" + mpeg4Height +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", title='" + title + '\'' +
                ", caption='" + caption + '\'' +
                ", inputMessageContent=" + inputMessageContent +
                ", replyMarkup=" + replyMarkup +
                ", mpeg4Duration=" + mpeg4Duration +
                ", parseMode='" + parseMode + '\'' +
                '}';
    }
}
