package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.payments.ShippingOption;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class AnswerShippingQuery extends BotApiMethod<Boolean> {
    public static final String PATH = "answerShippingQuery";

    private static final String SHIPPING_QUERY_ID_FIELD = "shipping_query_id";
    private static final String OK_FIELD = "ok";
    private static final String SHIPPING_OPTIONS_FIELD = "shipping_options";
    private static final String ERROR_MESSAGE_FIELD = "error_message";

    @JsonProperty(SHIPPING_QUERY_ID_FIELD)
    private String shippingQueryId;
    @JsonProperty(OK_FIELD)
    private Boolean ok;
    @JsonProperty(SHIPPING_OPTIONS_FIELD)
    private List<ShippingOption> shippingOptions;
    @JsonProperty(ERROR_MESSAGE_FIELD)
    private String errorMessage;

    public AnswerShippingQuery() {
        super();
    }

    public AnswerShippingQuery(String shippingQueryId, Boolean ok) {
        this.shippingQueryId = shippingQueryId;
        this.ok = ok;
    }

    public String getShippingQueryId() {
        return shippingQueryId;
    }

    public AnswerShippingQuery setShippingQueryId(String shippingQueryId) {
        this.shippingQueryId = shippingQueryId;
        return this;
    }

    public Boolean getOk() {
        return ok;
    }

    public AnswerShippingQuery setOk(Boolean ok) {
        this.ok = ok;
        return this;
    }

    public List<ShippingOption> getShippingOptions() {
        return shippingOptions;
    }

    public AnswerShippingQuery setShippingOptions(List<ShippingOption> shippingOptions) {
        this.shippingOptions = shippingOptions;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public AnswerShippingQuery setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (shippingQueryId == null || shippingQueryId.isEmpty()) {
            throw new TelegramApiValidationException("ShippingQueryId can't be empty", this);
        }
        if (ok == null) {
            throw new TelegramApiValidationException("Ok can't be null", this);
        }
        if (ok) {
            if (shippingOptions == null || shippingOptions.isEmpty()) {
                throw new TelegramApiValidationException("ShippingOptions array can't be empty if ok", this);
            }
            for (ShippingOption shippingOption : shippingOptions) {
                shippingOption.validate();
            }
        } else {
            if (errorMessage == null || errorMessage.isEmpty()) {
                throw new TelegramApiValidationException("ErrorMessage can't be empty if not ok", this);
            }
        }
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Boolean deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Boolean> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Boolean>>() {
                    });
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error answering shipping query", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public String toString() {
        return "AnswerShippingQuery{" +
                "shippingQueryId='" + shippingQueryId + '\'' +
                ", ok=" + ok +
                ", shippingOptions=" + shippingOptions +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
