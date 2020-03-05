package com.mentoring.api.gorest.utils;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;


public class UserUtils {

    public static void verifyUserWithIdDoesNotExist(int id) {

        assertEquals(HttpCode.NotFound.getCode(), UserController.getUserById(id).getStatusCode());
    }

    public static void verifyResponseSchema(Response response, String jsonSchemaPath) {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }

}
