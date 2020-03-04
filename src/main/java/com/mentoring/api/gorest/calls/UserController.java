package com.mentoring.api.gorest.calls;

import com.github.javafaker.Faker;
import com.mentoring.api.gorest.client.HttpClient;
import io.restassured.response.Response;

import static com.mentoring.api.gorest.endpoints.ApiEndpoints.*;


public class UserController {

    private static Faker faker = new Faker();

    public static Response getAllUsers() {
        return HttpClient.sender(GetAllUsers.getMethod(), GetAllUsers.getEndpoint(), null);
    }

    public static Response getUserById(int id) {
        return HttpClient.sender(GetUserById.getMethod(), GetUserById.getEndpoint(), null, id);
    }

    public static Response deleteUserById(int id) {
        return HttpClient.sender(DeleteUserById.getMethod(), DeleteUserById.getEndpoint(), null, id);
    }

    public static Response createUser() {

        return HttpClient.sender(CreateUser.getMethod(), CreateUser.getEndpoint(), generateUserResponseBody());
    }

    public static Response updateUserById(int id) {

        return HttpClient.sender(UpdateUserById.getMethod(), UpdateUserById.getEndpoint(), generateUserResponseBody(), id);
    }

    private static String generateUserResponseBody(){

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName + lastName + "@test.test";

        return  "{\n" +
                "\"first_name\":\"" + firstName + "\",\n" +
                "\"last_name\":\"" + lastName + "\",\n" +
                "\"gender\":\"male\",\n" +
                "\"email\":\"" + email + "\",\n" +
                "\"status\":\"active\"\n" +
                "}";
    }

    public static Response getAllPosts() {
        return HttpClient.sender(GetAllPosts.getMethod(), GetAllPosts.getEndpoint(), null);
    }

    public static Response getPostById(int id) {
        return HttpClient.sender(GetPostById.getMethod(), GetPostById.getEndpoint(), null, id);
    }

    public static Response deletePostById(int id) {
        return HttpClient.sender(DeletePostById.getMethod(), DeletePostById.getEndpoint(), null, id);
    }

    public static Response createPostByUserId(int userId) {

        String title = faker.howIMetYourMother().catchPhrase();
        String body = faker.howIMetYourMother().quote();
        String requestBody = "{\n" +
                "\"user_id\":\"" + userId + "\",\n" +
                "\"title\":\"" + title + "\",\n" +
                "\"body\":\"" + body + "\"\n" +
                "}";
        return HttpClient.sender(CreatePost.getMethod(), CreatePost.getEndpoint(), requestBody);
    }

    public static Response updatePostById(int postId) {

        String title = faker.howIMetYourMother().catchPhrase();
        String body = faker.howIMetYourMother().quote();
        String requestBody = "{\n" +
                "\"title\":\"" + title + "\",\n" +
                "\"body\":\"" + body + "\"\n" +
                "}";

        return HttpClient.sender(UpdatePostById.getMethod(), UpdatePostById.getEndpoint(), requestBody, postId);
    }

}
