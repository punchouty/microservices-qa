package com.avis.qa.cud.steps;

import com.avis.qa.cud.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class BrandStepDefinition {

    private static RequestSpecification httpRequest;
    private static Response httpResponse;

    @Given("User has url and id to get one brand")
    public void userHasUrlAndIdToGetOneBrand() {
        RestAssured.baseURI = "http://localhost:9100";
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
    }

    @When("User send get request with id {int}")
    public void userSendGetRequestWithId(int id) {
        httpResponse = httpRequest.get("/brands/" + id);
    }

    @Then("server return facebook brand")
    public void serverReturnFacebookBrand() {
        String jsonString = httpResponse.asString();
        System.out.println(jsonString);
        String name = JsonPath.from(jsonString).get("name");
        Assertions.assertEquals("Facebook", name);
    }

    @Given("User has url and id of brand that does not exist in database")
    public void userHasUrlAndIdOfBrandThatDoesNotExistInDatabase() {
        RestAssured.baseURI = "http://localhost:9100";
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
    }

    @Then("server return {int} status")
    public void serverReturnStatus(int statusCode) {
        Assertions.assertEquals(statusCode, httpResponse.getStatusCode());
    }
}
