package com.botmasterzzz.bot.api.impl.objects.replykeyboard.buttons;

import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;


public class InlineKeyboardButton implements InputBotApiObject, Validable {

    private static final String TEXT_FIELD = "text";
    private static final String URL_FIELD = "url";
    private static final String CALLBACK_DATA_FIELD = "callback_data";
    private static final String CALLBACK_GAME_FIELD = "callback_game";
    private static final String SWITCH_INLINE_QUERY_FIELD = "switch_inline_query";
    private static final String SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD = "switch_inline_query_current_chat";
    private static final String PAY_FIELD = "pay";
    private static final String LOGIN_URL_FIELD = "login_url";

    @JsonProperty(TEXT_FIELD)
    private String text; ///< Label text on the button
    @JsonProperty(URL_FIELD)
    private String url; ///< Optional. HTTP or tg:// url to be opened when button is pressed
    @JsonProperty(CALLBACK_DATA_FIELD)
    private String callbackData; ///< Optional. Data to be sent in a callback query to the bot when button is pressed

    @JsonProperty(SWITCH_INLINE_QUERY_FIELD)
    private String switchInlineQuery;

    @JsonProperty(SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD)
    private String switchInlineQueryCurrentChat;


    @JsonProperty(PAY_FIELD)
    private Boolean pay;

    public InlineKeyboardButton() {
        super();
    }

    public InlineKeyboardButton(String text) {
        this.text = checkNotNull(text);
    }

    public String getText() {
        return text;
    }

    public InlineKeyboardButton setText(String text) {
        this.text = text;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public InlineKeyboardButton setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public InlineKeyboardButton setCallbackData(String callbackData) {
        this.callbackData = callbackData;
        return this;
    }

    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }

    public InlineKeyboardButton setSwitchInlineQuery(String switchInlineQuery) {
        this.switchInlineQuery = switchInlineQuery;
        return this;
    }

    public String getSwitchInlineQueryCurrentChat() {
        return switchInlineQueryCurrentChat;
    }

    public InlineKeyboardButton setSwitchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
        return this;
    }

    public Boolean getPay() {
        return pay;
    }

    public InlineKeyboardButton setPay(Boolean pay) {
        this.pay = pay;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (text == null || text.isEmpty()) {
            throw new TelegramApiValidationException("Text parameter can't be empty", this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof InlineKeyboardButton)) {
            return false;
        }
        InlineKeyboardButton inlineKeyboardButton = (InlineKeyboardButton) o;
        return Objects.equals(callbackData, inlineKeyboardButton.callbackData)
                && Objects.equals(pay, inlineKeyboardButton.pay)
                && Objects.equals(switchInlineQuery, inlineKeyboardButton.switchInlineQuery)
                && Objects.equals(switchInlineQueryCurrentChat, inlineKeyboardButton.switchInlineQueryCurrentChat)
                && Objects.equals(text, inlineKeyboardButton.text)
                && Objects.equals(url, inlineKeyboardButton.url)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                callbackData,
                pay,
                switchInlineQuery,
                switchInlineQueryCurrentChat,
                text,
                url);
    }

    @Override
    public String toString() {
        return "InlineKeyboardButton{" +
                "text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", callbackData='" + callbackData + '\'' +
                ", switchInlineQuery='" + switchInlineQuery + '\'' +
                ", switchInlineQueryCurrentChat='" + switchInlineQueryCurrentChat + '\'' +
                ", pay=" + pay +
                '}';
    }
}