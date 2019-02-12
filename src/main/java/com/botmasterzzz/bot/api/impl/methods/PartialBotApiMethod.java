package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public abstract class PartialBotApiMethod<T extends Serializable> implements Validable {

    @JsonIgnore
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public abstract T deserializeResponse(String answer) throws TelegramApiRequestException;

}
