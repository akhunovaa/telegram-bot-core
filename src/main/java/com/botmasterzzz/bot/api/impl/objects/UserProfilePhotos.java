package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserProfilePhotos implements BotApiObject {

    private static final String TOTALCOUNT_FIELD = "total_count";
    private static final String PHOTOS_FIELD = "photos";

    @JsonProperty(TOTALCOUNT_FIELD)
    private Integer totalCount;
    @JsonProperty(PHOTOS_FIELD)
    private List<List<PhotoSize>> photos;

    public UserProfilePhotos() {
        super();
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public List<List<PhotoSize>> getPhotos() {
        return photos;
    }

    @Override
    public String toString() {
        return "UserProfilePhotos{" +
                "totalCount=" + totalCount +
                ", photos=" + photos +
                '}';
    }
}
