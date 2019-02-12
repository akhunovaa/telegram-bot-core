package com.botmasterzzz.bot.api.impl.objects.payments;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.PhotoSize;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice implements BotApiObject {
    private static final String TITLE_FIELD = "title";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String START_PARAMETER_FIELD = "start_parameter";
    private static final String CURRENCY_FIELD = "currency";
    private static final String TOTAL_AMOUNT_FIELD = "total_amount";
    private static final String PHOTO_FIELD = "photo";


    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(DESCRIPTION_FIELD)
    private String description;
    @JsonProperty(START_PARAMETER_FIELD)
    private String startParameter;
    @JsonProperty(CURRENCY_FIELD)
    private String currency;
    @JsonProperty(TOTAL_AMOUNT_FIELD)
    private Integer totalAmount;
    @JsonProperty(PHOTO_FIELD)
    private PhotoSize photo;

    public Invoice() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStartParameter() {
        return startParameter;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public PhotoSize getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startParameter='" + startParameter + '\'' +
                ", currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", photo=" + photo +
                '}';
    }

}
