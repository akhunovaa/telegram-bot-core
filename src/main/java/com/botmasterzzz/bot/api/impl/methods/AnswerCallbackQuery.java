package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

public class AnswerCallbackQuery extends BotApiMethod<Boolean> {

    public static final String PATH = "answercallbackquery";

    private static final String CALLBACKQUERYID_FIELD = "callback_query_id";
    private static final String TEXT_FIELD = "text";
    private static final String SHOWALERT_FIELD = "show_alert";
    private static final String URL_FIELD = "url";
    private static final String CACHETIME_FIELD = "cache_time";

    @JsonProperty(CALLBACKQUERYID_FIELD)
    private String callbackQueryId; ///< Unique identifier for the query to be answered
    @JsonProperty(TEXT_FIELD)
    private String text; ///< Optional	Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
    @JsonProperty(SHOWALERT_FIELD)
    private Boolean showAlert; ///< Optional. If true, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to false.
    private Long requestedUserId;
    /**
     * Optional. URL that will be opened by the user's client.
     * If you have created a Game and accepted the conditions via @Botfather,
     * specify the URL that opens your game. Otherwise you may use links
     * like telegram.me/your_bot?start=XXXX that open your bot with a parameter.
     */
    @JsonProperty(URL_FIELD)
    private String url;
    /**
     * Optional	The maximum amount of time in seconds that the result of the callback query
     * may be cached client-side.
     *
     * @note Telegram apps will support caching starting in version 3.14. Defaults to 0.
     */
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

    public Long getRequestedUserId() {
        return requestedUserId;
    }

    public AnswerCallbackQuery setRequestedUserId(Long requestedUserId) {
        this.requestedUserId = requestedUserId;
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
                    new TypeReference<ApiResponse<Boolean>>() {
                    });
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