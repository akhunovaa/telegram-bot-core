package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.impl.objects.Update;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetUpdates extends BotApiMethod<ArrayList<Update>> {
    public static final String PATH = "getupdates";

    private static final String OFFSET_FIELD = "offset";
    private static final String LIMIT_FIELD = "limit";
    private static final String TIMEOUT_FIELD = "timeout";
    private static final String ALLOWEDUPDATES_FIELD = "allowed_updates";

    @JsonProperty(OFFSET_FIELD)
    private Integer offset;

    @JsonProperty(LIMIT_FIELD)
    private Integer limit;

    @JsonProperty(TIMEOUT_FIELD)
    private Integer timeout;

    @JsonProperty(ALLOWEDUPDATES_FIELD)
    private List<String> allowedUpdates;

    public GetUpdates() {
        super();
    }

    public Integer getOffset() {
        return offset;
    }

    public GetUpdates setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public GetUpdates setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public GetUpdates setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public List<String> getAllowedUpdates() {
        return allowedUpdates;
    }

    public GetUpdates setAllowedUpdates(List<String> allowedUpdates) {
        this.allowedUpdates = allowedUpdates;
        return this;
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public ArrayList<Update> deserializeResponse(String answer) throws
            TelegramApiRequestException {
        try {
            ApiResponse<ArrayList<Update>> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<ArrayList<Update>>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error getting updates", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
    }

    @Override
    public String toString() {
        return "GetUpdates{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", timeout=" + timeout +
                ", allowedUpdates=" + allowedUpdates +
                '}';
    }
}
