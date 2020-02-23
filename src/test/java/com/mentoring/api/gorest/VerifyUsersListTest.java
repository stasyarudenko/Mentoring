package com.mentoring.api.gorest;

import com.mentoring.api.gorest.client.HttpClient;
import com.mentoring.api.gorest.client.HttpCode;
import org.junit.jupiter.api.Test;

import static com.mentoring.api.gorest.ApiEndpoints.GetAllUsers;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class VerifyUsersListTest extends BaseTest {

//    @Test
//    public void testStatusResponseWithoutAuthentication() {
//
//        verifyResponseBodyCode(sender("get", PUBLIC_API_USERS), CODE_401);
//    }

    @Test
    public void testStatusResponseWithAuthentication() {

        assertEquals(HttpCode.OK.getCode(), HttpClient.sender(GetAllUsers.getMethod(), GetAllUsers.getEndpoint()).getStatusCode());
    }

    @Test
    public void testValidationSchema() {

        verifyResponseSchema(HttpClient.sender(GetAllUsers.getMethod(), GetAllUsers.getEndpoint()), "users_schema.json");
    }
}
