package com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent;

import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

@JsonDeserialize
public class InputLocationMessageContent implements InputMessageContent {

    private static final String LATITUDE_FIELD = "latitude";
    private static final String LONGITUDE_FIELD = "longitude";
    private static final String LIVEPERIOD_FIELD = "live_period";

    @JsonProperty(LATITUDE_FIELD)
    private Float latitude;
    @JsonProperty(LONGITUDE_FIELD)
    private Float longitude;
    @JsonProperty(LIVEPERIOD_FIELD)
    private Integer livePeriod;

    public InputLocationMessageContent() {
        super();
    }

    public InputLocationMessageContent(Float latitude, Float longitude) {
        super();
        this.latitude = checkNotNull(latitude);
        this.longitude = checkNotNull(longitude);
    }

    public Float getLongitude() {
        return longitude;
    }

    public InputLocationMessageContent setLongitude(Float longitude) {
        Objects.requireNonNull(longitude);
        this.longitude = longitude;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public InputLocationMessageContent setLatitude(Float latitude) {
        Objects.requireNonNull(latitude);
        this.latitude = latitude;
        return this;
    }

    public Integer getLivePeriod() {
        return livePeriod;
    }

    public InputLocationMessageContent setLivePeriod(Integer livePeriod) {
        this.livePeriod = livePeriod;
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
        if (livePeriod != null && (livePeriod < 60 || livePeriod > 86400)) {
            throw new TelegramApiValidationException("Live period parameter must be between 60 and 86400", this);
        }
    }

    @Override
    public String toString() {
        return "InputLocationMessageContent{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", livePeriod=" + livePeriod +
                '}';
    }
}
