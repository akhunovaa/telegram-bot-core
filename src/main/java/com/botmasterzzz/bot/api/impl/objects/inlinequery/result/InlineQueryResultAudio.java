package com.botmasterzzz.bot.api.impl.objects.inlinequery.result;

import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.InputMessageContent;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineQueryResultAudio implements InlineQueryResult {

    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String AUDIOURL_FIELD = "audio_url";
    private static final String TITLE_FIELD = "title";
    private static final String PERFORMER_FIELD = "performer";
    private static final String AUDIO_DURATION_FIELD = "audio_duration";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String CAPTION_FIELD = "caption";
    private static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(TYPE_FIELD)
    private final String type = "audio";
    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(AUDIOURL_FIELD)
    private String audioUrl;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(PERFORMER_FIELD)
    private String performer;
    @JsonProperty(AUDIO_DURATION_FIELD)
    private Integer audioDuration;
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;
    @JsonProperty(CAPTION_FIELD)
    private String caption;
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode;

    public InlineQueryResultAudio() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public InlineQueryResultAudio setId(String id) {
        this.id = id;
        return this;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public InlineQueryResultAudio setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultAudio setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public InlineQueryResultAudio setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public Integer getAudioDuration() {
        return audioDuration;
    }

    public InlineQueryResultAudio setAudioDuration(Integer audioDuration) {
        this.audioDuration = audioDuration;
        return this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultAudio setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public InlineQueryResultAudio setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultAudio setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public InlineQueryResultAudio setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (audioUrl == null || audioUrl.isEmpty()) {
            throw new TelegramApiValidationException("AudioUrl parameter can't be empty", this);
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
        return "InlineQueryResultAudio{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", audioUrl='" + audioUrl + '\'' +
                ", title='" + title + '\'' +
                ", performer='" + performer + '\'' +
                ", audioDuration=" + audioDuration +
                ", inputMessageContent=" + inputMessageContent +
                ", replyMarkup=" + replyMarkup +
                ", caption='" + caption + '\'' +
                ", parseMode='" + parseMode + '\'' +
                '}';
    }
}
