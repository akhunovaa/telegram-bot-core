package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.InvalidParameterException;
import java.text.MessageFormat;

public class File implements BotApiObject {

    private static final String FILE_ID = "file_id";
    private static final String FILE_SIZE_FIELD = "file_size";
    private static final String FILE_PATH_FIELD = "file_path";

    @JsonProperty(FILE_ID)
    private String fileId;
    @JsonProperty(FILE_SIZE_FIELD)
    private Integer fileSize;
    @JsonProperty(FILE_PATH_FIELD)
    private String filePath;

    public File() {
        super();
    }

    public static String getFileUrl(String botToken, String filePath) {
        if (botToken == null || botToken.isEmpty()) {
            throw new InvalidParameterException("Bot token can't be empty");
        }
        return MessageFormat.format("http://10.0.0.6:7116/file/bot{0}/{1}", botToken, filePath);
    }

    public String getFileId() {
        return fileId;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId='" + fileId + '\'' +
                ", fileSize=" + fileSize +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public String getFileUrl(String botToken) {
        return getFileUrl(botToken, filePath);
    }
}
