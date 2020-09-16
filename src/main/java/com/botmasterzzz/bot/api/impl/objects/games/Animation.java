package com.botmasterzzz.bot.api.impl.objects.games;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.PhotoSize;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Animation implements BotApiObject {
    private static final String FILEID_FIELD = "file_id";
    private static final String THUMB_FIELD = "thumb";
    private static final String FILENAME_FIELD = "file_name";
    private static final String MIMETYPE_FIELD = "mime_type";
    private static final String FILESIZE_FIELD = "file_size";

    @JsonProperty(FILEID_FIELD)
    private String fileId;
    @JsonProperty(THUMB_FIELD)
    private PhotoSize thumb;
    @JsonProperty(FILENAME_FIELD)
    private String fileName;
    @JsonProperty(MIMETYPE_FIELD)
    private String mimetype;
    @JsonProperty(FILESIZE_FIELD)
    private Integer fileSize;

    public Animation() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMimetype() {
        return mimetype;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    @Override
    public String toString() {
        return "Animation{" +
                "fileId='" + fileId + '\'' +
                ", thumb=" + thumb +
                ", fileName='" + fileName + '\'' +
                ", mimetype='" + mimetype + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
