package com.mentoring.api.gorest;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import com.mentoring.api.gorest.precondition.Precondition;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.mentoring.api.gorest.calls.UserController.getAllUsers;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest extends BaseTest{

    @Test
    public void testGetAllUsersStatusResponse() {
        assertEquals(HttpCode.OK.getCode(), getAllUsers().getStatusCode());
    }

    @Test
    public void testValidateGetAllUsersResponseSchema() {
        verifyResponseSchema(getAllUsers(), "users_schema.json");
    }

    @Test
    public void testGetUser() {
        assertEquals(HttpCode.OK.getCode(), UserController.getUserById(1).statusCode());
    }

    @Test
    public void testGetNonExistingUser() {

        int userId = generateRandomId();
        verifyUserWithIdDoesNotExist(userId);

        assertEquals(HttpCode.NotFound.getCode(), UserController.getUserById(userId).statusCode());
    }

    @Test
    public void testCreateUser() {

        Precondition precondition = Precondition.preconditionBuilder().createUser().perform();
        createdUsers.add(precondition.getUserID());
        assertEquals(HttpCode.OK.getCode(), UserController.getUserById(precondition.getUserID()).statusCode());
    }

    @Test
    public void testValidateCreateUserResponseSchema() {

        Precondition precondition = Precondition.preconditionBuilder().createUser().verifyUserCreated().perform();
        createdUsers.add(precondition.getUserID());

        verifyResponseSchema(precondition.getUser(), "user_creation_response_schema.json");
    }

    @Test
    public void testUpdateUser() {

        Precondition precondition = Precondition.preconditionBuilder().createUser().verifyUserCreated().perform();
        createdUsers.add(precondition.getUserID());

        Response updatedUser = UserController.updateUserById(precondition.getUserID());

        assertEquals(HttpCode.OK.getCode(), updatedUser.getStatusCode());
    }

    @Test
    public void testUpdateNonExistingUser() {

        int userId = generateRandomId();
        verifyUserWithIdDoesNotExist(userId);

        assertEquals(HttpCode.NotFound.getCode(), UserController.updateUserById(userId).getStatusCode());
    }

    @Test
    public void testValidateUpdateUserResponseSchema() {

        Precondition precondition = Precondition.preconditionBuilder().createUser().verifyUserCreated().perform();
        createdUsers.add(precondition.getUserID());

        Response updatedUser = UserController.updateUserById(precondition.getUserID());

        verifyResponseSchema(updatedUser, "user_creation_response_schema.json");
    }

    @Test
    public void testDeleteUserStatusResponse() {

        Precondition precondition = Precondition.preconditionBuilder().createUser().verifyUserCreated().perform();
        createdUsers.add(precondition.getUserID());

        assertEquals(HttpCode.OK.getCode(), UserController.deleteUserById(precondition.getUserID()).getStatusCode());
    }

    @Test
    public void testDeleteNonExistingUser() {

        int userId = generateRandomId();
        verifyUserWithIdDoesNotExist(userId);

        assertEquals(HttpCode.NotFound.getCode(), UserController.deleteUserById(userId).getStatusCode());
    }


    private void verifyResponseSchema(Response response, String jsonSchemaPath) {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }

    private void verifyUserWithIdDoesNotExist(int id) {
        Assert.assertEquals(HttpCode.NotFound.getCode(), UserController.getUserById(id).getStatusCode());
    }
}
