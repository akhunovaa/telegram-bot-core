package com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent;

import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.inputmessagecontent.serialization.InputMessageContentDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = InputMessageContentDeserializer.class)
public interface InputMessageContent extends InputBotApiObject, Validable {
}
