package com.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class DeleteUserSteps {
    private Response response;
    private String appId;
    private String userId;

    @Given("App id delete request {string}")
    public void setAppId(String appId){
        this.appId = appId;
    }

    @Given("Id user delete request {string}")
    public void setIdUser(String userId) {
        this.userId = userId;
    }

    @When("Sending DELETE request")
    public void sendDeleteRequest() {
        response = RestAssured.given()
                .baseUri("https://dummyapi.io/data/v1/user")
                .header("Accept", "application/json")
                .header("app-id", appId)
                .delete("/" + userId);
    }

    @Then("Response status code of delete request should be {int}")
    public void matchStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println("Expected Status Code : " + expectedStatusCode);
        System.out.println("Actual Status Code : " + actualStatusCode);
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("Response body of delete request should be {string}")
    public void matchResponseBody(String expectedResponseBody) {
        String actualResponseBody = response.getBody().asString();
        System.out.println("Expected Response Body : " + expectedResponseBody);
        System.out.println("Actual Response Body : " + actualResponseBody);
        Assert.assertEquals(expectedResponseBody, actualResponseBody);
    }

    @Then("Response body of delete request should match JSONSchema {string}")
    public void matchJsonSchema(String schemaPath) {
        String responseBody = response.getBody().asString();
        System.out.println("Response Body : " + responseBody);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("JSONSchemaData/" + schemaPath));
    }
}
