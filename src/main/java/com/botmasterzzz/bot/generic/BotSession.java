package com.botmasterzzz.bot.generic;

public interface BotSession {

    void setOptions(BotOptions options);
    void setToken(String token);
    void setCallback(PollBot callback);

    void start();


    void stop();
    boolean isRunning();
}
