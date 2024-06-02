Feature: Post User API Tests

  Scenario: Create a new user with valid details
    Given I have user data
      | firstName | lastName | email                          |
      | John      | Doe      | john.doe1234@example.com       |
    When I send a POST request to create a user
    Then The response code is 200
    And The response should match JSONSchema "create-schema.json"

  Scenario: Create a new user with only firstName field
    Given I have user data
      | firstName |
      | John      |
    When I send a POST request to create a user
    Then The response code is 400
    And The response body content is "{\"error\":\"BODY_NOT_VALID\",\"data\":{\"lastName\":\"Path `lastName` is required.\",\"email\":\"Path `email` is required.\"}}"

Scenario: Create a new user with only lastName field
    Given I have user data
      | lastName |
      | Doe    |
    When I send a POST request to create a user
    Then The response code is 400
    And The response body content is "{\"error\":\"BODY_NOT_VALID\",\"data\":{\"firstName\":\"Path `firstName` is required.\",\"email\":\"Path `email` is required.\"}}"

  Scenario: Create a new user with only email field
      Given I have user data
        | email            |
        | John11@gmail.com   |
      When I send a POST request to create a user
      Then The response code is 400
      And The response body content is "{\"error\":\"BODY_NOT_VALID\",\"data\":{\"lastName\":\"Path `lastName` is required.\",\"firstName\":\"Path `firstName` is required.\"}}"

  Scenario: Create a new user with only firstName field
      Given I have user data
     | title | firstName | lastName | picture                                          | gender | email                            | dateOfBirth               | phone        | street          | city        | state    | country                  | timezone |
     | mrs   | ciro      | alves    | https://randomuser.me/api/portraits/women/60.jpg | female | john.doe1234@example.com         | 1975-06-04T08:26:49.610Z  | +91091212292 | S. Roberts Road | Palos Hills | Illinois | United States of America | 4        |
      When I send a POST request to create a user
      Then The response code is 400
      And The response body content is "{\"error\":\"BODY_NOT_VALID\",\"data\":{\"email\":\"Email already used\"}}"
