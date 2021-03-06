package com.botmasterzzz.bot.api.impl.objects.inlinequery.result;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class InlineQueryResultGif implements InlineQueryResult {
    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String GIFURL_FIELD = "gif_url";
    private static final String GIFWIDTH_FIELD = "gif_width";
    private static final String GIFHEIGHT_FIELD = "gif_height";
    private static final String THUMBURL_FIELD = "thumb_url";
    private static final String TITLE_FIELD = "title";
    private static final String CAPTION_FIELD = "caption";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String GIF_DURATION_FIELD = "gif_duration";
    private static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(TYPE_FIELD)
    private final String type = "gif";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(GIFURL_FIELD)
    private String gifUrl;
    @JsonProperty(GIFWIDTH_FIELD)
    private Integer gifWidth;
    @JsonProperty(GIFHEIGHT_FIELD)
    private Integer gifHeight;
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
    @JsonProperty(GIF_DURATION_FIELD)
    private Integer gifDuration;
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode;

    public InlineQueryResultGif() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultGif setId(String id) {
        this.id = id;
        return this;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public InlineQueryResultGif setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
        return this;
    }

    public Integer getGifWidth() {
        return gifWidth;
    }

    public InlineQueryResultGif setGifWidth(Integer gifWidth) {
        this.gifWidth = gifWidth;
        return this;
    }

    public Integer getGifHeight() {
        return gifHeight;
    }

    public InlineQueryResultGif setGifHeight(Integer gifHeight) {
        this.gifHeight = gifHeight;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultGif setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultGif setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultGif setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultGif setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultGif setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public Integer getGifDuration() {
        return gifDuration;
    }

    public InlineQueryResultGif setGifDuration(Integer gifDuration) {
        this.gifDuration = gifDuration;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public InlineQueryResultGif setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (gifUrl == null || gifUrl.isEmpty()) {
            throw new TelegramApiValidationException("GifUrl parameter can't be empty", this);
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
        return "InlineQueryResultGif{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", gifUrl='" + gifUrl + '\'' +
                ", gifWidth=" + gifWidth +
                ", gifHeight=" + gifHeight +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", title='" + title + '\'' +
                ", caption='" + caption + '\'' +
                ", inputMessageContent=" + inputMessageContent +
                ", replyMarkup=" + replyMarkup +
                ", gifDuration=" + gifDuration +
                ", parseMode='" + parseMode + '\'' +
                '}';
    }
}
