package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;


import static com.mentoring.api.gorest.Configuration.TOKEN;
import static com.mentoring.api.gorest.SystemApi.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;


public class BaseTest {

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.port = 443;
//        RestAssured.port = DEFAULT_PORT;
    }

    public RequestSpecification httpAuthorizedClient() {
        return RestAssured.given().auth().oauth2(TOKEN);
    }

    public void verifyResponseBodyCode(Response response, String code) {

        response.then()
                .assertThat()
                .body(containsString(code));
    }

    public Response createUser() {

        String requestBody = "{\n" +
                "\"first_name\":\"Anrud\",\n" +
                "\"last_name\":\"Test\",\n" +
                "\"gender\":\"male\",\n" +
                "\"email\":\"anrud02@roberts.com\",\n" +
                "\"status\":\"active\"\n" +
                "}";

        return httpAuthorizedClient()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(PUBLIC_API_USERS);
    }

    public String getUserIdFromResponse(Response response) {

        String userId = StringUtils.substringBetween(response.getBody().prettyPrint(), "\"id\": \"", "\",\n");
        System.out.println("-------------\nUser ID: " + userId + "\n-------------");
        return userId;
    }

    public void deleteUserWithId(String id) {

        sendAuthorizedRequestTo("delete", httpAuthorizedClient(), PUBLIC_API_USER_ID + id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void verifyUserWithIdDoesNotExist(String id) {

        verifyResponseBodyCode(
                sendAuthorizedRequestTo("get", httpAuthorizedClient(), PUBLIC_API_USER_ID + id), "Object not found: " + id);
    }

    public void verifyResponseSchema(Response response, String jsonSchemaPath) {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }
}
