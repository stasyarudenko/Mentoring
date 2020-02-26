package com.mentoring.api.gorest.calls;

import com.mentoring.api.gorest.client.HttpClient;
import io.restassured.response.Response;

import static com.mentoring.api.gorest.endpoints.ApiEndpoints.*;


public class UserController {

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

        String requestBody = "{\n" +
                "\"first_name\":\"Anrud\",\n" +
                "\"last_name\":\"Test\",\n" +
                "\"gender\":\"male\",\n" +
                "\"email\":\"anrud02@roberts.com\",\n" +
                "\"status\":\"active\"\n" +
                "}";

        return HttpClient.sender(CreateUser.getMethod(), CreateUser.getEndpoint(), requestBody);
    }

    public static Response updateUserById(int id) {

        String requestBody = "{\n" +
                "\"first_name\":\"Anrud\",\n" +
                "\"last_name\":\"Test\",\n" +
                "\"gender\":\"female\",\n" +
                "\"email\":\"anrud@roberts.com\",\n" +
                "\"status\":\"active\"\n" +
                "}";
        return HttpClient.sender(UpdateUserById.getMethod(), UpdateUserById.getEndpoint(), requestBody);
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

        String title = "some test title";
        String body = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. " +
                "Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. " +
                "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. " +
                "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, " +
                "imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. " +
                "Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.";
        String requestBody = "{\n" +
                "\"user_id\":\"" + userId + "\",\n" +
                "\"title\":\"" + title + "\",\n" +
                "\"body\":\"" + body + "\",\n" +
                "}";

        return HttpClient.sender(CreatePost.getMethod(), CreatePost.getEndpoint(), requestBody);
    }

    public static Response updatePostById(int id) {

        String requestBody = "{\n" +
                "\"first_name\":\"Anrud\",\n" +
                "\"last_name\":\"Test\",\n" +
                "\"gender\":\"female\",\n" +
                "\"email\":\"anrud@roberts.com\",\n" +
                "\"status\":\"active\"\n" +
                "}";
        return HttpClient.sender(UpdateUserById.getMethod(), UpdateUserById.getEndpoint(), requestBody);
    }
}
