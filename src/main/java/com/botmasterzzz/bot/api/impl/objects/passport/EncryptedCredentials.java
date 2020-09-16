package com.botmasterzzz.bot.api.impl.objects.passport;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EncryptedCredentials implements BotApiObject {
    private static final String DATA_FIELD = "data";
    private static final String HASH_FIELD = "hash";
    private static final String SECRET_FIELD = "secret";

    @JsonProperty(DATA_FIELD)
    private String data;
    @JsonProperty(HASH_FIELD)
    private String hash;
    @JsonProperty(SECRET_FIELD)
    private String secret;

    public EncryptedCredentials() {
    }

    public EncryptedCredentials(String data, String hash, String secret) {
        this.data = data;
        this.hash = hash;
        this.secret = secret;
    }

    public String getData() {
        return data;
    }

    public String getHash() {
        return hash;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return "EncryptedCredentials{" +
                "data='" + data + '\'' +
                ", hash='" + hash + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}