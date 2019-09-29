package com.mentoring.core;


import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Configuration {

    public static final String LOGIN = "anrud.user";
    public static final String PASSWORD = "anrud.user123";
//    public static long TIMEOUT = 100;
    public static Duration TIMEOUT = Duration.ofSeconds(4);
    public static Duration POLLING = Duration.ofMillis(100);
}
