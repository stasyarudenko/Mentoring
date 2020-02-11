package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static com.mentoring.api.Configuration.TOKEN;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VerifyUsersListTest extends BaseTest {

    @Test
    public void testStatusResponseWithAuthentification() {

        RestAssured.given()
                .auth().oauth2(TOKEN)
                .get("/public-api/users")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void testStatusResponseWithoutAuthentification() {

        String responseBodyText = RestAssured.get("/public-api/users").getBody().prettyPrint();

        RestAssured.when()
                .get("/public-api/users")
                .then()
                .assertThat()
                .body(containsString("\"code\":401"));
        assertTrue(responseBodyText.contains("\"message\": \"Authentication failed.\""), "'message' is not as expected");
    }

    @Test
    public void testValidationSchema() {

        RestAssured.given()
                .auth().oauth2(TOKEN)
                .get("/public-api/users")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("users_schema.json"));
    }
}
