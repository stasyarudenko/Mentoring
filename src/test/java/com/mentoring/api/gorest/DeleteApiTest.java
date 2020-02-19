package com.mentoring.api.gorest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.mentoring.api.gorest.SystemApi.*;


public class DeleteApiTest extends BaseTest {


    @Test
    public void testDeleteStatusResponseWithoutAuthentication() {

        verifyResponseBodyCode(sendRequestTo("DELETE",
                String.format(PUBLIC_API_USER_ID, 123)), CODE_401);
    }
    @Test
    public void testDeleteStatusResponseWithAuthentication() {

        Response createdUserResponse = createUser();
        verifyResponseBodyCode(createdUserResponse, CODE_201);

        String userId = getUserIdFromResponse(createdUserResponse);

        try {
            verifyResponseBodyCode(deleteRequestTo(String.format(PUBLIC_API_USER_ID, userId), httpAuthorizedClient()), CODE_204);
        } catch (AssertionError e) {
            throw new AssertionError(e);
        } finally {
            deleteUserWithId(userId);
            verifyUserWithIdDoesNotExist(userId);
        }
    }

    @Test
    public void testDeleteNonExistingUser() {

        String randomUserID = String.valueOf(new Random().nextInt());
        System.out.println("-------------\nUser ID: " + randomUserID + "\n-------------");
        verifyUserWithIdDoesNotExist(randomUserID);
        deleteRequestTo(String.format(PUBLIC_API_USER_ID, randomUserID), httpAuthorizedClient()).then().assertThat().statusCode(404);
    }

}