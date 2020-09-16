package com.botmasterzzz.bot.api.impl.objects.inlinequery.result.chached;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.result.InlineQueryResult;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultCachedSticker implements InlineQueryResult {

    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String STICKER_FILE_ID_FIELD = "sticker_file_id";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";

    @JsonProperty(TYPE_FIELD)
    private final String type = "sticker";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(STICKER_FILE_ID_FIELD)
    private String stickerFileId;
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;

    public InlineQueryResultCachedSticker() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultCachedSticker setId(String id) {
        this.id = id;
        return this;
    }

    public String getStickerFileId() {
        return stickerFileId;
    }

    public InlineQueryResultCachedSticker setStickerFileId(String stickerFileId) {
        this.stickerFileId = stickerFileId;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultCachedSticker setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultCachedSticker setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (stickerFileId == null || stickerFileId.isEmpty()) {
            throw new TelegramApiValidationException("StickerFileId parameter can't be empty", this);
        }
        if (inputMessageContent != null) {
            inputMessageContent.validate();
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "InlineQueryResultCachedSticker{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", sticker_file_id='" + stickerFileId + '\'' +
                ", inputMessageContent='" + inputMessageContent + '\'' +
                ", replyMarkup='" + replyMarkup + '\'' +
                '}';
    }
}
