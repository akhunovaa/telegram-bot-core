package com.botmasterzzz.bot.api.impl.objects.payments;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingAddress  implements BotApiObject {

    private static final String COUNTRY_CODE_FIELD = "country_code";
    private static final String STATE_FIELD = "state";
    private static final String CITY_FIELD = "city";
    private static final String STREET_LINE1_FIELD = "street_line1";
    private static final String STREET_LINE2_FIELD = "street_line2";
    private static final String POST_CODE_FIELD = "post_code";

    @JsonProperty(COUNTRY_CODE_FIELD)
    private String countryCode;
    @JsonProperty(STATE_FIELD)
    private String state;
    @JsonProperty(CITY_FIELD)
    private String city;
    @JsonProperty(STREET_LINE1_FIELD)
    private String streetLine1;
    @JsonProperty(STREET_LINE2_FIELD)
    private String streetLine2;
    @JsonProperty(POST_CODE_FIELD)
    private String postCode;

    public ShippingAddress() {
        super();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "countryCode='" + countryCode + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", streetLine1='" + streetLine1 + '\'' +
                ", streetLine2='" + streetLine2 + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
