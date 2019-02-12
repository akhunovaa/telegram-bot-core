package com.botmasterzzz.bot.api.impl.objects.media;

import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;

public class InputMediaPhoto extends InputMedia<InputMediaPhoto> {
    private static final String TYPE = "photo";

    public InputMediaPhoto() {
        super();
    }

    public InputMediaPhoto(String media, String caption) {
        super(media, caption);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        super.validate();
    }

    @Override
    public String toString() {
        return "InputMediaPhoto{} " + super.toString();
    }
}
