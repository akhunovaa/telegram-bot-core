package com.botmasterzzz.bot.api.impl.objects.polls;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PollOption implements BotApiObject {
    private static final String TEXT_FIELD = "text";
    private static final String VOTERCOUNT_FIELD = "voter_count";

    @JsonProperty(TEXT_FIELD)
    private String text;
    @JsonProperty(VOTERCOUNT_FIELD)
    private Integer voterCount;

    public PollOption() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getVoterCount() {
        return voterCount;
    }

    public void setVoterCount(Integer voterCount) {
        this.voterCount = voterCount;
    }

    @Override
    public String toString() {
        return "PollOption{" +
                "text='" + text + '\'' +
                ", voterCount=" + voterCount +
                '}';
    }
}