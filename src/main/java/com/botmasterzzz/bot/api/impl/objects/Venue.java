package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Venue implements BotApiObject {
    private static final String LOCATION_FIELD = "location";
    private static final String TITLE_FIELD = "title";
    private static final String ADDRESS_FIELD = "address";
    private static final String FOURSQUARE_ID_FIELD = "foursquare_id";

    @JsonProperty(LOCATION_FIELD)
    private Location location;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(ADDRESS_FIELD)
    private String address;
    @JsonProperty(FOURSQUARE_ID_FIELD)
    private String foursquareId;

    public Venue() {
        super();
    }

    public Location getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "location=" + location +
                ", title=" + title +
                ", address=" + address +
                ", foursquareId=" + foursquareId +
                '}';
    }
}
