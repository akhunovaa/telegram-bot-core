package com.botmasterzzz.bot.api.impl.objects.media;

import com.botmasterzzz.bot.api.impl.objects.InputFile;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings({"unused"})
@JsonDeserialize
public class InputMediaVideo extends InputMedia<InputMediaVideo> {
    public static final String WIDTH_FIELD = "width";
    public static final String HEIGHT_FIELD = "height";
    public static final String DURATION_FIELD = "duration";
    public static final String SUPPORTSSTREAMING_FIELD = "supports_streaming";
    public static final String THUMB_FIELD = "thumb";
    private static final String TYPE = "video";
    @JsonProperty(WIDTH_FIELD)
    private Integer width; ///< Optional. Video width
    @JsonProperty(HEIGHT_FIELD)
    private Integer height; ///< Optional. Video height
    @JsonProperty(DURATION_FIELD)
    private Integer duration; ///< Optional. Video duration
    @JsonProperty(SUPPORTSSTREAMING_FIELD)
    private Boolean supportsStreaming; ///< Optional. Pass True, if the uploaded video is suitable for streaming

    @JsonProperty(THUMB_FIELD)
    private InputFile thumb;

    public InputMediaVideo() {
        super();
    }

    public InputMediaVideo(String media, String caption) {
        super(media, caption);
    }

    public Integer getWidth() {
        return width;
    }

    public InputMediaVideo setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public InputMediaVideo setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public InputMediaVideo setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Boolean getSupportsStreaming() {
        return supportsStreaming;
    }

    public InputMediaVideo setSupportsStreaming(Boolean supportsStreaming) {
        this.supportsStreaming = supportsStreaming;
        return this;
    }

    public InputFile getThumb() {
        return thumb;
    }

    public InputMediaVideo setThumb(InputFile thumb) {
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
        return "InputMediaVideo{" +
                "width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", supportsStreaming=" + supportsStreaming +
                "} " + super.toString();
    }
}