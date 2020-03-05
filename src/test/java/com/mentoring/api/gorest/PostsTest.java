package com.mentoring.api.gorest;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import com.mentoring.api.gorest.precondition.Precondition;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static com.mentoring.api.gorest.calls.UserController.getAllPosts;
import static com.mentoring.api.gorest.calls.UserController.getPostById;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostsTest extends BaseTest{

    @Test
    public void testGetAllPosts() {
        assertEquals(HttpCode.OK.getCode(), getAllPosts().getStatusCode());
    }

    @Test
    public void testVerifyCreatedPostStatusCode() {

        Precondition precondition = Precondition.preconditionBuilder().createUser().verifyUserCreated().createPost().perform();
        createdUsers.add(precondition.getUserID());
        createdPosts.add(precondition.getPostID());

        assertEquals(302, precondition.getPost().getStatusCode());
    }

    @Test
    public void testGetNonExistingPostById() {

        int id = new Random().nextInt();
        assertEquals(HttpCode.NotFound.getCode(), getPostById(id).getStatusCode());
    }

    @Test
    public void testGetPost() {

        Precondition precondition = Precondition.preconditionBuilder().createUser().verifyUserCreated().createPost().perform();
        createdUsers.add(precondition.getUserID());
        createdPosts.add(precondition.getPostID());

        assertEquals(HttpCode.OK.getCode(), UserController.getPostById(precondition.getPostID()).getStatusCode());
    }

    @Test
    public void testUpdatePost() {

        Precondition precondition = Precondition.preconditionBuilder().createUser().verifyUserCreated().createPost().perform();
        createdUsers.add(precondition.getUserID());
        createdPosts.add(precondition.getPostID());

        assertEquals(HttpCode.OK.getCode(), UserController.updatePostById(precondition.getPostID()).getStatusCode());
    }

    @Test
    public void testVerifyPostDeleteStatusCode() {

        Precondition precondition = Precondition.preconditionBuilder().createUser().verifyUserCreated().createPost().perform();
        createdUsers.add(precondition.getUserID());
        createdPosts.add(precondition.getPostID());

        assertEquals(HttpCode.OK.getCode(), UserController.deletePostById(precondition.getPostID()).getStatusCode());
    }
}
