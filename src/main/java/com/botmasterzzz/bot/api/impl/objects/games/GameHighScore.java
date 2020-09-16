package com.botmasterzzz.bot.api.impl.objects.games;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameHighScore implements BotApiObject {
    private static final String POSITION_FIELD = "position";
    private static final String USER_FIELD = "user";
    private static final String SCORE_FIELD = "score";

    @JsonProperty(POSITION_FIELD)
    private Integer position;
    @JsonProperty(USER_FIELD)
    private User user;
    @JsonProperty(SCORE_FIELD)
    private Integer score;

    public Integer getPosition() {
        return position;
    }

    public User getUser() {
        return user;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "GameHighScore{" +
                "position=" + position +
                ", user=" + user +
                ", score=" + score +
                '}';
    }
}
