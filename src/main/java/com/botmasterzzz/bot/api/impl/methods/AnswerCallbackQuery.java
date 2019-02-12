package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

public class AnswerCallbackQuery extends BotApiMethod<Boolean>  {

    public static final String PATH = "answercallbackquery";

    private static final String CALLBACKQUERYID_FIELD = "callback_query_id";
    private static final String TEXT_FIELD = "text";
    private static final String SHOWALERT_FIELD = "show_alert";
    private static final String URL_FIELD = "url";
    private static final String CACHETIME_FIELD = "cache_time";

    @JsonProperty(CALLBACKQUERYID_FIELD)
    private String callbackQueryId;
    @JsonProperty(TEXT_FIELD)
    private String text; //
    @JsonProperty(SHOWALERT_FIELD)
    private Boolean showAlert;
    @JsonProperty(URL_FIELD)
    private String url;

    @JsonProperty(CACHETIME_FIELD)
    private Integer cacheTime;

    public AnswerCallbackQuery() {
        super();
    }

    public String getCallbackQueryId() {
        return this.callbackQueryId;
    }

    public AnswerCallbackQuery setCallbackQueryId(String callbackQueryId) {
        this.callbackQueryId = callbackQueryId;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public AnswerCallbackQuery setText(String text) {
        this.text = text;
        return this;
    }

    public Boolean getShowAlert() {
        return this.showAlert;
    }

    public AnswerCallbackQuery setShowAlert(Boolean showAlert) {
        this.showAlert = showAlert;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public AnswerCallbackQuery setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getCacheTime() {
        return cacheTime;
    }

    public AnswerCallbackQuery setCacheTime(Integer cacheTime) {
        this.cacheTime = cacheTime;
        return this;
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Boolean deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Boolean> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Boolean>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error answering callback query", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (callbackQueryId == null) {
            throw new TelegramApiValidationException("CallbackQueryId can't be null", this);
        }
    }

    @Override
    public String toString() {
        return "AnswerCallbackQuery{" +
                "callbackQueryId='" + callbackQueryId + '\'' +
                ", text='" + text + '\'' +
                ", showAlert=" + showAlert +
                ", url='" + url + '\'' +
                ", cacheTime=" + cacheTime +
                '}';
    }

}
