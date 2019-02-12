package com.botmasterzzz.bot.api.impl.methods;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BotApiMethod<T extends Serializable> extends PartialBotApiMethod<T>  {

    protected static final String METHOD_FIELD = "method";

    @JsonProperty(METHOD_FIELD)
    public abstract String getMethod();

}
