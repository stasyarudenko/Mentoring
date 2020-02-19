package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SystemApi {

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

    private static Response getRequestTo(String url) {
        return RestAssured.get(url);
    }

    private static Response deleteRequestTo(String url) {
        return RestAssured.delete(url);
    }
}
