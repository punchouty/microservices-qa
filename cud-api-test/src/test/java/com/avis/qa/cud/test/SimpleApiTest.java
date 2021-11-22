package com.avis.qa.cud.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleApiTest {

    @Test
    public void testGetSuccess() {
        RestAssured.baseURI = "http://localhost:9100";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/");
        String formattedString = response.getBody().prettyPrint();
        System.out.println(formattedString);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
