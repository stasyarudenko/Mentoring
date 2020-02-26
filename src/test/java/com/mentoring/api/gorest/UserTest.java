package com.mentoring.api.gorest;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.mentoring.api.gorest.calls.UserController.getAllUsers;
import static com.mentoring.api.gorest.utils.UserUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest extends BaseTest{

    @Test
    public void testAllUsersStatusResponse() {
        assertEquals(HttpCode.OK.getCode(), getAllUsers().getStatusCode());
    }

    @Test
    public void testValidateGetAllUsersSchema() {
        verifyResponseSchema(getAllUsers(), "users_schema.json");
    }

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
        createdUsers.add(getUserIdFromResponse(createdUser));

        verifyResponseSchema(createdUser, "user_creation_response_schema.json");
    }

    @Test
    public void testUpdateUser() {

        Response createdUser = UserController.createUser();
        assertEquals(HttpCode.Created.getCode(), createdUser.statusCode());

        int userId = getUserIdFromResponse(createdUser);
        createdUsers.add(userId);

        Response updatedUser = UserController.updateUserById(userId);

        assertEquals(HttpCode.OK.getCode(), updatedUser.getStatusCode());
    }

    @Test
    public void testUpdateNonExistingUser() {

        int randomId = new Random().nextInt();
        verifyUserWithIdDoesNotExist(randomId);

        assertEquals(HttpCode.NotFound.getCode(), UserController.updateUserById(randomId).getStatusCode());
    }

    @Test
    public void testValidateUserUpdateSchema() {

        Response createdUser = UserController.createUser();
        assertEquals(HttpCode.Created.getCode(), createdUser.statusCode());

        int userId = getUserIdFromResponse(createdUser);
        createdUsers.add(userId);

        Response updatedUser = UserController.updateUserById(userId);

        verifyResponseSchema(updatedUser, "user_creation_response_schema.json");
    }

    @Test
    public void testDeleteStatusResponse() {

        Response createdUser = UserController.createUser();
        assertEquals(HttpCode.Created.getCode(), createdUser.getStatusCode());

        int userId = getUserIdFromResponse(createdUser);
        createdUsers.add(userId);

        assertEquals(HttpCode.Deleted.getCode(), UserController.deleteUserById(userId).getStatusCode());
    }

    @Test
    public void testDeleteNonExistingUser() {

        int randomUserID = new Random().nextInt();
        verifyUserWithIdDoesNotExist(randomUserID);

        assertEquals(HttpCode.NotFound.getCode(), UserController.deleteUserById(randomUserID).getStatusCode());
    }
}
