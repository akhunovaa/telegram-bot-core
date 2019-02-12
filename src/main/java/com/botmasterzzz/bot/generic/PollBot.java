package com.botmasterzzz.bot.generic;

import com.botmasterzzz.bot.api.impl.objects.Update;

import java.util.List;

public interface PollBot {

    void onUpdateReceived(Update update);

    default void onUpdatesReceived(List<Update> updates) {
        updates.forEach(this::onUpdateReceived);
    }

    String getBotUsername();

    String getBotToken();

    BotOptions getOptions();

    default void onClosing() {
    }
}
