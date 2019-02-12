package com.botmasterzzz.bot.api.impl.methods;

import com.botmasterzzz.bot.api.impl.objects.User;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

public class GetMe  extends BotApiMethod<User> {
    public static final String PATH = "getme";

    public GetMe() {
        super();
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public User deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<User> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<User>>() {
                    });
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error getting me", result);
            }
        } catch (IOException e2) {
            throw new TelegramApiRequestException("Unable to deserialize response", e2);
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
    }
}
