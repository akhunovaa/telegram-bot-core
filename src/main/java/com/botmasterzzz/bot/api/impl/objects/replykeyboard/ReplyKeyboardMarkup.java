package com.botmasterzzz.bot.api.impl.objects.replykeyboard;

import com.botmasterzzz.bot.api.impl.objects.replykeyboard.buttons.KeyboardRow;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReplyKeyboardMarkup implements ReplyKeyboard {
    private static final String KEYBOARD_FIELD = "keyboard";
    private static final String RESIZEKEYBOARD_FIELD = "resize_keyboard";
    private static final String ONETIMEKEYBOARD_FIELD = "one_time_keyboard";
    private static final String SELECTIVE_FIELD = "selective";

    @JsonProperty(KEYBOARD_FIELD)
    private List<KeyboardRow> keyboard;
    @JsonProperty(RESIZEKEYBOARD_FIELD)
    private Boolean resizeKeyboard;
    @JsonProperty(ONETIMEKEYBOARD_FIELD)
    private Boolean oneTimeKeyboard;

    @JsonProperty(SELECTIVE_FIELD)
    private Boolean selective;

    public ReplyKeyboardMarkup() {
        super();
        keyboard = new ArrayList<>();
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
