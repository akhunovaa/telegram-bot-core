package com.botmasterzzz.bot;

import com.botmasterzzz.bot.bot.DefaultBotOptions;
import com.botmasterzzz.bot.bot.DefaultSender;
import com.botmasterzzz.bot.generic.PollBot;

public abstract class TelegramLongPollingBot extends DefaultSender implements PollBot {

    public TelegramLongPollingBot(DefaultBotOptions options) {
        super(options);
    }
}
