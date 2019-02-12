package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Document implements BotApiObject {

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
    private String mimeType;
    @JsonProperty(FILESIZE_FIELD)
    private Integer fileSize;

    public Document() {
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

    public String getMimeType() {
        return mimeType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    @Override
    public String toString() {
        return "Document{" +
                "fileId='" + fileId + '\'' +
                ", thumb=" + thumb +
                ", fileName='" + fileName + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
