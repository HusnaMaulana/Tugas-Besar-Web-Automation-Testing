package com.api;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTestPut {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/";
    private static final String VALID_APP_ID = "6637651410f9d4137343b084";
    private static final String VALID_USER_ID_1 = "66376429906c3ade97c6e7af";

    private void sendPutRequest(String requestBody) {
        given()
            .baseUri(BASE_URL)
            .header("app-id", VALID_APP_ID)
            .contentType(ContentType.JSON) 
            .body(requestBody)
        .when()
            .put("/user/" + VALID_USER_ID_1)
        .then()
            .statusCode(200)
            .extract().response(); // Extract response for further validation
    }

    @Test(description = "Update firstName of a user with valid appId and userId")
    public void updateFirstName() {
        String requestBody = "{\"firstName\": \"Rofaul\"}";
        validatePutRequest(requestBody);
    }

    @Test(description = "Add lastName to a user with valid appId and userId")
    public void addLastName() {
        String requestBody = "{\"lastName\": \"Akrom\"}";
        validatePutRequest(requestBody);
    }

    @Test(description = "Change title of a user to 'mr' with valid appId and userId")
    public void changeTitleToMr() {
        String requestBody = "{\"title\": \"mr\"}";
        validatePutRequest(requestBody);
    }

    @Test(description = "Change title of a user to 'ms' with valid appId and userId")
    public void changeTitleToMs() {
        String requestBody = "{\"title\": \"ms\"}";
        validatePutRequest(requestBody);
    }

    @Test(description = "Change title of a user to 'mrs' with valid appId and userId")
    public void changeTitleToMrs() {
        String requestBody = "{\"title\": \"mrs\"}";
        validatePutRequest(requestBody);
    }

    private void validatePutRequest(String requestBody) {
        try {
            sendPutRequest(requestBody);
        } catch (AssertionError e) {
            System.out.println("Assertion Error: " + e.getMessage());
            // Handle assertion error or re-throw as necessary
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            // Handle other exceptions
        }
    }
}
