package com.botmasterzzz.bot.api.impl.objects.stickers;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StickerSet implements BotApiObject {
    private static final String NAME_FIELD = "name";
    private static final String TITLE_FIELD = "title";
    private static final String CONTAINSMASKS_FIELD = "contains_masks";
    private static final String STICKERS_FIELD = "stickers";

    @JsonProperty(NAME_FIELD)
    private String name;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(CONTAINSMASKS_FIELD)
    private Boolean containsMasks;
    @JsonProperty(STICKERS_FIELD)
    private List<Sticker> stickers;

    public StickerSet() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getContainsMasks() {
        return containsMasks;
    }

    public List<Sticker> getStickers() {
        return stickers;
    }

    @Override
    public String toString() {
        return "StickerSet{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", containsMasks=" + containsMasks +
                ", stickers=" + stickers +
                '}';
    }
}
