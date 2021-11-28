package com.avis.qa.graphql.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrandStepDefinition {

    @Given("User has url to search id")
    public void userHasUrlToSearchId() {
        System.out.println("userHasUrlToSearchId");
    }

    @When("User send post request with id as parameter")
    public void userSendPostRequestWithIdAsParameter() {
        System.out.println("userSendPostRequestWithIdAsParameter");
    }

    @Then("single branad is returned")
    public void singleBranadIsReturned() {
        System.out.println("singleBranadIsReturned");
    }

    @Given("User has url to get all brands")
    public void userHasUrlToGetAllBrands() {
        System.out.println("userHasUrlToGetAllBrands");
    }

    @When("User send post request")
    public void userSendPostRequest() {
        System.out.println("userSendPostRequest");
    }

    @Then("List of brands is returned")
    public void listOfBrandsIsReturned() {
        System.out.println("listOfBrandsIsReturned");
    }
}
