package com.mentoring.api.gorest.endpoints;

import com.mentoring.api.gorest.client.HttpMethod;

import static com.mentoring.api.gorest.client.HttpMethod.*;


public enum ApiEndpoints {

    GetAllUsers(GET, "/public-api/users"),
    GetUserById(GET, "/public-api/users/%s"),
    DeleteUserById(DELETE, "/public-api/users/%s"),
    CreateUser(POST, "/public-api/users"),
    UpdateUserById(PUT, "/public-api/users/%s"),
    GetAllPosts(GET, "/public-api/posts"),
    GetPostById(GET, "/public-api/posts/%s"),
    DeletePostById(DELETE, "/public-api/posts/%s"),
    CreatePost(POST, "/public-api/posts/%s");

    private HttpMethod method;
    private String endpoint;

    ApiEndpoints(HttpMethod get, String s) {
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getEndpoint() {
        return endpoint;
    }

    }
