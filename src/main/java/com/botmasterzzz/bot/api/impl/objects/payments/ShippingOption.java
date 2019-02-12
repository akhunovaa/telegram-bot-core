package com.botmasterzzz.bot.api.impl.objects.payments;

import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ShippingOption implements InputBotApiObject, Validable {

    private static final String ID_FIELD = "id";
    private static final String TITLE_FIELD = "title";
    private static final String PRICES_FIELD = "prices";

    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(PRICES_FIELD)
    private List<LabeledPrice> prices;

    public ShippingOption() {
        super();
    }

    public ShippingOption(String id, String title, List<LabeledPrice> prices) {
        this.id = id;
        this.title = title;
        this.prices = prices;
    }

    public String getId() {
        return id;
    }

    public ShippingOption setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ShippingOption setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<LabeledPrice> getPrices() {
        return prices;
    }

    public ShippingOption setPrices(List<LabeledPrice> prices) {
        this.prices = prices;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("Id parameter can't be empty", this);
        }
        if (title == null || title.isEmpty()) {
            throw new TelegramApiValidationException("Title parameter can't be empty", this);
        }
        if (prices == null || prices.isEmpty()) {
            throw new TelegramApiValidationException("Prices parameter can't be empty", this);
        }
        for (LabeledPrice price : prices) {
            price.validate();
        }
    }

    @Override
    public String toString() {
        return "ShippingOption{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", prices=" + prices +
                '}';
    }
}
