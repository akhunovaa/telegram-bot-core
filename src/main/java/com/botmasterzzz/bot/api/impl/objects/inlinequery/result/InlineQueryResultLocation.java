package com.botmasterzzz.bot.api.impl.objects.inlinequery.result;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultLocation implements InlineQueryResult {

    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String TITLE_FIELD = "title";
    private static final String LATITUDE_FIELD = "latitude";
    private static final String LONGITUDE_FIELD = "longitude";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String THUMBURL_FIELD = "thumb_url";
    private static final String THUMBWIDTH_FIELD = "thumb_width";
    private static final String THUMBHEIGHT_FIELD = "thumb_height";
    private static final String LIVEPERIOD_FIELD = "live_period";

    @JsonProperty(TYPE_FIELD)
    private final String type = "location";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(LATITUDE_FIELD)
    private Float latitude;
    @JsonProperty(LONGITUDE_FIELD)
    private Float longitude;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent;
    @JsonProperty(THUMBURL_FIELD)
    private String thumbUrl;
    @JsonProperty(THUMBWIDTH_FIELD)
    private Integer thumbWidth;
    @JsonProperty(THUMBHEIGHT_FIELD)
    private Integer thumbHeight;
    @JsonProperty(LIVEPERIOD_FIELD)
    private Integer livePeriod;

    public InlineQueryResultLocation() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultLocation setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultLocation setTitle(String title) {
        this.title = title;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public InlineQueryResultLocation setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public InlineQueryResultLocation setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultLocation setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultLocation setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultLocation setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public Integer getThumbWidth() {
        return thumbWidth;
    }

    public InlineQueryResultLocation setThumbWidth(Integer thumbWidth) {
        this.thumbWidth = thumbWidth;
        return this;
    }

    public Integer getThumbHeight() {
        return thumbHeight;
    }

    public InlineQueryResultLocation setThumbHeight(Integer thumbHeight) {
        this.thumbHeight = thumbHeight;
        return this;
    }

    public Integer getLivePeriod() {
        return livePeriod;
    }

    public InlineQueryResultLocation setLivePeriod(Integer livePeriod) {
        this.livePeriod = livePeriod;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (title == null || title.isEmpty()) {
            throw new TelegramApiValidationException("Title parameter can't be empty", this);
        }
        if (latitude == null) {
            throw new TelegramApiValidationException("Latitude parameter can't be empty", this);
        }
        if (longitude == null) {
            throw new TelegramApiValidationException("Longitude parameter can't be empty", this);
        }
        if (livePeriod != null && (livePeriod < 60 || livePeriod > 86400)) {
            throw new TelegramApiValidationException("Live period parameter must be between 60 and 86400", this);
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
        return "InlineQueryResultLocation{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", replyMarkup=" + replyMarkup +
                ", inputMessageContent=" + inputMessageContent +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", thumbWidth=" + thumbWidth +
                ", thumbHeight=" + thumbHeight +
                ", livePeriod=" + livePeriod +
                '}';
    }
}
