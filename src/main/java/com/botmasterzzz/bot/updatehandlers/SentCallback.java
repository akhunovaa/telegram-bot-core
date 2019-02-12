package com.botmasterzzz.bot.updatehandlers;

import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;

import java.io.Serializable;

public interface SentCallback<T extends Serializable> {


    void onResult(BotApiMethod<T> method, T response);


    void onError(BotApiMethod<T> method, TelegramApiRequestException apiException);


    void onException(BotApiMethod<T> method, Exception exception);
}
