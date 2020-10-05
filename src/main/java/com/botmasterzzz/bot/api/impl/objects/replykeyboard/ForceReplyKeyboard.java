package com.botmasterzzz.bot.api.impl.objects.replykeyboard;

import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize
public class ForceReplyKeyboard implements ReplyKeyboard {
    private static final String FORCEREPLY_FIELD = "force_reply";
    private static final String SELECTIVE_FIELD = "selective";

    @JsonProperty(FORCEREPLY_FIELD)
    private final Boolean forceReply;

    @JsonProperty(SELECTIVE_FIELD)
    private Boolean selective;

    public ForceReplyKeyboard() {
        super();
        this.forceReply = true;
    }

    public Boolean getForceReply() {
        return forceReply;
    }

    public Boolean getSelective() {
        return selective;
    }

    public ForceReplyKeyboard setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (forceReply == null) {
            throw new TelegramApiValidationException("ForceReply parameter can't not be null", this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ForceReplyKeyboard)) {
            return false;
        }
        ForceReplyKeyboard forceReplyKeyboard = (ForceReplyKeyboard) o;
        return Objects.equals(forceReply, forceReplyKeyboard.forceReply)
                && Objects.equals(selective, forceReplyKeyboard.selective)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                forceReply,
                selective);
    }

    @Override
    public String toString() {
        return "ForceReplyKeyboard{" +
                "forceReply=" + forceReply +
                ", selective=" + selective +
                '}';
    }
}