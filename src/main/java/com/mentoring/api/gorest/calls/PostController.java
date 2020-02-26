package com.mentoring.api.gorest.calls;

import com.mentoring.api.gorest.client.HttpClient;
import io.restassured.response.Response;

import static com.mentoring.api.gorest.ApiEndpoints.*;


public class PostController {

    public static Response getPostById(int id) {
        return HttpClient.sender(GetPostById.getMethod(), String.format(GetPostById.getEndpoint(), String.valueOf(id)));
    }

    public static Response deleteUserById(int id) {
        return HttpClient.sender(DeletePostById.getMethod(), String.format(DeletePostById.getEndpoint(), String.valueOf(id)));
    }

    public static Response createPost() {

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
}
