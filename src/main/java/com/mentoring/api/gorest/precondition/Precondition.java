package com.mentoring.api.gorest.precondition;

import com.mentoring.api.gorest.calls.UserController;
import com.mentoring.api.gorest.client.HttpCode;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Random;

import static org.junit.Assert.assertEquals;


public class Precondition {

    private Response user;
    private int userID;
    private Response post;
    private int postID;

    private Precondition(Response user, int userID, Response post, int postID) {

        this.user = user;
        this.userID = userID;
        this.post = post;
        this.postID = postID;
    }

    public static PreconditionBuilder preconditionBuilder() {
        return new PreconditionBuilder();
    }

    public Response getUser() {
        return user;
    }

    public int getUserID() {
        return userID;
    }

    public Response getPost() {
        return post;
    }

    public int getPostID() {
        return postID;
    }

    public static class PreconditionBuilder {

        Response user;
        int userID;
        Response post;
        int postID;

        final static Logger logger = Logger.getLogger(PreconditionBuilder.class);

        public Precondition build() {
            return new Precondition(user, userID, post, postID);
        }

        public PreconditionBuilder createUser() {

            this.user = UserController.createUser();
            this.userID = getUserIdFromResponse(user);
            return this;
        }

        public PreconditionBuilder verifyUserCreated() {
            assertEquals(HttpCode.OK.getCode(), UserController.getUserById(userID).statusCode());
            return this;
        }

        public PreconditionBuilder createPost() {

            this.post = UserController.createPostByUserId(userID);
            this.postID = getPostIdFromResponse(post);
            return this;
        }

        public PreconditionBuilder createPostByNonExistingUser() {

            this.userID = new Random().nextInt();;
            this.post = UserController.createPostByUserId(userID);
            return this;
        }

        private int getUserIdFromResponse(Response response) {

            int userId = Integer.parseInt(StringUtils.substringBetween(response.getBody().prettyPrint(), "\"id\": \"", "\",\n"));
//            System.out.println("-------------\nUser ID: " + userId + "\n-------------"); // Add logger (Log4J)
            logger.info("\n-------------\nUser ID: " + userId + "\n-------------");
            return userId;
        }

        private int getPostIdFromResponse(Response response) {

            int postId = Integer.parseInt(StringUtils.substringBetween(response.getBody().prettyPrint(), "\"id\": \"", "\",\n"));
//            System.out.println("-------------\nPost ID: " + postId + "\n-------------"); //
            logger.info("\n-------------\nPost ID: " + postId + "\n-------------");
            return postId;
        }
    }
}
