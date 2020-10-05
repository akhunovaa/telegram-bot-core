package com.botmasterzzz.bot.api.impl.objects.replykeyboard;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.serialization.KeyboardDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = KeyboardDeserializer.class)
public interface ReplyKeyboard extends InputBotApiObject, BotApiObject, Validable {
}