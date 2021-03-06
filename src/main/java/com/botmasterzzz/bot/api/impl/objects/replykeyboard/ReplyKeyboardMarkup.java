package com.botmasterzzz.bot.api.impl.objects.replykeyboard;

import com.botmasterzzz.bot.api.impl.objects.replykeyboard.buttons.KeyboardRow;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize
public class ReplyKeyboardMarkup implements ReplyKeyboard {

    private static final String KEYBOARD_FIELD = "keyboard";
    private static final String RESIZEKEYBOARD_FIELD = "resize_keyboard";
    private static final String ONETIMEKEYBOARD_FIELD = "one_time_keyboard";
    private static final String SELECTIVE_FIELD = "selective";

    @JsonProperty(KEYBOARD_FIELD)
    private List<KeyboardRow> keyboard; ///< Array of button rows, each represented by an Array of Strings
    @JsonProperty(RESIZEKEYBOARD_FIELD)
    private Boolean resizeKeyboard; ///< Optional. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to false.
    @JsonProperty(ONETIMEKEYBOARD_FIELD)
    private Boolean oneTimeKeyboard; ///< Optional. Requests clients to hide the keyboard as soon as it's been used. Defaults to false.

    @JsonProperty(SELECTIVE_FIELD)
    private Boolean selective;

    public ReplyKeyboardMarkup() {
        super();
        keyboard = new ArrayList<>();
    }

    public ReplyKeyboardMarkup(List<KeyboardRow> keyboard) {
        super();
        this.keyboard = keyboard;
    }

    public List<KeyboardRow> getKeyboard() {
        return keyboard;
    }

    public ReplyKeyboardMarkup setKeyboard(List<KeyboardRow> keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public Boolean getResizeKeyboard() {
        return resizeKeyboard;
    }

    public ReplyKeyboardMarkup setResizeKeyboard(Boolean resizeKeyboard) {
        this.resizeKeyboard = resizeKeyboard;
        return this;
    }

    public Boolean getOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    public ReplyKeyboardMarkup setOneTimeKeyboard(Boolean oneTimeKeyboard) {
        this.oneTimeKeyboard = oneTimeKeyboard;
        return this;
    }

    public Boolean getSelective() {
        return selective;
    }

    public ReplyKeyboardMarkup setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (keyboard == null) {
            throw new TelegramApiValidationException("Keyboard parameter can't be null", this);
        }
        for (KeyboardRow keyboardButtons : keyboard) {
            keyboardButtons.validate();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ReplyKeyboardMarkup)) {
            return false;
        }
        ReplyKeyboardMarkup replyKeyboardMarkup = (ReplyKeyboardMarkup) o;
        return Objects.equals(keyboard, replyKeyboardMarkup.keyboard)
                && Objects.equals(oneTimeKeyboard, replyKeyboardMarkup.oneTimeKeyboard)
                && Objects.equals(resizeKeyboard, replyKeyboardMarkup.resizeKeyboard)
                && Objects.equals(selective, replyKeyboardMarkup.selective)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                keyboard,
                oneTimeKeyboard,
                resizeKeyboard,
                selective);
    }

    @Override
    public String toString() {
        return "ReplyKeyboardMarkup{" +
                "keyboard=" + keyboard +
                ", resizeKeyboard=" + resizeKeyboard +
                ", oneTimeKeyboard=" + oneTimeKeyboard +
                ", selective=" + selective +
                '}';
    }
}