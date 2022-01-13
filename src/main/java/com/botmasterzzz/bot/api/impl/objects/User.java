package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User implements BotApiObject {

    private static final String ID_FIELD = "id";
    private static final String FIRSTNAME_FIELD = "first_name";
    private static final String ISBOT_FIELD = "is_bot";
    private static final String LASTNAME_FIELD = "last_name";
    private static final String USERNAME_FIELD = "username";
    private static final String LANGUAGECODE_FIELD = "language_code";

    @JsonProperty(ID_FIELD)
    private Long id;
    @JsonProperty(FIRSTNAME_FIELD)
    private String firstName;
    @JsonProperty(ISBOT_FIELD)
    private Boolean isBot;
    @JsonProperty(LASTNAME_FIELD)
    private String lastName;
    @JsonProperty(USERNAME_FIELD)
    private String userName;
    @JsonProperty(LANGUAGECODE_FIELD)
    private String languageCode;

    public User() {
        super();
    }

    public User(Long id, String firstName, Boolean isBot, String lastName, String userName, String languageCode) {
        this.id = id;
        this.firstName = firstName;
        this.isBot = isBot;
        this.lastName = lastName;
        this.userName = userName;
        this.languageCode = languageCode;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public Boolean getBot() {
        return isBot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(isBot, user.isBot) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(languageCode, user.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, isBot, lastName, userName, languageCode);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", isBot=" + isBot +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }


}
