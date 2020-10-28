package com.botmasterzzz.bot.api.impl.methods.update;

import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;


public class EditMessageLiveLocation extends BotApiMethod<Serializable> {
    public static final String PATH = "editMessageLiveLocation";

    private static final String CHATID_FIELD = "chat_id";
    private static final String MESSAGEID_FIELD = "message_id";
    private static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
    private static final String LATITUDE_FIELD = "latitude";
    private static final String LONGITUDE_FIELD = "longitude";
    private static final String REPLYMARKUP_FIELD = "reply_markup";


    @JsonProperty(CHATID_FIELD)
    private String chatId;

    @JsonProperty(MESSAGEID_FIELD)
    private Integer messageId;

    @JsonProperty(INLINE_MESSAGE_ID_FIELD)
    private String inlineMessageId;
    @JsonProperty(LATITUDE_FIELD)
    private Float latitude; ///< Latitude of new location
    @JsonProperty(LONGITUDE_FIELD)
    private Float longitude; ///< Longitude of new location
    @JsonProperty(REPLYMARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup; ///< Optional. A JSON-serialized object for an inline keyboard.

    public EditMessageLiveLocation() {
        super();
    }

    public String getChatId() {
        return chatId;
    }

    public EditMessageLiveLocation setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public EditMessageLiveLocation setChatId(Long chatId) {
        this.chatId = chatId.toString();
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public EditMessageLiveLocation setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public EditMessageLiveLocation setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public EditMessageLiveLocation setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public EditMessageLiveLocation setLatitude(Float latitude) {
        Objects.requireNonNull(latitude);
        this.latitude = latitude;
        return this;
    }

    /**
     * @deprecated  Replaced by {@link #getLongitude()}
     */
    @Deprecated
    @JsonIgnore
    public Float getLongitud() {
        return longitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    /**
     * @deprecated  Replaced by {@link #setLongitude(Float)}
     */
    @Deprecated
    @JsonIgnore
    public EditMessageLiveLocation setLongitud(Float longitude) {
        return setLongitude(longitude);
    }

    public EditMessageLiveLocation setLongitude(Float longitude) {
        Objects.requireNonNull(longitude);
        this.longitude = longitude;
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
                throw new TelegramApiRequestException("Error editing message live location", result);
            }
        } catch (IOException e) {
            try {
                ApiResponse<Boolean> result = OBJECT_MAPPER.readValue(answer,
                        new TypeReference<ApiResponse<Boolean>>() {
                        });
                if (result.getOk()) {
                    return result.getResult();
                } else {
                    throw new TelegramApiRequestException("Error editing message live location", result);
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
        if (latitude == null) {
            throw new TelegramApiValidationException("Latitude parameter can't be empty", this);
        }
        if (longitude == null) {
            throw new TelegramApiValidationException("Longitude parameter can't be empty", this);
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "EditMessageLiveLocation{" +
                "chatId='" + chatId + '\'' +
                ", messageId=" + messageId +
                ", inlineMessageId='" + inlineMessageId + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", replyMarkup=" + replyMarkup +
                '}';
    }
}