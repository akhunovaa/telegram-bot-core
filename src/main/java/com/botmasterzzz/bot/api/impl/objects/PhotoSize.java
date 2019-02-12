package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PhotoSize implements BotApiObject {

    private static final String FILEID_FIELD = "file_id";
    private static final String WIDTH_FIELD = "width";
    private static final String HEIGHT_FIELD = "height";
    private static final String FILESIZE_FIELD = "file_size";
    private static final String FILEPATH_FIELD = "file_path";

    @JsonProperty(FILEID_FIELD)
    private String fileId;
    @JsonProperty(WIDTH_FIELD)
    private Integer width;
    @JsonProperty(HEIGHT_FIELD)
    private Integer height;
    @JsonProperty(FILESIZE_FIELD)
    private Integer fileSize;
    @JsonProperty(FILEPATH_FIELD)
    private String filePath;

    public PhotoSize() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean hasFilePath() {
        return filePath != null && !filePath.isEmpty();
    }

    @Override
    public String toString() {
        return "PhotoSize{" +
                "fileId='" + fileId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", fileSize=" + fileSize +
                '}';
    }
}
