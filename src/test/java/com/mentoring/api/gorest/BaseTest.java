package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import static com.mentoring.api.gorest.Configuration.TOKEN;


public class BaseTest {

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.port = 443;
//        RestAssured.port = DEFAULT_PORT;
    }

    public RequestSpecification httpAuthorizedClient() {
        return RestAssured.given().auth().oauth2(TOKEN);
    }
}
