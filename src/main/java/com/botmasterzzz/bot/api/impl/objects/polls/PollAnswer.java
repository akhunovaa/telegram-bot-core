package com.botmasterzzz.bot.api.impl.objects.polls;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class PollAnswer implements BotApiObject {
    private static final String POLLID_FIELD = "poll_id";
    private static final String USER_FIELD = "user";
    private static final String OPTIONIDS_FIELD = "option_ids";

    @JsonProperty(POLLID_FIELD)
    private String pollId;
    @JsonProperty(USER_FIELD)
    private User user;
    @JsonProperty(OPTIONIDS_FIELD)
    private List<Integer> optionIds;

    public PollAnswer() {
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getOptionIds() {
        return optionIds;
    }

    public void setOptionIds(List<Integer> optionIds) {
        this.optionIds = optionIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PollAnswer)) return false;
        PollAnswer that = (PollAnswer) o;
        return Objects.equals(pollId, that.pollId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(optionIds, that.optionIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pollId, user, optionIds);
    }

    @Override
    public String toString() {
        return "PollAnswer{" +
                "pollId='" + pollId + '\'' +
                ", user=" + user +
                ", optionIds=" + optionIds +
                '}';
    }
}