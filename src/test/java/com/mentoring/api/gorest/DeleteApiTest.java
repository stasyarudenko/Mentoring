package com.mentoring.api.gorest;

import org.junit.jupiter.api.Test;

import static com.mentoring.api.gorest.SystemApi.sendRequestTo;


public class DeleteApiTest extends BaseTest {

    private static final String PUBLIC_API_USERS = "/public-api/users";

    private static final String PUBLIC_API_USER_ID = "/public-api/users/%s";

    @Test
    public void testStatusResponseWithoutAuthentication() {

        verifyResponseBodyMessage(sendRequestTo("DELETE", String.format(PUBLIC_API_USER_ID, 123)), "\"code\":401");
        verifyResponseBodyMessage(sendRequestTo("DELETE", String.format(PUBLIC_API_USER_ID, 123)), "\"message\":\"Authentication failed.\"");
    }
}