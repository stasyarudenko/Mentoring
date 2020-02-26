package com.mentoring.api.gorest;

import com.mentoring.api.gorest.client.HttpClient;
import com.mentoring.api.gorest.client.HttpCode;
import org.junit.jupiter.api.Test;


import static com.mentoring.api.gorest.ApiEndpoints.GetAllPosts;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostsTest extends BaseTest{

    @Test
    public void testGetAllPosts() {

        assertEquals(HttpCode.OK.getCode(), HttpClient.sender(GetAllPosts.getMethod(), GetAllPosts.getEndpoint()).getStatusCode());
    }

}
