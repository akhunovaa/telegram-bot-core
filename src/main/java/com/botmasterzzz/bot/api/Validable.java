package com.botmasterzzz.bot.api;

import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;

public interface Validable {

    void validate() throws TelegramApiValidationException;

}
