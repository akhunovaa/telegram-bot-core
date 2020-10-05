package com.botmasterzzz.bot.api.impl.objects.payments;

import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LabeledPrice implements InputBotApiObject, Validable {
    private static final String LABEL_FIELD = "label";
    private static final String AMOUNT_FIELD = "amount";

    @JsonProperty(LABEL_FIELD)
    private String label;
    @JsonProperty(AMOUNT_FIELD)
    private Integer amount;

    public LabeledPrice() {
        super();
    }

    public LabeledPrice(String label, Integer amount) {
        super();
        if (label != null && !label.isEmpty()) this.label = label;
        if (amount != null) this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        if (null != label) this.label = label;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        if (null != amount) this.amount = amount;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (label == null || label.isEmpty()) {
            throw new TelegramApiValidationException("Label parameter can't be empty", this);
        }
        if (amount == null) {
            throw new TelegramApiValidationException("Amount parameter can't be empty", this);
        }
    }

    @Override
    public String toString() {
        return "LabeledPrice{" +
                "label='" + label + '\'' +
                ", amount=" + amount +
                '}';
    }
}
