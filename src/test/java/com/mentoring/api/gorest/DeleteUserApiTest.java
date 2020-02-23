package com.mentoring.api.gorest;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeleteUserApiTest extends BaseTest {

//    @Test
//    public void testDeleteStatusResponseWithoutAuthentication() {
//
//        verifyResponseBodyCode(
//                sender("delete", PUBLIC_API_USER_ID + "123"), CODE_401);
//    }

    @Test
    public void testDeleteStatusResponse() {

        Response createdUser = UserController.createUser();
        assertEquals(HttpCode.Created.getCode(), createdUser.getStatusCode());

        int userId = getUserIdFromResponse(createdUser);

        try {
            assertEquals(HttpCode.Deleted.getCode(), UserController.deleteUserById(userId).getStatusCode());
        } catch (AssertionError e) {
            throw new AssertionError(e);
        } finally {
            UserController.deleteUserById(userId);
            verifyUserWithIdDoesNotExist(userId);
        }
    }

    @Test
    public void testDeleteNonExistingUser() {

        int randomUserID = new Random().nextInt();
        System.out.println("-------------\nUser ID: " + randomUserID + "\n-------------");
        verifyUserWithIdDoesNotExist(randomUserID);

        assertEquals(HttpCode.NotFound.getCode(), UserController.deleteUserById(randomUserID).getStatusCode());
    }
}