package com.mentoring.api.gorest.utils;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;


public class UserUtils {

    public static int getUserIdFromResponse(Response response) {

        int userId = Integer.parseInt(StringUtils.substringBetween(response.getBody().prettyPrint(), "\"id\": \"", "\",\n"));
        System.out.println("-------------\nUser ID: " + userId + "\n-------------"); // Add logger (Log4J)
        return userId;
    }

    public static void verifyUserWithIdDoesNotExist(int id) {

        assertEquals(HttpCode.NotFound.getCode(), UserController.getUserById(id).getStatusCode());
    }

    public static void verifyResponseSchema(Response response, String jsonSchemaPath) {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }

    public static int getPostIdFromResponse(Response response) {

        int postId = Integer.parseInt(StringUtils.substringBetween(response.getBody().prettyPrint(), "\"id\": \"", "\",\n"));
        System.out.println("-------------\nPost ID: " + postId + "\n-------------"); // Add logger (Log4J)
        return postId;
    }
}
