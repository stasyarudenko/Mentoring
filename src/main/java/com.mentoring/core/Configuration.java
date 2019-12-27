package com.mentoring.core;


import java.time.Duration;
import java.util.Random;

public class Configuration {

    public static final String LOGIN = "anrud.user";
    public static final String EMAIL = "anrud.user@gmail.com";
    public static final String PASSWORD = "anrud.user123";
    public static final String FIRST_NAME = "anrud";
    public static final String LAST_NAME = "user";

    public static Duration TIMEOUT = Duration.ofSeconds(5);
    public static Duration POLLING = Duration.ofSeconds(1);

    private static int counterForAlias = new Random().nextInt();

    public static String getEmailWithAlias() {

        return String.format("anrud.user+%s@gmail.com", counterForAlias);
    }

    public static String getLoginWithAlias() {
        return String.format("anrud.user+%s", counterForAlias);
    }

}
