package com.botmasterzzz.bot.api.impl.objects.replykeyboard;

import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize
public class ReplyKeyboardRemove implements ReplyKeyboard {
    private static final String REMOVEKEYBOARD_FIELD = "remove_keyboard";
    private static final String SELECTIVE_FIELD = "selective";

    @JsonProperty(REMOVEKEYBOARD_FIELD)
    private final Boolean removeKeyboard; ///< Requests clients to remove the custom keyboard

    @JsonProperty(SELECTIVE_FIELD)
    private Boolean selective;

    public ReplyKeyboardRemove() {
        super();
        this.removeKeyboard = true;
    }

    public Boolean getRemoveKeyboard() {
        return removeKeyboard;
    }

    public Boolean getSelective() {
        return selective;
    }

    public ReplyKeyboardRemove setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (removeKeyboard == null) {
            throw new TelegramApiValidationException("RemoveKeyboard parameter can't be null", this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ReplyKeyboardRemove)) {
            return false;
        }
        ReplyKeyboardRemove replyKeyboardRemove = (ReplyKeyboardRemove) o;
        return Objects.equals(removeKeyboard, replyKeyboardRemove.removeKeyboard)
                && Objects.equals(selective, replyKeyboardRemove.selective)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                removeKeyboard,
                selective);
    }

    @Override
    public String toString() {
        return "ReplyKeyboardRemove{" +
                "removeKeyboard=" + removeKeyboard +
                ", selective=" + selective +
                '}';
    }
}