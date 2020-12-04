package com.botmasterzzz.bot.api.impl.objects;

import com.google.common.base.Objects;

import java.io.Serializable;

public class ProfileInfoResponse implements Serializable {

    private Long UsersTelegramIdentifier;
    private UserProfilePhotos userProfilePhotos;

    public Long getUsersTelegramIdentifier() {
        return UsersTelegramIdentifier;
    }

    public void setUsersTelegramIdentifier(Long usersTelegramIdentifier) {
        UsersTelegramIdentifier = usersTelegramIdentifier;
    }

    public UserProfilePhotos getUserProfilePhotos() {
        return userProfilePhotos;
    }

    public void setUserProfilePhotos(UserProfilePhotos userProfilePhotos) {
        this.userProfilePhotos = userProfilePhotos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileInfoResponse that = (ProfileInfoResponse) o;
        return Objects.equal(UsersTelegramIdentifier, that.UsersTelegramIdentifier) &&
                Objects.equal(userProfilePhotos, that.userProfilePhotos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(UsersTelegramIdentifier, userProfilePhotos);
    }

    @Override
    public String toString() {
        return "ProfileInfoResponse{" +
                "UsersTelegramIdentifier=" + UsersTelegramIdentifier +
                ", userProfilePhotos=" + userProfilePhotos +
                '}';
    }
}
