package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import static com.mentoring.api.Configuration.TOKEN;
import static io.restassured.RestAssured.DEFAULT_PORT;


public class BaseTest {

    public static final RequestSpecification AUTHORIZED_REQUEST_SCECIFICATION = RestAssured.given().auth().oauth2(TOKEN);

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.port = 443;
//        RestAssured.port = DEFAULT_PORT;
    }
}
