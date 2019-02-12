package com.botmasterzzz.bot.api.impl.objects.media;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import java.io.IOException;

public class InputMediaSerializer  extends JsonSerializer<InputMedia> {
    @Override
    public void serialize(InputMedia value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField(InputMedia.MEDIA_FIELD, value.getMedia());
        gen.writeStringField(InputMedia.TYPE_FIELD, value.getType());
        if (value.getCaption() != null) {
            gen.writeStringField(InputMedia.CAPTION_FIELD, value.getCaption());
        }
        if (value.getParseMode() != null) {
            gen.writeStringField(InputMedia.PARSEMODE_FIELD, value.getParseMode());
        }

      if (value instanceof InputMediaDocument) {
            InputMediaDocument document = (InputMediaDocument) value;
            if (document.getThumb() != null) {
                gen.writeStringField(InputMediaDocument.THUMB_FIELD, document.getThumb().getAttachName());
            }
        }
        gen.writeEndObject();
    }

    @Override
    public void serializeWithType(InputMedia value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        serialize(value, gen, serializers);
    }
}
