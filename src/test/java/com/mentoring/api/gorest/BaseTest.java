package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.DEFAULT_PORT;


public class BaseTest {

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.port = 443;
//        RestAssured.port = DEFAULT_PORT;
    }
}
