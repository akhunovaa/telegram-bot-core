package com.botmasterzzz.bot.api.impl.objects.media;

import com.botmasterzzz.bot.api.impl.objects.InputFile;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings({"unused"})
@JsonDeserialize
public class InputMediaAudio extends InputMedia<InputMediaAudio> {
    public static final String DURATION_FIELD = "duration";
    public static final String PERFORMER_FIELD = "performer";
    public static final String TITLE_FIELD = "title";
    public static final String THUMB_FIELD = "thumb";
    private static final String TYPE = "audio";
    @JsonProperty(DURATION_FIELD)
    private Integer duration; ///< Optional. Duration of the audio in seconds
    @JsonProperty(PERFORMER_FIELD)
    private String performer; ///< Optional. Performer of the audio
    @JsonProperty(TITLE_FIELD)
    private String title; ///< Optional. Title of the audio

    private InputFile thumb;


    public InputMediaAudio() {
        super();
    }

    public InputMediaAudio(String media, String caption) {
        super(media, caption);
    }

    public Integer getDuration() {
        return duration;
    }

    public InputMediaAudio setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public InputMediaAudio setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InputMediaAudio setTitle(String title) {
        this.title = title;
        return this;
    }

    public InputFile getThumb() {
        return thumb;
    }

    public InputMediaAudio setThumb(InputFile thumb) {
        this.thumb = thumb;
        return this;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        super.validate();
    }

    @Override
    public String toString() {
        return "InputMediaAudio{" +
                "duration=" + duration +
                ", performer=" + performer +
                ", title=" + title +
                ", thumb=" + thumb +
                "} " + super.toString();
    }
}
