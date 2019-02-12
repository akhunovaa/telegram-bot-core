package com.botmasterzzz.bot.logging;

import java.io.IOException;
import java.util.logging.FileHandler;

public class BotsFileHandler  extends FileHandler {

    private static final String filePattern = "./TelegramBots%g.%u.log";

    public BotsFileHandler() throws IOException, SecurityException {
        super(filePattern, 1024 * 1024 * 10, 50, true);
        setFormatter(new FileFormatter());
    }

    public BotsFileHandler(int limit, int count) throws IOException, SecurityException {
        super(filePattern, limit, count);
        setFormatter(new FileFormatter());
    }

    public BotsFileHandler(String pattern) throws IOException, SecurityException {
        super(pattern);
        setFormatter(new FileFormatter());
    }

    public BotsFileHandler(String pattern, boolean append) throws IOException, SecurityException {
        super(pattern, append);
        setFormatter(new FileFormatter());
    }

    public BotsFileHandler(String pattern, int limit, int count) throws IOException, SecurityException {
        super(pattern, limit, count);
        setFormatter(new FileFormatter());
    }

    public BotsFileHandler(String pattern, int limit, int count, boolean append) throws IOException, SecurityException {
        super(pattern, limit, count, append);
        setFormatter(new FileFormatter());
    }
}
