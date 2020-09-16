package com.botmasterzzz.bot.api.impl.objects.passport;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PassportData implements BotApiObject {
    private static final String DATA_FIELD = "data";
    private static final String CREDENTIALS_FIELD = "credentials";

    @JsonProperty(DATA_FIELD)
    private List<EncryptedPassportElement> data;
    @JsonProperty(CREDENTIALS_FIELD)
    private EncryptedCredentials credentials;

    public PassportData() {
    }

    public PassportData(List<EncryptedPassportElement> data, EncryptedCredentials credentials) {
        this.data = data;
        this.credentials = credentials;
    }

    public List<EncryptedPassportElement> getData() {
        return data;
    }

    public EncryptedCredentials getCredentials() {
        return credentials;
    }

    @Override
    public String toString() {
        return "PassportData{" +
                "data=" + data +
                ", credentials=" + credentials +
                '}';
    }
}