package com.botmasterzzz.bot.exceptions;

import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.ResponseParameters;
import com.botmasterzzz.bot.logging.BotLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;

public class TelegramApiRequestException extends TelegramApiException {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String ERRORDESCRIPTIONFIELD = "description";
    private static final String ERRORCODEFIELD = "error_code";
    private static final String PARAMETERSFIELD = "parameters";

    private String apiResponse = null;
    private Integer errorCode = 0;
    private ResponseParameters parameters;

    public TelegramApiRequestException(String message) {
        super(message);
    }

    public TelegramApiRequestException(String message, JSONObject object) {
        super(message);
        apiResponse = object.getString(ERRORDESCRIPTIONFIELD);
        errorCode = object.getInt(ERRORCODEFIELD);
        if (object.has(PARAMETERSFIELD)) {
            try {
                parameters = OBJECT_MAPPER.readValue(object.getJSONObject(PARAMETERSFIELD).toString(), ResponseParameters.class);
            } catch (IOException e) {
                BotLogger.severe("APIEXCEPTION", e);
            }
        }
    }

    public TelegramApiRequestException(String message, ApiResponse response) {
        super(message);
        apiResponse = response.getErrorDescription();
        errorCode = response.getErrorCode();
        parameters = response.getParameters();
    }

    public TelegramApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getApiResponse() {
        return apiResponse;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public ResponseParameters getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        if (apiResponse == null) {
            return super.toString();
        } else if (errorCode == null) {
            return super.toString() + ": " + apiResponse;
        } else {
            return super.toString() + ": [" + errorCode + "] " + apiResponse;
        }
    }
}
