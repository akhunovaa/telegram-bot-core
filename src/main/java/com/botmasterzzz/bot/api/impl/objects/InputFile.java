package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.File;
import java.io.InputStream;

@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
@JsonSerialize(using = InputFileSerializer.class, as = String.class)
public class InputFile implements InputBotApiObject, Validable {

    private String attachName;

    @JsonIgnore
    private String mediaName;
    @JsonIgnore
    private File newMediaFile;
    @JsonIgnore
    private InputStream newMediaStream;
    @JsonIgnore
    private boolean isNew;

    public InputFile() {
        super();
    }

    public InputFile(String attachName) {
        this();
        setMedia(attachName);
    }

    public InputFile(File mediaFile, String fileName) {
        this();
        setMedia(mediaFile, fileName);
    }

    public InputFile(InputStream mediaStream, String fileName) {
        this();
        setMedia(mediaStream, fileName);
    }


    public InputFile setMedia(File mediaFile, String fileName) {
        this.newMediaFile = mediaFile;
        this.mediaName = fileName;
        this.attachName = "attach://" + fileName;
        this.isNew = true;
        return this;
    }

    public InputFile setMedia(InputStream mediaStream, String fileName) {
        this.newMediaStream = mediaStream;
        this.mediaName = fileName;
        this.attachName = "attach://" + fileName;
        this.isNew = true;
        return this;
    }

    public InputFile setMedia(String attachName) {
        this.attachName = attachName;
        this.isNew = false;
        return this;
    }

    public String getAttachName() {
        return attachName;
    }

    public String getMediaName() {
        return mediaName;
    }

    public File getNewMediaFile() {
        return newMediaFile;
    }

    public InputStream getNewMediaStream() {
        return newMediaStream;
    }

    public boolean isNew() {
        return isNew;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (isNew) {
            if (mediaName == null || mediaName.isEmpty()) {
                throw new TelegramApiValidationException("Media name can't be empty", this);
            }
            if (newMediaFile == null && newMediaStream == null) {
                throw new TelegramApiValidationException("Media can't be empty", this);
            }
        } else {
            if (attachName == null || attachName.isEmpty()) {
                throw new TelegramApiValidationException("File_id can't be empty", this);
            }
        }
    }
}
