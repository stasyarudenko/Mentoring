package com.mentoring.api.gorest.calls;

import com.github.javafaker.Faker;
import com.mentoring.api.gorest.client.HttpClient;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import static com.mentoring.api.gorest.endpoints.ApiEndpoints.*;


public class UserController {

    private static Faker faker = new Faker();

    private static final Logger logger = Logger.getLogger(UserController.class);

    public static Response getAllUsers() {

        logger.info("Getting all users");
        return HttpClient.sender(GetAllUsers.getMethod(), GetAllUsers.getEndpoint(), null);
    }

    public static Response getUserById(int id) {

        logger.info("Getting user by id: " + id);
        return HttpClient.sender(GetUserById.getMethod(), GetUserById.getEndpoint(), null, id);
    }

    public static Response deleteUserById(int id) {

        logger.info("Deleting user by id: " + id);
        return HttpClient.sender(DeleteUserById.getMethod(), DeleteUserById.getEndpoint(), null, id);
    }

    public static Response createUser() {

        logger.info("Creating user...");
        return HttpClient.sender(CreateUser.getMethod(), CreateUser.getEndpoint(), generateUserRequestBody());
    }

    public static Response updateUserById(int id) {

        logger.info("Updating user by id: " + id);
        return HttpClient.sender(UpdateUserById.getMethod(), UpdateUserById.getEndpoint(), generateUserRequestBody(), id);
    }

    private static String generateUserRequestBody(){

        logger.info("Generating user request body...");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName + lastName + "@test.test";
        String requestBody = "{\n" +
                "\"first_name\":\"" + firstName + "\",\n" +
                "\"last_name\":\"" + lastName + "\",\n" +
                "\"gender\":\"male\",\n" +
                "\"email\":\"" + email + "\",\n" +
                "\"status\":\"active\"\n" +
                "}";
        logger.info("Generated request body:\n" + requestBody);

        return requestBody;
    }

    public static Response getAllPosts() {

        logger.info("Getting all posts...");
        return HttpClient.sender(GetAllPosts.getMethod(), GetAllPosts.getEndpoint(), null);
    }

    public static Response getPostById(int id) {

        logger.info("Getting post by id: " + id);
        return HttpClient.sender(GetPostById.getMethod(), GetPostById.getEndpoint(), null, id);
    }

    public static Response deletePostById(int id) {

        logger.info("Deleting post by id: " + id);
        return HttpClient.sender(DeletePostById.getMethod(), DeletePostById.getEndpoint(), null, id);
    }

    public static Response createPostByUserId(int userId) {

        logger.info("Creating post by user with id: " + userId);

        String title = faker.howIMetYourMother().catchPhrase();
        String body = faker.howIMetYourMother().quote();
        String requestBody = "{\n" +
                "\"user_id\":\"" + userId + "\",\n" +
                "\"title\":\"" + title + "\",\n" +
                "\"body\":\"" + body + "\"\n" +
                "}";
        logger.info("Generated post body:\n" + requestBody);

        return HttpClient.sender(CreatePost.getMethod(), CreatePost.getEndpoint(), requestBody);
    }

    public static Response updatePostById(int postId) {

        logger.info("Updating post by id: " + postId);

        String title = faker.howIMetYourMother().catchPhrase();
        String body = faker.howIMetYourMother().quote();
        String requestBody = "{\n" +
                "\"title\":\"" + title + "\",\n" +
                "\"body\":\"" + body + "\"\n" +
                "}";
        logger.info("Generated post body:\n" + requestBody);

        return HttpClient.sender(UpdatePostById.getMethod(), UpdatePostById.getEndpoint(), requestBody, postId);
    }

}
