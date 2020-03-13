package com.mentoring.api.gorest.client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import static com.mentoring.api.gorest.config.Configuration.TOKEN;


public class HttpClient {

    private static final Logger logger = Logger.getLogger(HttpClient.class);

    public static Response sender(HttpMethod method, String endpoint, String body, Object... parameter) {

        endpoint = parameter.length > 0 ? String.format(endpoint, parameter) : endpoint;

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
                throw new IllegalArgumentException("Only GET, DELETE, POST, PUT allowed");
            }
        }
    }

    private static Response get(String url) {

        logger.debug("Sending GET request to " + url);
        return authorizedClient().get(url);
    }

    private static Response delete(String url) {

        logger.debug("Sending DELETE request to " + url);
        return authorizedClient().delete(url);
    }

    private static Response post(String url, String body) {

        logger.debug("Sending POST request to " + url + " with body:\n" + body);
        return authorizedClient()
                .contentType(ContentType.JSON)
                .body(body)
                .post(url);
    }

    private static Response put(String url, String body) {

        logger.debug("Sending PUT request to " + url + " with body:\n" + body);
        return authorizedClient()
                .contentType(ContentType.JSON)
                .body(body)
                .put(url);
    }

    private static RequestSpecification authorizedClient() {

        logger.debug("Authorizing client...");
        return RestAssured.given().auth().oauth2(TOKEN);
    }
}
