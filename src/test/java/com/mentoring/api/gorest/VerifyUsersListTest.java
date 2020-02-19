package com.mentoring.api.gorest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.mentoring.api.gorest.SystemApi.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class VerifyUsersListTest extends BaseTest {

    @Test
    public void testStatusResponseWithoutAuthentication() {

        verifyResponseBodyCode(getRequestTo(PUBLIC_API_USERS), CODE_401);
    }

    @Test
    public void testStatusResponseWithAuthentication() {

        getRequestTo(PUBLIC_API_USERS, httpAuthorizedClient())
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void testValidationSchema() {

        getRequestTo(PUBLIC_API_USERS, httpAuthorizedClient())
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("users_schema.json"));
    }

    @Test
    public void testVerifyUserCreationResponseSchema() {

        Response createdUserResponse = createUser();
        verifyResponseBodyCode(createdUserResponse, CODE_201);

        String userId = getUserIdFromResponse(createdUserResponse);

        try {
            createdUserResponse
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("user_creation_response_schema.json"));
        } catch (AssertionError e) {
            throw (new AssertionError(e));
        } finally {
            deleteUserWithId(userId);
            verifyUserWithIdDoesNotExist(userId);
        }
    }
}
