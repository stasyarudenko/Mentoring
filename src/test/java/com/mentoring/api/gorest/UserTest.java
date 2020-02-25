package com.mentoring.api.gorest;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest extends BaseTest{

    @Test
    public void testGetUser() {

        assertEquals(HttpCode.Created.getCode(), UserController.getUserById(1).statusCode());
    }

    @Test
    public void testNonExistingGetUser() {

        int randomId = new Random().nextInt();
        verifyUserWithIdDoesNotExist(randomId);

        assertEquals(HttpCode.NotFound.getCode(), UserController.getUserById(randomId).statusCode());
    }

    @Test
    public void testValidateCreateUserSchema() {

        Response createdUser = UserController.createUser();
        assertEquals(HttpCode.Created.getCode(), createdUser.statusCode());

        int userId = getUserIdFromResponse(createdUser);

        try {
            verifyResponseSchema(createdUser, "user_creation_response_schema.json");
        } catch (AssertionError e) {
            throw (new AssertionError(e));
        } finally {
            UserController.deleteUserById(userId);
            verifyUserWithIdDoesNotExist(userId);
        }
    }

    @Test
    public void testUpdateUser() {

        Response createdUser = UserController.createUser();
        assertEquals(HttpCode.Created.getCode(), createdUser.statusCode());

        int userId = getUserIdFromResponse(createdUser);
        Response updatedUser = UserController.updateUserById(userId);

        try {
            assertEquals(HttpCode.OK.getCode(), updatedUser.getStatusCode());
        } catch (AssertionError e) {
            throw (new AssertionError(e));
        } finally {
            UserController.deleteUserById(userId);
            verifyUserWithIdDoesNotExist(userId);
        }
    }

    @Test
    public void testUpdateNonExistingUser() {

        int randomId = new Random().nextInt();
        verifyUserWithIdDoesNotExist(randomId);

        try {
            assertEquals(HttpCode.NotFound.getCode(), UserController.updateUserById(randomId).getStatusCode());
        } catch (AssertionError e) {
            throw (new AssertionError(e));
        } finally {
            UserController.deleteUserById(randomId);
            verifyUserWithIdDoesNotExist(randomId);
        }
    }

    @Test
    public void testValidateUserUpdateSchema() {

        Response createdUser = UserController.createUser();
        assertEquals(HttpCode.Created.getCode(), createdUser.statusCode());

        int userId = getUserIdFromResponse(createdUser);
        Response updatedUser = UserController.updateUserById(userId);

        try {
            verifyResponseSchema(updatedUser, "user_creation_response_schema.json");
        } catch (AssertionError e) {
            throw (new AssertionError(e));
        } finally {
            UserController.deleteUserById(userId);
            verifyUserWithIdDoesNotExist(userId);
        }
    }
}
