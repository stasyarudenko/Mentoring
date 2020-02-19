package com.mentoring.api.gorest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VerifyUsersListTest extends BaseTest {

    private static final String PUBLIC_API_USERS = "/public-api/users";

    private static final String PUBLIC_API_USER_ID = "/public-api/users/%s";

    @Test
    public void testStatusResponseWithAuthentification() {

        httpAuthorizedClient()
                .get(PUBLIC_API_USERS)
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void testStatusResponseWithoutAuthentification() {

        String responseBodyText = RestAssured.get("/public-api/users").getBody().prettyPrint();

        RestAssured.when()
                .get(PUBLIC_API_USERS)
                .then()
                .assertThat()
                .body(containsString("\"code\":401"));
        assertTrue(responseBodyText.contains("\"message\": \"Authentication failed.\""), "'message' is not as expected");
    }

    @Test
    public void testValidationSchema() {

        httpAuthorizedClient()
                .get(PUBLIC_API_USERS)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("users_schema.json"));
    }

    @Test
    public void testVerifyUserCreationResponseSchema() {

        String requestBody = "{\n" +
                "\"first_name\":\"Anrud\",\n" +
                "\"last_name\":\"Test\",\n" +
                "\"gender\":\"male\",\n" +
                "\"email\":\"anrud02@roberts.com\",\n" +
                "\"status\":\"active\"\n" +
                "}";

        Response response = httpAuthorizedClient()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(PUBLIC_API_USERS);

        response.then()
                .assertThat()
                .body(containsString("\"code\":201"));

        String createdUserId = StringUtils.substringBetween(response.getBody().prettyPrint(), "\"id\": \"", "\",\n");

        try {
            httpAuthorizedClient()
                    .get(String.format(PUBLIC_API_USER_ID, createdUserId))
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("user_creation_response_schema.json"));
        } catch (AssertionError e) {
            throw (new AssertionError(e));
        } finally {
            deleteUserWithId(createdUserId);
            verifyUserWithIdIsDeleted(createdUserId);
        }
    }

    private void deleteUserWithId(String id) {

        httpAuthorizedClient()
                .delete(String.format(PUBLIC_API_USER_ID, id))
                .then()
                .assertThat()
                .statusCode(200);
    }

    private void verifyUserWithIdIsDeleted(String id) {

        httpAuthorizedClient()
                .get(String.format(PUBLIC_API_USER_ID, id))
                .then()
                .assertThat()
                .body(containsString("Object not found: " + id));
    }
}
