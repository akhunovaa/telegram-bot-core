package com.botmasterzzz.bot.api.impl.objects.inlinequery.result;

import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.result.serialization.InlineQueryResultDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = InlineQueryResultDeserializer.class)
public interface InlineQueryResult extends InputBotApiObject, Validable {
}