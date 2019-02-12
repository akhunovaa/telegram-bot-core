package com.botmasterzzz.bot.exceptions;

import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.impl.methods.PartialBotApiMethod;

public class TelegramApiValidationException  extends TelegramApiException {
    private PartialBotApiMethod method;
    private InputBotApiObject object;

    public TelegramApiValidationException(String message, PartialBotApiMethod method) {
        super(message);
        this.method = method;
    }

    public TelegramApiValidationException(String message, InputBotApiObject object) {
        super(message);
        this.object = object;
    }

    public PartialBotApiMethod getMethod() {
        return method;
    }

    public InputBotApiObject getObject() {
        return object;
    }

    @Override
    public String toString() {
        if (method != null) {
            return super.toString() + " in method: " + method.toString();
        }
        if (object != null) {
            return super.toString() + " in object: " + object.toString();
        }
        return super.toString();
    }
}
