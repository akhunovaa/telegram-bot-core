package com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent;

import com.botmasterzzz.bot.api.impl.methods.ParseMode;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputTextMessageContent implements InputMessageContent {

    private static final String MESSAGETEXT_FIELD = "message_text";
    private static final String PARSEMODE_FIELD = "parse_mode";
    private static final String DISABLEWEBPAGEPREVIEW_FIELD = "disable_web_page_preview";

    @JsonProperty(MESSAGETEXT_FIELD)
    private String messageText;
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode;
    @JsonProperty(DISABLEWEBPAGEPREVIEW_FIELD)
    private Boolean disableWebPagePreview;

    public InputTextMessageContent() {
        super();
    }

    public String getMessageText() {
        return messageText;
    }

    public InputTextMessageContent setMessageText(String messageText) {
        this.messageText = messageText;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public InputTextMessageContent setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    public InputTextMessageContent setDisableWebPagePreview(Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public InputTextMessageContent enableMarkdown(boolean enable) {
        if (enable) {
            this.parseMode = ParseMode.MARKDOWN;
        } else {
            this.parseMode = null;
        }
        return this;
    }

    public InputTextMessageContent enableHtml(boolean enable) {
        if (enable) {
            this.parseMode = ParseMode.HTML;
        } else {
            this.parseMode = null;
        }
        return this;
    }

    public InputTextMessageContent disableWebPagePreview() {
        disableWebPagePreview = true;
        return this;
    }

    public InputTextMessageContent enableWebPagePreview() {
        disableWebPagePreview = null;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (messageText == null || messageText.isEmpty()) {
            throw new TelegramApiValidationException("MessageText parameter can't be empty", this);
        }
    }

    @Override
    public String toString() {
        return "InputTextMessageContent{" +
                ", messageText='" + messageText + '\'' +
                ", parseMode='" + parseMode + '\'' +
                ", disableWebPagePreview=" + disableWebPagePreview +
                '}';
    }
}
