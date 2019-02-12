package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;

public class GetFile extends BotApiMethod<File> {
    public static final String PATH = "getFile";

    private static final String FILEID_FIELD = "file_id";

    @JsonProperty(FILEID_FIELD)
    private String fileId;

    public GetFile() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public GetFile setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (fileId == null) {
            throw new TelegramApiValidationException("FileId can't be empty", this);
        }
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public File deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<File> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<File>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error getting file", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public String toString() {
        return "GetFile{" +
                "fileId='" + fileId + '\'' +
                '}';
    }
}
