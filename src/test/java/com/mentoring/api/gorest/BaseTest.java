package com.mentoring.api.gorest;

import com.mentoring.api.gorest.calls.UserController;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mentoring.api.gorest.config.Configuration.BASE_URL;
import static com.mentoring.api.gorest.config.Configuration.PORT;


public class BaseTest {

    public static List<Integer> createdUsers = new ArrayList<>();
    public static List<Integer> createdPosts = new ArrayList<>();

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = BASE_URL;
        RestAssured.port = PORT;
    }

    @AfterAll
    public static void tearDown() {

        createdUsers.forEach(UserController::deleteUserById);
        createdPosts.forEach(UserController::deletePostById);
    }

    public static int generateRandomId() {
        return new Random().nextInt();
    }
}
