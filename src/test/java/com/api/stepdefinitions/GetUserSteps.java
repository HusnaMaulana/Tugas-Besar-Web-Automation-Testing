package com.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUserSteps {
    private Response response;
    private String appId;
    private String userId;

    @Given("App id for get request {string}")
    public void setAppId(String appId){
        this.appId = appId;
    }

    @Given("User id for get request {string}")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @When("Sending a GET request")
    public void sendGetRequest() {
        response = RestAssured.given()
                .baseUri("https://dummyapi.io/data/v1/user")
                .header("Accept", "application/json")
                .header("app-id", appId)
                .get("/" + userId);
    }

    @Then("The response status code for get request should be {int}")
    public void matchStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println("Expected Status Code : " + expectedStatusCode);
        System.out.println("Actual Status Code : " + actualStatusCode);
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("The response body for get request should be {string}")
    public void matchResponseBody(String expectedResponseBody) {
        String actualResponseBody = response.getBody().asString();
        System.out.println("Expected Response Body : " + expectedResponseBody);
        System.out.println("Actual Response Body : " + actualResponseBody);
        Assert.assertEquals(expectedResponseBody, actualResponseBody);
    }

    @Then("The response body for get request should match JSONSchema {string}")
    public void matchJsonSchema(String schemaPath) {
        String responseBody = response.getBody().asString();
        System.out.println("Response Body : " + responseBody);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("JSONSchemaData/" + schemaPath));
    }
}
