package com.botmasterzzz.bot.api.impl.objects.media;

import com.botmasterzzz.bot.api.impl.objects.InputFile;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize
public class InputMediaDocument extends InputMedia<InputMediaDocument> {

    public static final String THUMB_FIELD = "thumb";
    private static final String TYPE = "document";
    private InputFile thumb;

    public InputMediaDocument() {
        super();
    }

    public InputMediaDocument(String media, String caption) {
        super(media, caption);
    }

    public InputFile getThumb() {
        return thumb;
    }

    public InputMediaDocument setThumb(InputFile thumb) {
        this.thumb = thumb;
        return this;
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
        return "InputMediaDocument{" +
                "thumb=" + thumb +
                "} " + super.toString();
    }
}