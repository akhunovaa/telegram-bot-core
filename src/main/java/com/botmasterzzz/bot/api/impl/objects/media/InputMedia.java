package com.botmasterzzz.bot.api.impl.objects.media;

import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.api.impl.objects.media.serialization.InputMediaDeserializer;
import com.botmasterzzz.bot.api.impl.objects.media.serialization.InputMediaSerializer;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.File;
import java.io.InputStream;

@SuppressWarnings({"unchecked"})
@JsonSerialize(using = InputMediaSerializer.class)
@JsonDeserialize(using = InputMediaDeserializer.class)
public abstract class InputMedia<T> implements InputBotApiObject, Validable {
    public static final String TYPE_FIELD = "type";
    public static final String MEDIA_FIELD = "media";
    public static final String CAPTION_FIELD = "caption";
    public static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(MEDIA_FIELD)
    private String media;
    @JsonProperty(CAPTION_FIELD)
    private String caption; ///< Optional. Caption of the media to be sent, 0-200 characters
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode; ///< Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
    @JsonIgnore
    private boolean isNewMedia; ///< True to upload a new media, false to use a fileId or URL
    @JsonIgnore
    private String mediaName; ///< Name of the media to upload
    @JsonIgnore
    private File newMediaFile; ///< New media file
    @JsonIgnore
    private InputStream newMediaStream; ///< New media stream

    public InputMedia() {
        super();
    }

    public InputMedia(String media, String caption) {
        this.media = media;
        this.caption = caption;
    }

    public String getMedia() {
        return media;
    }

    public File getMediaFile() {
        return newMediaFile;
    }

    public InputStream getNewMediaStream() {
        return newMediaStream;
    }

    public String getMediaName() {
        return mediaName;
    }

    @JsonIgnore
    public boolean isNewMedia() {
        return isNewMedia;
    }

    public T setMedia(String media) {
        this.media = media;
        this.isNewMedia = false;
        return (T) this;
    }

    public T setMedia(File mediaFile, String fileName) {
        this.newMediaFile = mediaFile;
        this.isNewMedia = true;
        this.mediaName = fileName;
        this.media = "attach://" + fileName;
        return (T) this;
    }

    public T setMedia(InputStream mediaStream, String fileName) {
        this.newMediaStream = mediaStream;
        this.isNewMedia = true;
        this.mediaName = fileName;
        this.media = "attach://" + fileName;
        return (T) this;
    }

    public String getCaption() {
        return caption;
    }

    public InputMedia setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getParseMode() {
        return parseMode;
    }

    public InputMedia<T> setParseMode(String parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (isNewMedia) {
            if (mediaName == null || mediaName.isEmpty()) {
                throw new TelegramApiValidationException("Media name can't be empty", this);
            }
            if (newMediaFile == null && newMediaStream == null) {
                throw new TelegramApiValidationException("Media can't be empty", this);
            }
        } else if (media == null || media.isEmpty()) {
            throw new TelegramApiValidationException("Media can't be empty", this);
        }
    }

    @JsonProperty(TYPE_FIELD)
    public abstract String getType();

    @Override
    public String toString() {
        return "InputMedia{" +
                "media='" + media + '\'' +
                ", caption='" + caption + '\'' +
                ", parseMode='" + parseMode + '\'' +
                ", isNewMedia=" + isNewMedia +
                ", mediaName='" + mediaName + '\'' +
                ", newMediaFile=" + newMediaFile +
                ", newMediaStream=" + newMediaStream +
                '}';
    }
}