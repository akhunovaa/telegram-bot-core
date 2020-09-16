package com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent;

import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputContactMessageContent implements InputMessageContent {

    private static final String PHONE_NUMBER_FIELD = "phone_number";
    private static final String FIRST_NAME_FIELD = "first_name";
    private static final String LAST_NAME_FIELD = "last_name";

    @JsonProperty(PHONE_NUMBER_FIELD)
    private String phoneNumber;
    @JsonProperty(FIRST_NAME_FIELD)
    private String firstName;
    @JsonProperty(LAST_NAME_FIELD)
    private String lastName;

    public InputContactMessageContent() {
        super();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public InputContactMessageContent setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public InputContactMessageContent setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public InputContactMessageContent setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new TelegramApiValidationException("PhoneNumber parameter can't be empty", this);
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new TelegramApiValidationException("FirstName parameter can't be empty", this);
        }
    }

    @Override
    public String toString() {
        return "InputContactMessageContent{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
