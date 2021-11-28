package com.avis.qa.graphql.test;

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
import java.util.Map;

public class BrandStepDefinition {

    private static RequestSpecification httpRequest;
    private static Response httpResponse;

    @Given("Prepare url to get all brands")
    public void userHasUrlToGetAllBrands() {
        RestAssured.baseURI = "http://localhost:8080";
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
    }

    @When("Send graphql request")
    public void userSendGraphQlRequest() {
        String payload = "{\"query\":\"\\nquery {\\n      brand {\\n        name\\n        code\\n      }\\n    }\\n\",\"variables\":null}";
        httpResponse = httpRequest.body(payload).post("/graphql");
    }

    @Then("Number of brands returned is {int}")
    public void numberOfBrandsReturned(int count) {
        String jsonString = httpResponse.asString();
        List<Map<String, String>> brands = JsonPath.from(jsonString).get("data.brand");
        Assertions.assertEquals(count, brands.size());
    }

    @And("Status code is {int}")
    public void statusCodeIs(int statusCode) {
        Assertions.assertEquals(statusCode, httpResponse.getStatusCode());
    }
}
