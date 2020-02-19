package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import static com.mentoring.api.gorest.Configuration.TOKEN;
import static com.mentoring.api.gorest.SystemApi.PUBLIC_API_USERS;
import static com.mentoring.api.gorest.SystemApi.PUBLIC_API_USER_ID;
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

    public void deleteUserWithId(String id) {

        httpAuthorizedClient()
                .delete(String.format(PUBLIC_API_USER_ID, id))
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void verifyUserWithIdDoesNotExist(String id) {

        verifyResponseBodyCode(httpAuthorizedClient().get(String.format(PUBLIC_API_USER_ID, id)), "Object not found: " + id);
    }

    public void verifyUserWithIdDoesNotExist(int id) {

        verifyResponseBodyCode(httpAuthorizedClient().get(String.format(PUBLIC_API_USER_ID, id)), "Object not found: " + id);
    }
}
