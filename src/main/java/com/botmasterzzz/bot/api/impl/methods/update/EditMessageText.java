package com.botmasterzzz.bot.api.impl.methods.update;

import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.api.impl.methods.ParseMode;
import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.Serializable;

public class EditMessageText  extends BotApiMethod<Serializable> {
    public static final String PATH = "editmessagetext";

    private static final String CHATID_FIELD = "chat_id";
    private static final String MESSAGEID_FIELD = "message_id";
    private static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
    private static final String TEXT_FIELD = "text";
    private static final String PARSE_MODE_FIELD = "parse_mode";
    private static final String DISABLE_WEB_PREVIEW_FIELD = "disable_web_page_preview";
    private static final String REPLYMARKUP_FIELD = "reply_markup";

    /**
     * Required if inline_message_id is not specified. Unique identifier for the chat to send the
     * message to (Or username for channels)
     */
    @JsonProperty(CHATID_FIELD)
    private String chatId;
    /**
     * Required if inline_message_id is not specified. Unique identifier of the sent message
     */
    @JsonProperty(MESSAGEID_FIELD)
    private Integer messageId;
    /**
     * Required if chat_id and message_id are not specified. Identifier of the inline message
     */
    @JsonProperty(INLINE_MESSAGE_ID_FIELD)
    private String inlineMessageId;
    /**
     * New text of the message
     */
    @JsonProperty(TEXT_FIELD)
    private String text;

    @JsonProperty(PARSE_MODE_FIELD)
    private String parseMode;
    @JsonProperty(DISABLE_WEB_PREVIEW_FIELD)
    private Boolean disableWebPagePreview;
    @JsonProperty(REPLYMARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;

    public EditMessageText() {
        super();
    }

    public String getChatId() {
        return chatId;
    }

    public EditMessageText setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public EditMessageText setChatId(Long chatId) {
        this.chatId = chatId.toString();
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public EditMessageText setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public EditMessageText setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
        return this;
    }

    public String getText() {
        return text;
    }

    public EditMessageText setText(String text) {
        this.text = text;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public EditMessageText setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public EditMessageText disableWebPagePreview() {
        disableWebPagePreview = true;
        return this;
    }

    public EditMessageText enableWebPagePreview() {
        disableWebPagePreview = null;
        return this;
    }

    public EditMessageText enableMarkdown(boolean enable) {
        if (enable) {
            this.parseMode = ParseMode.MARKDOWN;
        } else {
            this.parseMode = null;
        }
        return this;
    }

    public EditMessageText enableHtml(boolean enable) {
        if (enable) {
            this.parseMode = ParseMode.HTML;
        } else {
            this.parseMode = null;
        }
        return this;
    }


    public EditMessageText setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Serializable deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Message> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Message>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error editing message text", result);
            }
        } catch (IOException e) {
            try {
                ApiResponse<Boolean> result = OBJECT_MAPPER.readValue(answer,
                        new TypeReference<ApiResponse<Boolean>>() {
                        });
                if (result.getOk()) {
                    return result.getResult();
                } else {
                    throw new TelegramApiRequestException("Error editing message text", result);
                }
            } catch (IOException e2) {
                throw new TelegramApiRequestException("Unable to deserialize response", e);
            }
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (inlineMessageId == null) {
            if (chatId == null) {
                throw new TelegramApiValidationException("ChatId parameter can't be empty if inlineMessageId is not present", this);
            }
            if (messageId == null) {
                throw new TelegramApiValidationException("MessageId parameter can't be empty if inlineMessageId is not present", this);
            }
        } else {
            if (chatId != null) {
                throw new TelegramApiValidationException("ChatId parameter must be empty if inlineMessageId is provided", this);
            }
            if (messageId != null) {
                throw new TelegramApiValidationException("MessageId parameter must be empty if inlineMessageId is provided", this);
            }
        }
        if (text == null || text.isEmpty()) {
            throw new TelegramApiValidationException("Text parameter can't be empty", this);
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "EditMessageText{" +
                "chatId=" + chatId +
                ", messageId=" + messageId +
                ", inlineMessageId=" + inlineMessageId +
                ", text=" + text +
                ", parseMode=" + parseMode +
                ", disableWebPagePreview=" + disableWebPagePreview +
                ", replyMarkup=" + replyMarkup +
                '}';
    }
}
