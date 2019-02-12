package com.botmasterzzz.bot.api.impl.objects.payments;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderInfo implements BotApiObject {
    private static final String NAME_FIELD = "name";
    private static final String PHONE_NUMBER_FIELD = "phone_number";
    private static final String EMAIL_FIELD = "email";
    private static final String SHIPPING_ADDRESS_FIELD = "shipping_address";

    @JsonProperty(NAME_FIELD)
    private String name;
    @JsonProperty(PHONE_NUMBER_FIELD)
    private String phoneNumber;
    @JsonProperty(EMAIL_FIELD)
    private String email;
    @JsonProperty(SHIPPING_ADDRESS_FIELD)
    private ShippingAddress shippingAddress;

    public OrderInfo() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", shippingAddress=" + shippingAddress +
                '}';
    }

}
