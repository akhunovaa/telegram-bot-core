package com.botmasterzzz.bot.api.impl.objects.games;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.MessageEntity;
import com.botmasterzzz.bot.api.impl.objects.PhotoSize;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Game implements BotApiObject {

    private static final String TITLE_FIELD = "title";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String PHOTO_FIELD = "photo";
    private static final String ANIMATION_FIELD = "animation";
    private static final String TEXT_FIELD = "text";
    private static final String TEXTENTITIES_FIELD = "text_entities";

    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(DESCRIPTION_FIELD)
    private String description;
    @JsonProperty(PHOTO_FIELD)
    private List<PhotoSize> photo;
    @JsonProperty(TEXT_FIELD)
    private String text;
    @JsonProperty(TEXTENTITIES_FIELD)
    private List<MessageEntity> entities;
    @JsonProperty(ANIMATION_FIELD)
    private Animation animation;

    public Game() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public Animation getAnimation() {
        return animation;
    }

    public String getText() {
        return text;
    }

    public boolean hasEntities() {
        return entities != null && !entities.isEmpty();
    }

    public List<MessageEntity> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + photo +
                ", animation=" + animation +
                '}';
    }
}
