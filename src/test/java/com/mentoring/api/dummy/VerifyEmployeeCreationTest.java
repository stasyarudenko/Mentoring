package com.mentoring.api.dummy;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;


public class VerifyEmployeeCreationTest extends BaseTest {

    @Test
    public void testStatusResponseForEmployeesList() {

        RestAssured.given()
//                .get("/employees")
                .get("https://dummy.restapiexample.com/api/v1/employees")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testEmployeeCreation() {

        Response response = RestAssured.with()
                .body("{\"name\":\"anrud.test\",\"salary\":\"300\",\"age\":\"23\"}")
                .request("POST", "https://dummy.restapiexample.com/api/v1/create");

        response.then().assertThat().statusCode(200);

        String createdEmployeeId = StringUtils.substringBetween(response.getBody().prettyPrint(), "\"id\": ", "\n");

        RestAssured.get(String.format("https://dummy.restapiexample.com/api/v1/employee/%s", createdEmployeeId))
                .then()
                .assertThat().body(containsString(createdEmployeeId));
    }
}
