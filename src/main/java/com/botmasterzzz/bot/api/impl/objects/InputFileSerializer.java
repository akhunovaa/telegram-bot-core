package com.botmasterzzz.bot.api.impl.objects;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import java.io.IOException;

public class InputFileSerializer extends JsonSerializer<InputFile> {
    @Override
    public void serialize(InputFile value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(value.getAttachName());
    }

    @Override
    public void serializeWithType(InputFile value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        gen.writeObject(value.getAttachName());
    }
}