package com.mentoring.api.gorest;

import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
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

        String userId = StringUtils.substringBetween(createdUserResponse.getBody().prettyPrint(), "\"id\": \"", "\",\n");
        System.out.println("-------------\nUser ID: " + userId + "\n-------------");

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

        int randomUserID = new Random().nextInt();
        System.out.println("-------------\nUser ID: " + randomUserID + "\n-------------");
        verifyUserWithIdDoesNotExist(randomUserID);
    }

}