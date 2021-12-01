package com.avis.qa.cud.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class LocationStepDefinition {

    private static final String BASE_URL = "http://localhost:9100"; // Get it from environment
    private static RequestSpecification httpRequest;
    private static Response httpResponse;

    @Given("User has url and id to get one valid location")
    public void userHasUrlAndIdToGetOneValidLocation() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
    }

    @When("User send get request for location with id {int}")
    public void userSendGetRequestForLocationWithId(int id) {
        httpResponse = httpRequest.get("/locations/" + id);
    }

    @Then("server return {string} city")
    public void serverReturnCity(String cityName) {
        String jsonString = httpResponse.asString();
        System.out.println(jsonString);
        String city = JsonPath.from(jsonString).get("city");
        Assertions.assertEquals(cityName, city);
    }

    @And("server return {string} company code")
    public void serverReturnCompanyCode(String companyCode) {
        String jsonString = httpResponse.asString();
        System.out.println(jsonString);
        String companyCodeReturned = JsonPath.from(jsonString).get("companyCode");
        Assertions.assertEquals(companyCode, companyCodeReturned);
    }

    @Given("User has url and id of location that does not exist in database")
    public void userHasUrlAndIdOfLocationThatDoesNotExistInDatabase() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
    }

    @Then("server return {int} status")
    public void serverReturnStatus(int statusCode) {
        Assertions.assertEquals(statusCode, httpResponse.getStatusCode());
    }

    @Given("User has url to get all locations")
    public void userHasUrlToGetAllLocations() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
    }

    @When("User send get request")
    public void userSendGetRequest() {
        httpResponse = httpRequest.get("/locations");
    }

    @Then("server return {int} locations")
    public void serverReturnLocations(int locationCount) {
        String jsonString = httpResponse.asString();
        System.out.println(jsonString);
        int count = JsonPath.from(jsonString).get("page.totalElements");
        Assertions.assertEquals(locationCount, count);
    }
}
