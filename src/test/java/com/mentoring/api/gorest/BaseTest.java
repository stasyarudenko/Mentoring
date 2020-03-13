package com.mentoring.api.gorest;

import com.mentoring.api.gorest.calls.UserController;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

import static com.mentoring.api.gorest.config.Configuration.BASE_URL;
import static com.mentoring.api.gorest.config.Configuration.PORT;


public class BaseTest {

    public static List<Integer> createdUsers = new ArrayList<>();

    public static List<Integer> createdPosts = new ArrayList<>();

    private static final Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeAll
    public static void setUp() {

        logger.debug("Starting set up...");
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = PORT;
    }

    @AfterAll
    public static void tearDown() {

        logger.info("Deleting posts with id: " + createdPosts.toString());
        createdPosts.forEach(UserController::deletePostById);

        logger.info("Deleting users with id: " + createdUsers.toString());
        createdUsers.forEach(UserController::deleteUserById);

    }
}
