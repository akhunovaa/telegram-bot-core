package com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent;

import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputVenueMessageContent implements InputMessageContent {

    private static final String LATITUDE_FIELD = "latitude";
    private static final String LONGITUDE_FIELD = "longitude";
    private static final String TITLE_FIELD = "title";
    private static final String ADDRESS_FIELD = "address";
    private static final String FOURSQUARE_ID_FIELD = "foursquare_id";

    @JsonProperty(LATITUDE_FIELD)
    private Float latitude;
    @JsonProperty(LONGITUDE_FIELD)
    private Float longitude;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(ADDRESS_FIELD)
    private String address;
    @JsonProperty(FOURSQUARE_ID_FIELD)
    private String foursquareId;

    public InputVenueMessageContent() {
        super();
    }

    public Float getLatitude() {
        return latitude;
    }

    public InputVenueMessageContent setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public InputVenueMessageContent setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InputVenueMessageContent setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public InputVenueMessageContent setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public InputVenueMessageContent setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (latitude == null) {
            throw new TelegramApiValidationException("Latitude parameter can't be empty", this);
        }
        if (longitude == null) {
            throw new TelegramApiValidationException("Longitude parameter can't be empty", this);
        }
        if (title == null || title.isEmpty()) {
            throw new TelegramApiValidationException("Title parameter can't be empty", this);
        }
        if (address == null || address.isEmpty()) {
            throw new TelegramApiValidationException("Address parameter can't be empty", this);
        }
    }

    @Override
    public String toString() {
        return "InputVenueMessageContent{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", foursquareId='" + foursquareId + '\'' +
                '}';
    }
}
