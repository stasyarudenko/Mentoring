package com.mentoring.core;


import java.time.Duration;

public class Configuration {

    public static final String LOGIN = "anrud.user";
    public static final String PASSWORD = "anrud.user123";
    public static final String FIRST_NAME = "anrud";
    public static final String LAST_NAME = "user";

    public static Duration TIMEOUT = Duration.ofSeconds(4);
    public static Duration POLLING = Duration.ofSeconds(1);

    private static int counterForAlias = 17;

    public static String getEmailWithAlias() {

        counterForAlias++;
        return String.join("+", LOGIN, Integer.toString(counterForAlias) + "@gmail.com");
    }

    public static String getLoginWithAlias() {
        return String.join("+", LOGIN, Integer.toString(counterForAlias));
    }

}
