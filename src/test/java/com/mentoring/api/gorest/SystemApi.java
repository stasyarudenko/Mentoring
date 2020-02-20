package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class SystemApi {

    public static final String PUBLIC_API_USERS = "/public-api/users";

    public static final String PUBLIC_API_USER_ID = "/public-api/users/";

    public static final String CODE_204 = "\"code\":204";

    public static final String CODE_201 = "\"code\":201";

    public static final String CODE_401 = "\"code\":401";

    public static Response sendRequestTo(String requestType, String url) {

        switch (requestType.toUpperCase()) {
            case "GET": {
                return getRequestTo(url);
            }
            case "DELETE": {
                return deleteRequestTo(url);
            }
            default: {
                throw new IllegalArgumentException("Unsupported request type: " + requestType);
            }
        }
    }

    public static Response sendAuthorizedRequestTo(String requestType, RequestSpecification client, String url) {

        switch (requestType.toUpperCase()) {
            case "GET": {
                return getRequestTo(url, client);
            }
            case "DELETE": {
                return deleteRequestTo(url, client);
            }
            default: {
                throw new IllegalArgumentException("Unsupported request type: " + requestType);
            }
        }
    }

    private static Response getRequestTo(String url) {
        return RestAssured.get(url);
    }

    private static Response getRequestTo(String url, RequestSpecification client) {
        return client.get(url);
    }

    private static Response deleteRequestTo(String url) {
        return RestAssured.delete(url);
    }

    private static Response deleteRequestTo(String url, RequestSpecification client) {
        return client.delete(url);
    }
}
