package com.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PutUserSteps {
    private Response response;
    private String appId;
    private String userId;
    private String updatedUserData;

    @Given("App id for update request is {string}")
    public void setAppId(String appId){
        this.appId = appId;
    }

    @Given("User id for update request is {string}")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Given("Updated user data is {string}")
    public void setUpdatedUserData(String updatedUserData) {
        this.updatedUserData = updatedUserData;
    }

    @When("Sending a PUT request")
    public void sendPutRequest() {
        try {
            response = RestAssured.given()
                    .baseUri("https://dummyapi.io/data/v1/user")
                    .header("Content-Type", "application/json")
                    .header("app-id", appId)
                    .body(updatedUserData)
                    .put("/" + userId);
        } catch (Exception e) {
            System.out.println("Error occurred while sending PUT request: " + e.getMessage());
        }
    }

    @Then("The response status code for update request should be {int}")
    public void matchStatusCode(int expectedStatusCode) {
        try {
            int actualStatusCode = response.getStatusCode();
            System.out.println("Expected Status Code : " + expectedStatusCode);
            System.out.println("Actual Status Code : " + actualStatusCode);
            Assert.assertEquals(expectedStatusCode, actualStatusCode);
        } catch (Exception e) {
            System.out.println("Error occurred while validating status code: " + e.getMessage());
        }
    }

    @Then("The response body for update request should be {string}")
    public void matchResponseBody(String expectedResponseBody) {
        try {
            String actualResponseBody = response.getBody().asString();
            System.out.println("Expected Response Body : " + expectedResponseBody);
            System.out.println("Actual Response Body : " + actualResponseBody);
            Assert.assertEquals(expectedResponseBody, actualResponseBody);
        } catch (Exception e) {
            System.out.println("Error occurred while validating response body: " + e.getMessage());
        }
    }

    @Then("The response body for update request should match JSONSchema {string}")
    public void matchJsonSchema(String schemaPath) {
        try {
            String responseBody = response.getBody().asString();
            System.out.println("Response Body : " + responseBody);
            response.then().assertThat().body(matchesJsonSchemaInClasspath("JSONSchemaData/" + schemaPath));
        } catch (Exception e) {
            System.out.println("Error occurred while validating JSON schema: " + e.getMessage());
        }
    }
}
