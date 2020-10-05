package com.botmasterzzz.bot.api.impl.objects.media.serialization;

import com.botmasterzzz.bot.api.impl.objects.media.InputMedia;
import com.botmasterzzz.bot.api.impl.objects.media.InputMediaAudio;
import com.botmasterzzz.bot.api.impl.objects.media.InputMediaDocument;
import com.botmasterzzz.bot.api.impl.objects.media.InputMediaVideo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import java.io.IOException;

public class InputMediaSerializer extends JsonSerializer<InputMedia> {
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

        if (value instanceof InputMediaAudio) {
            InputMediaAudio audio = (InputMediaAudio) value;
            if (audio.getThumb() != null) {
                gen.writeStringField(InputMediaAudio.THUMB_FIELD, audio.getThumb().getAttachName());
            }
            if (audio.getDuration() != null) {
                gen.writeNumberField(InputMediaAudio.DURATION_FIELD, audio.getDuration());
            }
            if (audio.getPerformer() != null) {
                gen.writeStringField(InputMediaAudio.PERFORMER_FIELD, audio.getPerformer());
            }
            if (audio.getTitle() != null) {
                gen.writeStringField(InputMediaAudio.TITLE_FIELD, audio.getTitle());
            }
        } else if (value instanceof InputMediaDocument) {
            InputMediaDocument document = (InputMediaDocument) value;
            if (document.getThumb() != null) {
                gen.writeStringField(InputMediaDocument.THUMB_FIELD, document.getThumb().getAttachName());
            }
        } else if (value instanceof InputMediaVideo) {
            InputMediaVideo video = (InputMediaVideo) value;
            if (video.getThumb() != null) {
                gen.writeStringField(InputMediaVideo.THUMB_FIELD, video.getThumb().getAttachName());
            }
            if (video.getDuration() != null) {
                gen.writeNumberField(InputMediaVideo.DURATION_FIELD, video.getDuration());
            }
            if (video.getHeight() != null) {
                gen.writeNumberField(InputMediaVideo.HEIGHT_FIELD, video.getHeight());
            }
            if (video.getWidth() != null) {
                gen.writeNumberField(InputMediaVideo.WIDTH_FIELD, video.getWidth());
            }
            if (video.getSupportsStreaming() != null) {
                gen.writeBooleanField(InputMediaVideo.SUPPORTSSTREAMING_FIELD, video.getSupportsStreaming());
            }
        }

        gen.writeEndObject();
    }

    @Override
    public void serializeWithType(InputMedia value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        serialize(value, gen, serializers);
    }
}