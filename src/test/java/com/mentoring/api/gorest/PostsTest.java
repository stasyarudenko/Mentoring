package com.mentoring.api.gorest;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static com.mentoring.api.gorest.calls.UserController.getAllPosts;
import static com.mentoring.api.gorest.calls.UserController.getPostById;
import static com.mentoring.api.gorest.utils.UserUtils.getPostIdFromResponse;
import static com.mentoring.api.gorest.utils.UserUtils.getUserIdFromResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostsTest extends BaseTest{

    @Test
    public void testGetAllPosts() {
        assertEquals(HttpCode.OK.getCode(), getAllPosts().getStatusCode());
    }

    @Test
    public void testCreatePost() {

        Response createdUser = UserController.createUser();
        assertEquals(HttpCode.Created.getCode(), createdUser.getStatusCode());

        int userId = getUserIdFromResponse(createdUser);
        createdUsers.add(userId);

        Response createdPost = UserController.createPostByUserId(userId);
        int postId = getPostIdFromResponse(createdPost);
        createdPosts.add(postId);

        assertEquals(HttpCode.Created.getCode(), createdPost.getStatusCode());
    }

    @Test
    public void testGetNonExistingPostById() {

        int id = new Random().nextInt();
        assertEquals(HttpCode.NotFound.getCode(), getPostById(id).getStatusCode());
    }

    @Test
    public void testGetPostById() {

        Response createdUser = UserController.createUser();
        assertEquals(HttpCode.Created.getCode(), createdUser.getStatusCode());

        int userId = getUserIdFromResponse(createdUser);
        createdUsers.add(userId);

        Response createdPost = UserController.createPostByUserId(userId);
        int postId = getPostIdFromResponse(createdPost);
        createdPosts.add(postId);

        assertEquals(HttpCode.OK.getCode(), UserController.getPostById(postId).getStatusCode());
    }

}
