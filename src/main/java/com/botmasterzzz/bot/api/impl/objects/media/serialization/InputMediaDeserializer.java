package com.botmasterzzz.bot.api.impl.objects.media.serialization;

import com.botmasterzzz.bot.api.impl.objects.media.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class InputMediaDeserializer extends StdDeserializer<InputMedia> {
    private final ObjectMapper objectMapper;

    public InputMediaDeserializer() {
        this(null);
    }

    public InputMediaDeserializer(Class<?> vc) {
        super(vc);
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public InputMedia deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        switch (node.get("type").asText()) {
            case "photo":
                return objectMapper.readValue(node.toString(),
                        new com.fasterxml.jackson.core.type.TypeReference<InputMediaPhoto>() {
                        });
            case "video":
                return objectMapper.readValue(node.toString(),
                        new com.fasterxml.jackson.core.type.TypeReference<InputMediaVideo>() {
                        });
            case "audio":
                return objectMapper.readValue(node.toString(),
                        new com.fasterxml.jackson.core.type.TypeReference<InputMediaAudio>() {
                        });
            case "document":
                return objectMapper.readValue(node.toString(),
                        new com.fasterxml.jackson.core.type.TypeReference<InputMediaDocument>() {
                        });
        }

        return null;
    }
}
