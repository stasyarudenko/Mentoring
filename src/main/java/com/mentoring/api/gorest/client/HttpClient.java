package com.mentoring.api.gorest.client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static com.mentoring.api.gorest.config.Configuration.TOKEN;


public class HttpClient {

    public static Response sender(HttpMethod method, String endpoint, String ... body) {

        switch (method) {

            case GET: {
                return get(endpoint);
            }

            case DELETE: {
                return delete(endpoint);
            }

            case POST: {
                return post(endpoint, body);
            }

            case PUT: {
                return put(endpoint, body);
            }

            default: {
                throw new IllegalArgumentException("Only GET, DELETE allowed");
            }
        }
    }

    private static Response get(String url) {
        return authorizedClient().get(url);
    }

    private static Response delete(String url) {
        return authorizedClient().delete(url);
    }

    private static Response post(String url, String ... body) {
        return authorizedClient()
                .contentType(ContentType.JSON)
                .body(body)
                .post(url);
    }

    private static Response put(String url, String ... body) {
        return authorizedClient()
                .contentType(ContentType.JSON)
                .body(body)
                .put(url);
    }

    public static RequestSpecification authorizedClient() {
        return RestAssured.given().auth().oauth2(TOKEN);
    }
}
