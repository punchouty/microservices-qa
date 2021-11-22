package com.avis.qa.cud.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleApiTest {

    @Test
    @Ignore
    public void testGetSuccess() {
        RestAssured.baseURI = "http://localhost:9100";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/");
        String formattedString = response.getBody().prettyPrint();
        System.out.println(formattedString);
        Assertions.assertEquals(response.getStatusCode(), 200);
    }
}
