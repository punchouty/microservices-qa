package com.avis.qa.cud.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

@Testcontainers
public class IntegrationTest {

    @Container
    private final DockerComposeContainer<?> composeContainer =
            new DockerComposeContainer(
                    new File("src/test/resources/docker-compose.yaml"))
                    .withExposedService("cud-api_1", 9100);
    private String host;
    private int port;

    @BeforeEach
    public void setUp() {
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

    }

//    @Test
//    public void testGetBrandsSuccess() {
//        RestAssured.baseURI = "http://" + host + ":" + port;
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.request(Method.GET, "/brands");
//        String formattedString = response.getBody().prettyPrint();
//        System.out.println(formattedString);
//
//    }
//
//    @Test
//    public void testGetLocationsSuccess() {
//        RestAssured.baseURI = "http://" + host + ":" + port;
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.request(Method.GET, "/locations");
//        String formattedString = response.getBody().prettyPrint();
//        System.out.println(formattedString);
//
//    }
}
