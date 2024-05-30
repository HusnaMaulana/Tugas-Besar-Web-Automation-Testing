package com.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTestPost {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/user/create";
        RestAssured.basePath = "";
        RestAssured.requestSpecification = given()
                .header("app-id", "662701ba776fafe3d71e1751")
                .contentType(ContentType.JSON);
    }

    @Test
    public void testCase1_02() {
        given()
            .body("{\n" +
                    "  \"title\": \"mr\",\n" +
                    "  \"firstName\": \"Husna\",\n" +
                    "  \"lastName\": \"Maulana\",\n" +
                    "  \"gender\": \"male\",\n" +
                    "  \"email\": \"tejapakualam1@gmail.com\",\n" +
                    "  \"dateOfBirth\": \"1990-08-15\", \n" +
                    "  \"registerDate\": \"2024-04-30T12:00:00Z\", \n" +
                    "  \"phone\": \"+621234567890\", \n" +
                    "  \"picture\": \"https://example.com/profile-picture.jpg\",\n" +
                    "  \"location\": {\n" +
                    "    \"latitude\": 37.7749,\n" +
                    "    \"longitude\": -122.4194,\n" +
                    "    \"city\": \"San Francisco\",\n" +
                    "    \"country\": \"United States\"\n" +
                    "  }\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(200)
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Husna"))
            .body("lastName", equalTo("Maulana"))
            .body("gender", equalTo("male"))
            .body("email", equalTo("tejapakualam1@gmail.com"));
    }

    @Test
    public void testCase1_03() {
        given()
            .body("{\n" +
                    "  \"title\": \"mr\",\n" +
                    "  \"firstName\": \"Husna\",\n" +
                    "  \"lastName\": \"Maulana\",\n" +
                    "  \"gender\": \"male\",\n" +
                    "  \"email\": \"tejapakualam2@gmail.com\",\n" +
                    "  \"dateOfBirth\": \"1990-08-15\", \n" +
                    "  \"registerDate\": \"2024-04-30T12:00:00Z\", \n" +
                    "  \"phone\": \"+621234567890\", \n" +
                    "  \"picture\": \"https://example.com/profile-picture.jpg\",\n" +
                    "  \"location\": {\n" +
                    "    \"latitude\": 37.7749,\n" +
                    "    \"longitude\": -122.4194,\n" +
                    "    \"city\": \"San Francisco\",\n" +
                    "    \"country\": \"United States\"\n" +
                    "  }\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(200)
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Husna"))
            .body("lastName", equalTo("Maulana"))
            .body("gender", equalTo("male"))
            .body("email", equalTo("tejapakualam2@gmail.com"));
    }

    @Test
    public void testCase1_04() {
        given()
            .body("{\n" +
                    "  \"title\": \"mr\",\n" +
                    "  \"firstName\": \"Husna\",\n" +
                    "  \"lastName\": \"Maulana\",\n" +
                    "  \"gender\": \"male\",\n" +
                    "  \"email\": \"tejapakualam3@gmail.com\",\n" +
                    "  \"dateOfBirth\": \"1990-08-15\", \n" +
                    "  \"registerDate\": \"2024-04-30T12:00:00Z\", \n" +
                    "  \"phone\": \"+621234567890\", \n" +
                    "  \"picture\": \"https://example.com/profile-picture.jpg\",\n" +
                    "  \"location\": {\n" +
                    "    \"latitude\": 37.7749,\n" +
                    "    \"longitude\": -122.4194,\n" +
                    "    \"city\": \"San Francisco\",\n" +
                    "    \"country\": \"United States\"\n" +
                    "  }\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(200)
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Husna"))
            .body("lastName", equalTo("Maulana"))
            .body("gender", equalTo("male"))
            .body("email", equalTo("tejapakualam3@gmail.com"));
    }

    @Test
    public void testCase1_05() {
        given()
            .body("{\n" +
                    "  \"title\": \"mr\",\n" +
                    "  \"firstName\": \"Husna\",\n" +
                    "  \"lastName\": \"Maulana\",\n" +
                    "  \"gender\": \"male\",\n" +
                    "  \"email\": \"tejapakualam4@gmail.com\",\n" +
                    "  \"dateOfBirth\": \"1990-08-15\", \n" +
                    "  \"registerDate\": \"2024-04-30T12:00:00Z\", \n" +
                    "  \"phone\": \"+621234567890\", \n" +
                    "  \"picture\": \"https://example.com/profile-picture.jpg\",\n" +
                    "  \"location\": {\n" +
                    "    \"latitude\": 37.7749,\n" +
                    "    \"longitude\": -122.4194,\n" +
                    "    \"city\": \"San Francisco\",\n" +
                    "    \"country\": \"United States\"\n" +
                    "  }\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(200)
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Husna"))
            .body("lastName", equalTo("Maulana"))
            .body("gender", equalTo("male"))
            .body("email", equalTo("tejapakualam4@gmail.com"));
    }

    @Test
    public void testCase1_06() {
        given()
            .body("{\n" +
                    "  \"title\": \"mr\",\n" +
                    "  \"firstName\": \"Husna\",\n" +
                    "  \"lastName\": \"Maulana\",\n" +
                    "  \"gender\": \"male\",\n" +
                    "  \"email\": \"tejapakualam5@gmail.com\",\n" +
                    "  \"dateOfBirth\": \"1990-08-15\", \n" +
                    "  \"registerDate\": \"2024-04-30T12:00:00Z\", \n" +
                    "  \"phone\": \"+621234567890\", \n" +
                    "  \"picture\": \"https://example.com/profile-picture.jpg\",\n" +
                    "  \"location\": {\n" +
                    "    \"latitude\": 37.7749,\n" +
                    "    \"longitude\": -122.4194,\n" +
                    "    \"city\": \"San Francisco\",\n" +
                    "    \"country\": \"United States\"\n" +
                    "  }\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(200)
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Husna"))
            .body("lastName", equalTo("Maulana"))
            .body("gender", equalTo("male"))
            .body("email", equalTo("tejapakualam5@gmail.com"));
    }
}