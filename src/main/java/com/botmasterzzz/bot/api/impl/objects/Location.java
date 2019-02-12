package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location implements BotApiObject {

    private static final String LONGITUDE_FIELD = "longitude";
    private static final String LATITUDE_FIELD = "latitude";

    @JsonProperty(LONGITUDE_FIELD)
    private Float longitude;
    @JsonProperty(LATITUDE_FIELD)
    private Float latitude;

    public Location() {
        super();
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
