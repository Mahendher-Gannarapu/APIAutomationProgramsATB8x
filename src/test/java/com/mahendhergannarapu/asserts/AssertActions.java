package com.mahendhergannarapu.asserts;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

//Adding Assertions
public class AssertActions {

    //Common Assertions which can be reused

    public void verifyResponseBody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyStatusCode(Response response, Integer expected)
    {
        assertEquals(response.getStatusCode(), expected);
    }

}