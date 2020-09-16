package com.botmasterzzz.bot.api.impl.objects.passport;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PassportFile implements BotApiObject {
    private static final String FILEID_FIELD = "file_id";
    private static final String FILESIZE_FIELD = "file_size";
    private static final String FILEDATE_FIELD = "file_date";

    @JsonProperty(FILEID_FIELD)
    private String fileId;
    @JsonProperty(FILESIZE_FIELD)
    private Integer fileSize;
    @JsonProperty(FILEDATE_FIELD)
    private Integer fileDate;

    public PassportFile() {
    }

    public PassportFile(String fileId, Integer fileSize, Integer fileDate) {
        this.fileId = fileId;
        this.fileSize = fileSize;
        this.fileDate = fileDate;
    }

    public String getFileId() {
        return fileId;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public Integer getFileDate() {
        return fileDate;
    }

    @Override
    public String toString() {
        return "PassportFile{" +
                "fileId='" + fileId + '\'' +
                ", fileSize=" + fileSize +
                ", fileDate=" + fileDate +
                '}';
    }
}