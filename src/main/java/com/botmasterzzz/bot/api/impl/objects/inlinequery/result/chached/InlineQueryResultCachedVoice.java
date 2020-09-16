package com.botmasterzzz.bot.api.impl.objects.inlinequery.result.chached;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.result.InlineQueryResult;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultCachedVoice implements InlineQueryResult {
    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String VOICE_FILE_ID_FIELD = "voice_file_id";
    private static final String TITLE_FIELD = "title";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String CAPTION_FIELD = "caption";
    private static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(TYPE_FIELD)
    private final String type = "voice";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(VOICE_FILE_ID_FIELD)
    private String voiceFileId;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;
    @JsonProperty(CAPTION_FIELD)
    private String caption;
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode;

    public InlineQueryResultCachedVoice() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultCachedVoice setId(String id) {
        this.id = id;
        return this;
    }

    public String getVoiceFileId() {
        return voiceFileId;
    }

    public InlineQueryResultCachedVoice setVoiceFileId(String voiceFileId) {
        this.voiceFileId = voiceFileId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultCachedVoice setTitle(String title) {
        this.title = title;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultCachedVoice setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultCachedVoice setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultCachedVoice setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public InlineQueryResultCachedVoice setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (voiceFileId == null || voiceFileId.isEmpty()) {
            throw new TelegramApiValidationException("VoiceFileId parameter can't be empty", this);
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
        return "InlineQueryResultCachedVoice{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", voiceFileId='" + voiceFileId + '\'' +
                ", title='" + title + '\'' +
                ", inputMessageContent=" + inputMessageContent +
                ", replyMarkup=" + replyMarkup +
                ", caption='" + caption + '\'' +
                ", parseMode='" + parseMode + '\'' +
                '}';
    }
}
