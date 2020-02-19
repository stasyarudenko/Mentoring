package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import static com.mentoring.api.gorest.Configuration.TOKEN;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

    public void verifyResponseBodyMessage(Response response, String message) {

        response.then()
                .assertThat()
                .body(containsString(message));
//        assertTrue(response.getBody().prettyPrint().contains(message), "'message' is not as expected");
    }
}
