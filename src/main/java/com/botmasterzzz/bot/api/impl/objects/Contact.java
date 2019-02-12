package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact implements BotApiObject {

    private static final String PHONENUMBER_FIELD = "phone_number";
    private static final String FIRSTNAME_FIELD = "first_name";
    private static final String LASTNAME_FIELD = "last_name";
    private static final String USERID_FIELD = "user_id";
    private static final String VCARD_FIELD = "vcard";

    @JsonProperty(PHONENUMBER_FIELD)
    private String phoneNumber;
    @JsonProperty(FIRSTNAME_FIELD)
    private String firstName;
    @JsonProperty(LASTNAME_FIELD)
    private String lastName;
    @JsonProperty(USERID_FIELD)
    private Integer userID;
    @JsonProperty(VCARD_FIELD)
    private String vCard;

    public Contact() {
        super();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getVCard() {
        return vCard;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userID=" + userID +
                ", vCard=" + vCard +
                '}';
    }
}
