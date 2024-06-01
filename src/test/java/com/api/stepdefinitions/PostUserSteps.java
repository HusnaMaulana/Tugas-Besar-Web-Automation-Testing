package com.api.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostUserSteps {
    private Response response;
    private Map<String, String> userData;

    @Given("I have user data")
    public void createUser(DataTable dataTable) {
        userData = new HashMap<>();
        userData.putAll(dataTable.asMaps().get(0));
    }

    @When("I send a POST request to create a user")
    public void sendPostRequest() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("app-id", "665b0de2c728e2049bf7490a");
        response = request.body(userData).post("/user/create");
    }

    @Then("The response code is {int}")
    public void matchStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println("Status Code : " + actualStatusCode);
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("The response should match JSONSchema {string}")
    public void matchJsonSchema(String schemaPath) {
        String responseBody = response.getBody().asString();
        System.out.println("Response Body : " + responseBody);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("JSONSchemaData/" + schemaPath));
    }

    @Then("The response body content is {string}")
    public void matchResponseBody(String expectedResponseBody) {
        String actualResponseBody = response.getBody().asString();
        System.out.println("Expected Response Body : " + expectedResponseBody);
        System.out.println("Actual Response Body : " + actualResponseBody);
        Assert.assertEquals(expectedResponseBody, actualResponseBody);
    }
    
    @Then("The response code is {int} and the error message is {string}")
    public void verifyErrorCodeAndMessage(int expectedStatusCode, String expectedErrorMessage) {
        int actualStatusCode = response.getStatusCode();
        String actualErrorMessage = response.jsonPath().getString("error");
        System.out.println("Status Code : " + actualStatusCode);
        System.out.println("Error Message : " + actualErrorMessage);
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
