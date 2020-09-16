package com.botmasterzzz.bot.api.impl.objects.inlinequery.result;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultVoice implements InlineQueryResult {
    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String VOICEURL_FIELD = "voice_url";
    private static final String TITLE_FIELD = "title";
    private static final String VOICE_DURATION_FIELD = "voice_duration";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String CAPTION_FIELD = "caption";
    private static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(TYPE_FIELD)
    private final String type = "voice";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(VOICEURL_FIELD)
    private String voiceUrl;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(VOICE_DURATION_FIELD)
    private Integer voiceDuration;
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;
    @JsonProperty(CAPTION_FIELD)
    private String caption;
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode;

    public InlineQueryResultVoice() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultVoice setId(String id) {
        this.id = id;
        return this;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public InlineQueryResultVoice setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultVoice setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getVoiceDuration() {
        return voiceDuration;
    }

    public InlineQueryResultVoice setVoiceDuration(Integer voiceDuration) {
        this.voiceDuration = voiceDuration;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultVoice setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultVoice setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultVoice setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (voiceUrl == null || voiceUrl.isEmpty()) {
            throw new TelegramApiValidationException("VoiceUrl parameter can't be empty", this);
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
        return "InlineQueryResultVoice{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", voiceUrl='" + voiceUrl + '\'' +
                ", title='" + title + '\'' +
                ", voiceDuration=" + voiceDuration +
                ", inputMessageContent=" + inputMessageContent +
                ", replyMarkup=" + replyMarkup +
                ", caption='" + caption + '\'' +
                ", parseMode='" + parseMode + '\'' +
                '}';
    }
}
