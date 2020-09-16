package com.botmasterzzz.bot.api.impl.objects.polls;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.MessageEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Poll implements BotApiObject {
    private static final String ID_FIELD = "id";
    private static final String QUESTION_FIELD = "question";
    private static final String OPTIONS_FIELD = "options";
    private static final String TOTALVOTERCOUNT_FIELD = "total_voter_count";
    private static final String ISCLOSED_FIELD = "is_closed";
    private static final String ISANONYMOUS_FIELD = "is_anonymous";
    private static final String TYPE_FIELD = "type";
    private static final String ALLOWSMULTIPLEANSWERS_FIELD = "allows_multiple_answers";
    private static final String CORRECTOPTIONID_FIELD = "correct_option_id";
    private static final String OPENPERIOD_FIELD = "open_period";
    private static final String CLOSEDATE_FIELD = "close_date";
    private static final String EXPLANATION_FIELD = "explanation";
    private static final String EXPLANATIONENTITIES_FIELD = "explanation_entities";

    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(QUESTION_FIELD)
    private String question;
    @JsonProperty(OPTIONS_FIELD)
    private List<PollOption> options;
    @JsonProperty(TOTALVOTERCOUNT_FIELD)
    private Integer totalVoterCount;
    @JsonProperty(ISCLOSED_FIELD)
    private Boolean isClosed;
    @JsonProperty(ISANONYMOUS_FIELD)
    private Boolean isAnonymous;
    @JsonProperty(TYPE_FIELD)
    private String type;
    @JsonProperty(ALLOWSMULTIPLEANSWERS_FIELD)
    private Boolean allowMultipleAnswers;

    @JsonProperty(CORRECTOPTIONID_FIELD)
    private Integer correctOptionId;
    @JsonProperty(OPENPERIOD_FIELD)
    private Integer openPeriod;
    @JsonProperty(CLOSEDATE_FIELD)
    private Integer closeDate;
    @JsonProperty(EXPLANATION_FIELD)
    private String explanation;
    @JsonProperty(EXPLANATIONENTITIES_FIELD)
    private List<MessageEntity> explanationEntities;

    public Poll() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<PollOption> getOptions() {
        return options;
    }

    public void setOptions(List<PollOption> options) {
        this.options = options;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public Integer getTotalVoterCount() {
        return totalVoterCount;
    }

    public void setTotalVoterCount(Integer totalVoterCount) {
        this.totalVoterCount = totalVoterCount;
    }

    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAllowMultipleAnswers() {
        return allowMultipleAnswers;
    }

    public void setAllowMultipleAnswers(Boolean allowMultipleAnswers) {
        this.allowMultipleAnswers = allowMultipleAnswers;
    }

    public Integer getCorrectOptionId() {
        return correctOptionId;
    }

    public void setCorrectOptionId(Integer correctOptionId) {
        this.correctOptionId = correctOptionId;
    }

    public Integer getOpenPeriod() {
        return openPeriod;
    }

    public Integer getCloseDate() {
        return closeDate;
    }

    public String getExplanation() {
        return explanation;
    }

    public List<MessageEntity> getExplanationEntities() {
        return explanationEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poll)) return false;
        Poll poll = (Poll) o;
        return Objects.equals(id, poll.id) &&
                Objects.equals(question, poll.question) &&
                Objects.equals(options, poll.options) &&
                Objects.equals(totalVoterCount, poll.totalVoterCount) &&
                Objects.equals(isClosed, poll.isClosed) &&
                Objects.equals(isAnonymous, poll.isAnonymous) &&
                Objects.equals(type, poll.type) &&
                Objects.equals(allowMultipleAnswers, poll.allowMultipleAnswers) &&
                Objects.equals(correctOptionId, poll.correctOptionId) &&
                Objects.equals(openPeriod, poll.openPeriod) &&
                Objects.equals(closeDate, poll.closeDate) &&
                Objects.equals(explanation, poll.explanation) &&
                Objects.equals(explanationEntities, poll.explanationEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, options, totalVoterCount, isClosed, isAnonymous, type, allowMultipleAnswers, correctOptionId, openPeriod, closeDate, explanation, explanationEntities);
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", options=" + options +
                ", totalVoterCount=" + totalVoterCount +
                ", isClosed=" + isClosed +
                ", isAnonymous=" + isAnonymous +
                ", type='" + type + '\'' +
                ", allowMultipleAnswers=" + allowMultipleAnswers +
                ", correctOptionId=" + correctOptionId +
                ", openPeriod=" + openPeriod +
                ", closeDate=" + closeDate +
                ", explanation='" + explanation + '\'' +
                ", explanationEntities=" + explanationEntities +
                '}';
    }
}