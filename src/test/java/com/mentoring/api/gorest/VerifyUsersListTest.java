package com.mentoring.api.gorest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.mentoring.api.gorest.SystemApi.*;


public class VerifyUsersListTest extends BaseTest {

    @Test
    public void testStatusResponseWithoutAuthentication() {

        verifyResponseBodyCode(sendRequestTo("get", PUBLIC_API_USERS), CODE_401);
    }

    @Test
    public void testStatusResponseWithAuthentication() {

        sendAuthorizedRequestTo("get", httpAuthorizedClient(), PUBLIC_API_USERS)
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void testValidationSchema() {

        verifyResponseSchema(
                sendAuthorizedRequestTo("get", httpAuthorizedClient(), PUBLIC_API_USERS), "users_schema.json");
    }

    @Test
    public void testVerifyUserCreationResponseSchema() {

        Response createdUserResponse = createUser();
        verifyResponseBodyCode(createdUserResponse, CODE_201);

        String userId = getUserIdFromResponse(createdUserResponse);

        try {
            verifyResponseSchema(createdUserResponse, "user_creation_response_schema.json");
        } catch (AssertionError e) {
            throw (new AssertionError(e));
        } finally {
            deleteUserWithId(userId);
            verifyUserWithIdDoesNotExist(userId);
        }
    }
}
