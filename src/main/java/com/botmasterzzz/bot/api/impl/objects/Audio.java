package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Audio implements BotApiObject {

    private static final String FILEID_FIELD = "file_id";
    private static final String DURATION_FIELD = "duration";
    private static final String MIMETYPE_FIELD = "mime_type";
    private static final String FILESIZE_FIELD = "file_size";
    private static final String TITLE_FIELD = "title";
    private static final String PERFORMER_FIELD = "performer";

    @JsonProperty(FILEID_FIELD)
    private String fileId;
    @JsonProperty(DURATION_FIELD)
    private Integer duration;
    @JsonProperty(MIMETYPE_FIELD)
    private String mimeType;
    @JsonProperty(FILESIZE_FIELD)
    private Integer fileSize;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(PERFORMER_FIELD)
    private String performer;

    public Audio() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public String getTitle() {
        return title;
    }

    public String getPerformer() {
        return performer;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "fileId='" + fileId + '\'' +
                ", duration=" + duration +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                ", title='" + title + '\'' +
                ", performer='" + performer + '\'' +
                '}';
    }
}
