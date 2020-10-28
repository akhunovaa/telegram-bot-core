package com.botmasterzzz.bot.api.impl.methods.update;

import com.botmasterzzz.bot.api.impl.methods.PartialBotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.api.impl.objects.media.InputMedia;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.Serializable;

public class EditMessageMedia extends PartialBotApiMethod<Serializable> {
    public static final String PATH = "editMessageMedia";

    public static final String CHATID_FIELD = "chat_id";
    public static final String MESSAGEID_FIELD = "message_id";
    public static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
    public static final String MEDIA_FIELD = "media";
    public static final String REPLYMARKUP_FIELD = "reply_markup";


    @JsonProperty(CHATID_FIELD)
    private String chatId;

    @JsonProperty(MESSAGEID_FIELD)
    private Integer messageId;

    @JsonProperty(INLINE_MESSAGE_ID_FIELD)
    private String inlineMessageId;

    @JsonProperty(MEDIA_FIELD)
    private InputMedia media;

    @JsonProperty(REPLYMARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup; ///< Optional. A JSON-serialized object for an inline keyboard.

    public EditMessageMedia() {
        super();
    }

    public String getChatId() {
        return chatId;
    }

    public EditMessageMedia setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public EditMessageMedia setChatId(Long chatId) {
        this.chatId = chatId.toString();
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public EditMessageMedia setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public EditMessageMedia setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
        return this;
    }

    public InputMedia getMedia() {
        return media;
    }

    public void setMedia(InputMedia media) {
        this.media = media;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public EditMessageMedia setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
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
        if (media == null) {
            throw new TelegramApiValidationException("Media parameter can't be empty", this);
        }

        media.validate();

        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "EditMessageMedia{" +
                "chatId='" + chatId + '\'' +
                ", messageId=" + messageId +
                ", inlineMessageId='" + inlineMessageId + '\'' +
                ", media=" + media +
                ", replyMarkup=" + replyMarkup +
                '}';
    }
}