package com.mentoring.api.gorest.helper;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import io.restassured.response.Response;

import static com.mentoring.api.gorest.utils.UserUtils.getPostIdFromResponse;
import static com.mentoring.api.gorest.utils.UserUtils.getUserIdFromResponse;
import static org.junit.Assert.assertEquals;


public class Helper {

    public static int createUser() {

        Response createdUser = UserController.createUser();
        assertEquals(302, createdUser.getStatusCode());

        return getUserIdFromResponse(createdUser);
    }

    public static int createPostByUser(int userId) {

        Response createdPost = UserController.createPostByUserId(userId);
        return getPostIdFromResponse(createdPost);
    }
}
