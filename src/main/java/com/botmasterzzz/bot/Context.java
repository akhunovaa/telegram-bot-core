package com.botmasterzzz.bot;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private static final Object lock = new Object();
    private static Injector INJECTOR;
    private static final Map<Class, Class> bindings = new HashMap<>();
    private static final Map<Class, Class> singletonBindings = new HashMap<>();

    public static <T> T getInstance(Class<T> type) {
        return getInjector().getInstance(type);
    }

    private static Injector getInjector() {
        if (INJECTOR == null) {
            synchronized (lock) {
                if (INJECTOR == null) {
                    INJECTOR = Guice.createInjector(new ApiModule());
                }
            }
        }
        return INJECTOR;
    }

    @SuppressWarnings("unchecked")
    private static class ApiModule extends AbstractModule {
        @Override
        protected void configure() {
            for (Map.Entry<Class, Class> binding : bindings.entrySet()) {
                bind(binding.getKey()).to(binding.getValue());
            }
            for (Map.Entry<Class, Class> binding : singletonBindings.entrySet()) {
                bind(binding.getKey()).to(binding.getValue()).in(Singleton.class);
            }
        }
    }

}

