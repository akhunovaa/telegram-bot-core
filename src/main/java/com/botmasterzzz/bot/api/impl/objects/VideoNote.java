package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoNote implements BotApiObject {
    private static final String FILEID_FIELD = "file_id";
    private static final String LENGTH_FIELD = "length";
    private static final String DURATION_FIELD = "duration";
    private static final String THUMB_FIELD = "thumb";
    private static final String FILESIZE_FIELD = "file_size";

    @JsonProperty(FILEID_FIELD)
    private String fileId;
    @JsonProperty(LENGTH_FIELD)
    private Integer length;
    @JsonProperty(DURATION_FIELD)
    private Integer duration;
    @JsonProperty(THUMB_FIELD)
    private PhotoSize thumb;
    @JsonProperty(FILESIZE_FIELD)
    private Integer fileSize;

    public VideoNote() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getDuration() {
        return duration;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    @Override
    public String toString() {
        return "VideoNote{" +
                "fileId='" + fileId + '\'' +
                ", length=" + length +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", fileSize=" + fileSize +
                '}';
    }
}
