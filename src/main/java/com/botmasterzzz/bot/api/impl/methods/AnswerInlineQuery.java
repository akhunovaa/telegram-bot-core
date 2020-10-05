package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.impl.objects.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.result.InlineQueryResult;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class AnswerInlineQuery extends BotApiMethod<Boolean> {
    public static final String PATH = "answerInlineQuery";

    private static final String INLINEQUERYID_FIELD = "inline_query_id";
    private static final String RESULTS_FIELD = "results";
    private static final String CACHETIME_FIELD = "cache_time";
    private static final String ISPERSONAL_FIELD = "is_personal";
    private static final String NEXTOFFSET_FIELD = "next_offset";
    private static final String SWITCH_PM_TEXT_FIELD = "switch_pm_text";
    private static final String SWITCH_PM_PARAMETER_FIELD = "switch_pm_parameter";

    @JsonProperty(INLINEQUERYID_FIELD)
    private String inlineQueryId;
    @JsonProperty(RESULTS_FIELD)
    private List<InlineQueryResult> results;
    @JsonProperty(CACHETIME_FIELD)
    private Integer cacheTime;
    @JsonProperty(ISPERSONAL_FIELD)
    private Boolean isPersonal;
    @JsonProperty(NEXTOFFSET_FIELD)
    private String nextOffset;
    @JsonProperty(SWITCH_PM_TEXT_FIELD)
    private String switchPmText;
    @JsonProperty(SWITCH_PM_PARAMETER_FIELD)
    private String switchPmParameter;

    public AnswerInlineQuery() {
        super();
    }

    public String getInlineQueryId() {
        return inlineQueryId;
    }

    public AnswerInlineQuery setInlineQueryId(String inlineQueryId) {
        this.inlineQueryId = inlineQueryId;
        return this;
    }

    public List<InlineQueryResult> getResults() {
        return results;
    }

    public AnswerInlineQuery setResults(List<InlineQueryResult> results) {
        this.results = results;
        return this;
    }

    @JsonIgnore
    public AnswerInlineQuery setResults(InlineQueryResult... results) {
        this.results = Arrays.asList(results);
        return this;
    }

    public Integer getCacheTime() {
        return cacheTime;
    }

    public AnswerInlineQuery setCacheTime(Integer cacheTime) {
        this.cacheTime = cacheTime;
        return this;
    }

    public Boolean isPersonal() {
        return isPersonal;
    }

    public AnswerInlineQuery setPersonal(Boolean personal) {
        isPersonal = personal;
        return this;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public AnswerInlineQuery setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
        return this;
    }

    public String getSwitchPmText() {
        return switchPmText;
    }

    public AnswerInlineQuery setSwitchPmText(String switchPmText) {
        this.switchPmText = switchPmText;
        return this;
    }

    public String getSwitchPmParameter() {
        return switchPmParameter;
    }

    public AnswerInlineQuery setSwitchPmParameter(String switchPmParameter) {
        this.switchPmParameter = switchPmParameter;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (inlineQueryId == null || inlineQueryId.isEmpty()) {
            throw new TelegramApiValidationException("InlineQueryId can't be empty", this);
        }
        if (results == null) {
            throw new TelegramApiValidationException("Results array can't be null", this);
        }
        if (switchPmText != null) {
            if (switchPmText.isEmpty()) {
                throw new TelegramApiValidationException("SwitchPmText can't be empty", this);
            }
            if (switchPmParameter == null || switchPmParameter.isEmpty()) {
                throw new TelegramApiValidationException("SwitchPmParameter can't be empty if switchPmText is present", this);
            }
            if (switchPmParameter.length() > 64) {
                throw new TelegramApiValidationException("SwitchPmParameter can't be longer than 64 chars", this);
            }
            if (!Pattern.matches("[A-Za-z0-9_\\-]+", switchPmParameter.trim())) {
                throw new TelegramApiValidationException("SwitchPmParameter only allows A-Z, a-z, 0-9, _ and - characters", this);
            }
        }
        for (InlineQueryResult result : results) {
            result.validate();
        }
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Boolean deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Boolean> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Boolean>>() {
                    });
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error answering inline query", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public String toString() {
        return "AnswerInlineQuery{" +
                "inlineQueryId='" + inlineQueryId + '\'' +
                ", results=" + results +
                ", cacheTime=" + cacheTime +
                ", isPersonal=" + isPersonal +
                ", switchPmText=" + switchPmText +
                ", switchPmParameter=" + switchPmParameter +
                ", nextOffset='" + nextOffset + '\'' +
                '}';
    }
}