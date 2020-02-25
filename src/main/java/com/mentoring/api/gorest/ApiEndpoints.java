package com.mentoring.api.gorest;

import com.mentoring.api.gorest.client.HttpMethod;

import static com.mentoring.api.gorest.client.HttpMethod.*;


public enum ApiEndpoints {

    GetAllUsers(GET, "/public-api/users"),
    GetUserById(GET, "/public-api/users/%s"),
    DeleteUserById(DELETE, "/public-api/users/%s"),
    CreateUser(POST, "/public-api/users"),
    UpdateUserById(PUT, "/public-api/users/%s");

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

    //    public static final String PUBLIC_API_USERS = "/public-api/users";
//
//    public static final String PUBLIC_API_USER_ID = ;
//
//    public static final String CODE_204 = "\"code\":204";
//
//    public static final String CODE_201 = "\"code\":201";
//
//    public static final String CODE_401 = "\"code\":401";

    }
