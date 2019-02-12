package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Voice implements BotApiObject {

    private static final String FILEID_FIELD = "file_id";
    private static final String DURATION_FIELD = "duration";
    private static final String MIMETYPE_FIELD = "mime_type";
    private static final String FILESIZE_FIELD = "file_size";

    @JsonProperty(FILEID_FIELD)
    private String fileId;
    @JsonProperty(DURATION_FIELD)
    private Integer duration;
    @JsonProperty(MIMETYPE_FIELD)
    private String mimeType;
    @JsonProperty(FILESIZE_FIELD)
    private Integer fileSize;

    public Voice() {
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

    @Override
    public String toString() {
        return "Voice{" +
                "fileId='" + fileId + '\'' +
                ", duration=" + duration +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
