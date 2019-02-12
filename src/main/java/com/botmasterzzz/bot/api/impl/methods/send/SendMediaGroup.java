package com.botmasterzzz.bot.api.impl.methods.send;

import com.botmasterzzz.bot.api.impl.methods.PartialBotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.api.impl.objects.media.InputMedia;
import com.botmasterzzz.bot.api.impl.objects.media.InputMediaPhoto;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendMediaGroup extends PartialBotApiMethod<ArrayList<Message>> {

    public static final String PATH = "sendMediaGroup";

    public static final String CHATID_FIELD = "chat_id";
    public static final String MEDIA_FIELD = "media";
    public static final String REPLYTOMESSAGEID_FIELD = "reply_to_message_id";
    public static final String DISABLENOTIFICATION_FIELD = "disable_notification";

    @JsonProperty(CHATID_FIELD)
    private String chatId;
    @JsonProperty(MEDIA_FIELD)
    private List<InputMedia> media;
    @JsonProperty(REPLYTOMESSAGEID_FIELD)
    private Integer replyToMessageId;
    @JsonProperty(DISABLENOTIFICATION_FIELD)
    private Boolean disableNotification;

    public SendMediaGroup() {
        super();
    }

    public SendMediaGroup(String chatId, List<InputMedia> media) {
        super();
        this.chatId = chatId;
        this.media = media;
    }

    public SendMediaGroup(Long chatId, List<InputMedia> media) {
        super();
        this.chatId = chatId.toString();
        this.media = media;
    }

    public String getChatId() {
        return chatId;
    }

    public SendMediaGroup setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SendMediaGroup setChatId(Long chatId) {
        this.chatId = chatId.toString();
        return this;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public SendMediaGroup setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return this;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public SendMediaGroup enableNotification() {
        this.disableNotification = false;
        return this;
    }

    public SendMediaGroup disableNotification() {
        this.disableNotification = true;
        return this;
    }

    public List<InputMedia> getMedia() {
        return media;
    }

    public void setMedia(List<InputMedia> media) {
        this.media = media;
    }

    @Override
    public ArrayList<Message> deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<ArrayList<Message>> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<ArrayList<Message>>>() {
                    });
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error sending media group", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (chatId == null) {
            throw new TelegramApiValidationException("ChatId parameter can't be empty", this);
        }

        if (media == null || media.isEmpty()) {
            throw new TelegramApiValidationException("Media parameter can't be empty", this);
        }

        for (InputMedia inputMedia : media) {
            if (inputMedia instanceof InputMediaPhoto) {
                inputMedia.validate();
            } else {
                throw new TelegramApiValidationException("Media parameter can only be Photo", this);
            }
        }
    }

    @Override
    public String toString() {
        return "SendMediaGroup{" +
                "chatId='" + chatId + '\'' +
                ", media=" + media +
                ", replyToMessageId=" + replyToMessageId +
                ", disableNotification=" + disableNotification +
                '}';
    }
}
