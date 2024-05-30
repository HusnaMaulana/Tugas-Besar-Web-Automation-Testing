package com.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTestGet {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/";
    
    private static final String VALID_APP_ID = "662701ba776fafe3d71e1751";
    
    private static final String VALID_USER_ID = "6636e15710f9d4ee0843783b";
    
    private static final String INVALID_USER_ID = "6636e15710f9d4ee0843783c";
    
    private static final String INVALID_FORMAT_USER_ID = "APAJAWE1";
    
    private static final String INVALID_APP_ID = "invalid_app_id";

    @Test(description = "Operasi tidak punya authorization")
    public void testCase1_UnauthorizedOperation() {
        given()
            .baseUri(BASE_URL)
            .header("app-id", INVALID_APP_ID)
            .when()
            .get("/user/" + VALID_USER_ID)
            .then()
            .statusCode(403); 
    }

    @Test(description = "app-id valid, dan user id ada pada sistem")
    public void testCase2_ValidAppIdValidUserId() {
        given()
            .baseUri(BASE_URL)
            .header("app-id", VALID_APP_ID)
            .when()
            .get("/user/" + VALID_USER_ID)
            .then()
            .statusCode(200) // Expecting OK status code
            .body("id", equalTo(VALID_USER_ID)); // Expecting user id to match
    }

    @Test(description = "app-id valid, dan user id tidak ada pada sistem")
    public void testCase3_ValidAppIdInvalidUserId() {
        given()
            .baseUri(BASE_URL)
            .header("app-id", VALID_APP_ID)
            .when()
            .get("/user/" + INVALID_USER_ID)
            .then()
            .statusCode(404); 
    }

    @Test(description = "app-id valid, dan user id tidak sesuai format")
    public void testCase4_ValidAppIdInvalidFormatUserId() {
        given()
            .baseUri(BASE_URL)
            .header("app-id", VALID_APP_ID)
            .when()
            .get("/user/" + INVALID_FORMAT_USER_ID)
            .then()
            .statusCode(400); // Expecting Bad Request status code
    }

    @Test(description = "api-id tidak valid, dan user id ada pada sistem")
    public void testCase5_InvalidAppIdValidUserId() {
        given()
            .baseUri(BASE_URL)
            .header("app-id", INVALID_APP_ID)
            .when()
            .get("/user/" + VALID_USER_ID)
            .then()
            .statusCode(403); // Expecting Unauthorized status code
    }
}
