package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

public class AnswerPreCheckoutQuery extends BotApiMethod<Boolean> {

    public static final String PATH = "answerPreCheckoutQuery";

    private static final String PRE_CHECKOUT_QUERY_ID_FIELD = "pre_checkout_query_id";
    private static final String OK_FIELD = "ok";
    private static final String ERROR_MESSAGE_FIELD = "error_message";

    @JsonProperty(PRE_CHECKOUT_QUERY_ID_FIELD)
    private String preCheckoutQueryId;
    @JsonProperty(OK_FIELD)
    private Boolean ok;
    @JsonProperty(ERROR_MESSAGE_FIELD)
    private String errorMessage;

    public AnswerPreCheckoutQuery() {
        super();
    }

    public AnswerPreCheckoutQuery(String preCheckoutQueryId, Boolean ok) {
        this.preCheckoutQueryId = preCheckoutQueryId;
        this.ok = ok;
    }

    public String getPreCheckoutQueryId() {
        return preCheckoutQueryId;
    }

    public AnswerPreCheckoutQuery setPreCheckoutQueryId(String preCheckoutQueryId) {
        this.preCheckoutQueryId = preCheckoutQueryId;
        return this;
    }

    public Boolean getOk() {
        return ok;
    }

    public AnswerPreCheckoutQuery setOk(Boolean ok) {
        this.ok = ok;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public AnswerPreCheckoutQuery setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (preCheckoutQueryId == null || preCheckoutQueryId.isEmpty()) {
            throw new TelegramApiValidationException("PreCheckoutQueryId can't be empty", this);
        }
        if (ok == null) {
            throw new TelegramApiValidationException("Ok can't be null", this);
        }
        if (!ok) {
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
                throw new TelegramApiRequestException("Error answering pre-checkout query", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public String toString() {
        return "AnswerPreCheckoutQuery{" +
                "preCheckoutQueryId='" + preCheckoutQueryId + '\'' +
                ", ok=" + ok +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
