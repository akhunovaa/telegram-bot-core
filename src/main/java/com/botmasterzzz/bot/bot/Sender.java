package com.botmasterzzz.bot.bot;

import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.api.impl.methods.GetMe;
import com.botmasterzzz.bot.api.impl.objects.User;
import com.botmasterzzz.bot.exceptions.TelegramApiException;
import com.botmasterzzz.bot.updatehandlers.SentCallback;

import java.io.Serializable;

public abstract class Sender {
    protected Sender() {
    }

    public <T extends Serializable, Method extends BotApiMethod<T>, Callback extends SentCallback<T>> void executeAsync(Method method, Callback callback) throws TelegramApiException {
        if (method == null) {
            throw new TelegramApiException("Parameter method can not be null");
        }
        if (callback == null) {
            throw new TelegramApiException("Parameter callback can not be null");
        }
        sendApiMethodAsync(method, callback);
    }

    public <T extends Serializable, Method extends BotApiMethod<T>> T execute(Method method) throws TelegramApiException {
        if (method == null) {
            throw new TelegramApiException("Parameter method can not be null");
        }
        return sendApiMethod(method);
    }

    public final User getMe() throws TelegramApiException {
        return sendApiMethod(new GetMe());
    }

    public final void getMeAsync(SentCallback<User> sentCallback) throws TelegramApiException {
        if (sentCallback == null) {
            throw new TelegramApiException("Parameter sentCallback can not be null");
        }
        sendApiMethodAsync(new GetMe(), sentCallback);
    }

    protected abstract <T extends Serializable, Method extends BotApiMethod<T>, Callback extends SentCallback<T>> void sendApiMethodAsync(Method method, Callback callback);

    protected abstract <T extends Serializable, Method extends BotApiMethod<T>> T sendApiMethod(Method method) throws TelegramApiException;

}
