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
        try {
            RestAssured.baseURI = "https://dummyapi.io/data/v1";
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.header("app-id", "665b0de2c728e2049bf7490a");
            response = request.body(userData).post("/user/create");
        } catch (Exception e) {
            System.out.println("Exception occurred during POST request: " + e.getMessage());
            response = null;
        }
    }

    @Then("The response code is {int}")
    public void matchStatusCode(int expectedStatusCode) {
        try {
            int actualStatusCode = response.getStatusCode();
            System.out.println("Status Code : " + actualStatusCode);
            Assert.assertEquals(expectedStatusCode, actualStatusCode);
        } catch (Exception e) {
            System.out.println("Exception occurred while matching status code: " + e.getMessage());
            Assert.fail("Failed to match status code");
        }
    }

    @Then("The response should match JSONSchema {string}")
    public void matchJsonSchema(String schemaPath) {
        try {
            String responseBody = response.getBody().asString();
            System.out.println("Response Body : " + responseBody);
            response.then().assertThat().body(matchesJsonSchemaInClasspath("JSONSchemaData/" + schemaPath));
        } catch (Exception e) {
            System.out.println("Exception occurred while matching JSON schema: " + e.getMessage());
            Assert.fail("Failed to match JSON schema");
        }
    }

    @Then("The response body content is {string}")
    public void matchResponseBody(String expectedResponseBody) {
        try {
            String actualResponseBody = response.getBody().asString();
            System.out.println("Expected Response Body : " + expectedResponseBody);
            System.out.println("Actual Response Body : " + actualResponseBody);
            Assert.assertEquals(expectedResponseBody, actualResponseBody);
        } catch (Exception e) {
            System.out.println("Exception occurred while matching response body: " + e.getMessage());
            Assert.fail("Failed to match response body");
        }
    }
    
    @Then("The response code is {int} and the error message is {string}")
    public void verifyErrorCodeAndMessage(int expectedStatusCode, String expectedErrorMessage) {
        try {
            int actualStatusCode = response.getStatusCode();
            String actualErrorMessage = response.jsonPath().getString("error");
            System.out.println("Status Code : " + actualStatusCode);
            System.out.println("Error Message : " + actualErrorMessage);
            Assert.assertEquals(expectedStatusCode, actualStatusCode);
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        } catch (Exception e) {
            System.out.println("Exception occurred while verifying error code and message: " + e.getMessage());
            Assert.fail("Failed to verify error code and message");
        }
    }
}
