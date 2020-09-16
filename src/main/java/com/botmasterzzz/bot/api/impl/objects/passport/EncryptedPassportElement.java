package com.botmasterzzz.bot.api.impl.objects.passport;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("unused")
public class EncryptedPassportElement implements BotApiObject {
    private static final String TYPE_FIELD = "type";
    private static final String DATA_FIELD = "data";
    private static final String PHONENUMBER_FIELD = "phone_number";
    private static final String EMAIL_FIELD = "email";
    private static final String FILES_FIELD = "files";
    private static final String FRONTSIDE_FIELD = "front_side";
    private static final String REVERSESIDE_FIELD = "reverse_side";
    private static final String SELFIE_FIELD = "selfie";

    @JsonProperty(TYPE_FIELD)
    private String type;
    @JsonProperty(DATA_FIELD)
    private String data;
    @JsonProperty(PHONENUMBER_FIELD)
    private String phoneNumber;
    @JsonProperty(EMAIL_FIELD)
    private String email;
    @JsonProperty(FILES_FIELD)
    private List<PassportFile> files;
    @JsonProperty(FRONTSIDE_FIELD)
    private PassportFile frontSide;
    @JsonProperty(REVERSESIDE_FIELD)
    private PassportFile reverseSide;
    @JsonProperty(SELFIE_FIELD)
    private PassportFile selfie;

    public EncryptedPassportElement(String type, String data, String phoneNumber, String email, List<PassportFile> files,
                                    PassportFile frontSide, PassportFile reverseSide, PassportFile selfie) {
        this.type = type;
        this.data = data;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.files = files;
        this.frontSide = frontSide;
        this.reverseSide = reverseSide;
        this.selfie = selfie;
    }

    public EncryptedPassportElement() {
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public List<PassportFile> getFiles() {
        return files;
    }

    public PassportFile getFrontSide() {
        return frontSide;
    }

    public PassportFile getReverseSide() {
        return reverseSide;
    }

    public PassportFile getSelfie() {
        return selfie;
    }

    @Override
    public String toString() {
        return "EncryptedPassportElement{" +
                "type='" + type + '\'' +
                ", data='" + data + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", files=" + files +
                ", frontSide=" + frontSide +
                ", reverseSide=" + reverseSide +
                ", selfie=" + selfie +
                '}';
    }
}