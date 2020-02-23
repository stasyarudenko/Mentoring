package com.mentoring.api.gorest.calls;

import com.mentoring.api.gorest.client.HttpClient;
import io.restassured.response.Response;

import static com.mentoring.api.gorest.ApiEndpoints.CreateUser;
import static com.mentoring.api.gorest.ApiEndpoints.DeleteUserById;
import static com.mentoring.api.gorest.ApiEndpoints.GetUserById;


public class UserController {

    public static Response getUserById(int id) {
        return HttpClient.sender(GetUserById.getMethod(), String.format(GetUserById.getEndpoint(), String.valueOf(id)));
    }

    public static Response deleteUserById(int id) {
        return HttpClient.sender(DeleteUserById.getMethod(), String.format(DeleteUserById.getEndpoint(), String.valueOf(id)));
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
}
