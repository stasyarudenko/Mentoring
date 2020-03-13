package com.mentoring.api.gorest;

import org.apache.log4j.Logger;

import java.util.Random;

public class Utils {

    private static final Logger logger = Logger.getLogger(Utils.class);

    public static int generateRandomId() {

        int id = new Random().nextInt();
        logger.info("Generated id: " + id);

        return id;
    }
}
