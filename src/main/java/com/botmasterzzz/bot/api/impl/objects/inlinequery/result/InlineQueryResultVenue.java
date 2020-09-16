package com.botmasterzzz.bot.api.impl.objects.inlinequery.result;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultVenue implements InlineQueryResult {

    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String TITLE_FIELD = "title";
    private static final String LATITUDE_FIELD = "latitude";
    private static final String LONGITUDE_FIELD = "longitude";
    private static final String ADDRESS_FIELD = "address";
    private static final String FOURSQUARE_ID_FIELD = "foursquare_id";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String THUMBURL_FIELD = "thumb_url";
    private static final String THUMBWIDTH_FIELD = "thumb_width";
    private static final String THUMBHEIGHT_FIELD = "thumb_height";

    @JsonProperty(TYPE_FIELD)
    private final String type = "venue";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(LATITUDE_FIELD)
    private Float latitude;
    @JsonProperty(LONGITUDE_FIELD)
    private Float longitude;
    @JsonProperty(ADDRESS_FIELD)
    private String address;
    @JsonProperty(FOURSQUARE_ID_FIELD)
    private String foursquareId;
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

    public InlineQueryResultVenue() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultVenue setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultVenue setTitle(String title) {
        this.title = title;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public InlineQueryResultVenue setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public InlineQueryResultVenue setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public InlineQueryResultVenue setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public InlineQueryResultVenue setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultVenue setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultVenue setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultVenue setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public Integer getThumbWidth() {
        return thumbWidth;
    }

    public InlineQueryResultVenue setThumbWidth(Integer thumbWidth) {
        this.thumbWidth = thumbWidth;
        return this;
    }

    public Integer getThumbHeight() {
        return thumbHeight;
    }

    public InlineQueryResultVenue setThumbHeight(Integer thumbHeight) {
        this.thumbHeight = thumbHeight;
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
        if (address == null || address.isEmpty()) {
            throw new TelegramApiValidationException("Longitude parameter can't be empty", this);
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
        return "InlineQueryResultVenue{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", mimeType='" + latitude + '\'' +
                ", documentUrl='" + longitude + '\'' +
                ", thumbHeight=" + thumbHeight +
                ", thumbWidth=" + thumbWidth +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", title='" + title + '\'' +
                ", foursquareId='" + foursquareId + '\'' +
                ", address='" + address + '\'' +
                ", inputMessageContent='" + inputMessageContent + '\'' +
                ", replyMarkup='" + replyMarkup + '\'' +
                '}';
    }
}
