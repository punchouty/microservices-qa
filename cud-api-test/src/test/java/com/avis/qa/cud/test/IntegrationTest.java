package com.avis.qa.cud.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

@Testcontainers
public class IntegrationTest {

    @Container
    private static final DockerComposeContainer<?> composeContainer =
            new DockerComposeContainer(
                    new File("src/test/resources/docker-compose.yaml"))
                    .withExposedService("cud-api_1", 9100);
    private static String host;
    private static int port;

    @BeforeAll
    public static void setUp() {
        host = composeContainer.getServiceHost("cud-api_1", 9100);
        port = composeContainer.getServicePort("cud-api_1", 9100);
    }

    @Test
    public void testGetSuccess() {
        RestAssured.baseURI = "http://" + host + ":" + port;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/");
        String formattedString = response.getBody().prettyPrint();
        System.out.println(formattedString);
        Assertions.assertEquals(200, response.statusCode());

    }

    @Test
    public void testGetBrandsSuccess() {
        RestAssured.baseURI = "http://" + host + ":" + port;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/brands");
        String formattedString = response.getBody().prettyPrint();
        System.out.println(formattedString);
        Assertions.assertEquals(200, response.statusCode());

    }

    @Test
    public void testCreateBrandsSuccess() {
        RestAssured.baseURI = "http://" + host + ":" + port;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Apple");

        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST, "/brands");

        String formattedString = response.getBody().prettyPrint();
        System.out.println(formattedString);
        System.out.println("status code : " + response.statusCode());
        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("Apple", response.jsonPath().get("name"));
    }

    @Test
    public void testCreateBrandsFailure() {
        RestAssured.baseURI = "http://" + host + ":" + port;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "");

        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST, "/brands");

        String formattedString = response.getBody().prettyPrint();
        System.out.println(formattedString);
        System.out.println("status code : " + response.statusCode());
        Assertions.assertEquals(500, response.statusCode());
    }



    @Test
    public void testGetBrandByIdFailure() {
        RestAssured.baseURI = "http://" + host + ":" + port;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/brands/1011010");
        System.out.println("status code : " + response.statusCode());
        String formattedString = response.getBody().prettyPrint();
        System.out.println(formattedString);
        Assertions.assertEquals(404, response.statusCode());
    }
}
