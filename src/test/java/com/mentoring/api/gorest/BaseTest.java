package com.mentoring.api.gorest;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;


import static com.mentoring.api.gorest.config.Configuration.BASE_URL;
import static com.mentoring.api.gorest.config.Configuration.PORT;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BaseTest {

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = BASE_URL;
        RestAssured.port = PORT;
//        RestAssured.port = DEFAULT_PORT;
    }

    public int getUserIdFromResponse(Response response) {

        int userId = Integer.parseInt(StringUtils.substringBetween(response.getBody().prettyPrint(), "\"id\": \"", "\",\n"));
        System.out.println("-------------\nUser ID: " + userId + "\n-------------");
        return userId;
    }

    public void verifyUserWithIdDoesNotExist(int id) {

        assertEquals(HttpCode.NotFound.getCode(), UserController.getUserById(id).getStatusCode());
    }

    public void verifyResponseSchema(Response response, String jsonSchemaPath) {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }
}
