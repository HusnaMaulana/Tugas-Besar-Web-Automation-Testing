Feature: Update User API Test

  Scenario: Update User with Valid Data
    Given App id for update request is "665b0de2c728e2049bf7490a"
    And User id for update request is "60d0fe4f5311236168a109fa"
    And Updated user data is "{\"firstName\": \"Rofaul\"}"
    When Sending a PUT request
    Then The response status code for update request should be 200
    And The response body for update request should match JSONSchema "schema.json"

  Scenario: Add Last Name to User
    Given App id for update request is "665b0de2c728e2049bf7490a"
    And User id for update request is "60d0fe4f5311236168a109fa"
    And Updated user data is "{\"lastName\": \"Akrom\"}"
    When Sending a PUT request
    Then The response status code for update request should be 200
    And The response body for update request should match JSONSchema "schema.json"

  Scenario: Change Title to 'mr' for User
    Given App id for update request is "665b0de2c728e2049bf7490a"
    And User id for update request is "60d0fe4f5311236168a109fa"
    And Updated user data is "{\"title\": \"mr\"}"
    When Sending a PUT request
    Then The response status code for update request should be 200
    And The response body for update request should match JSONSchema "schema.json"

  Scenario: Change Title to 'ms' for User
    Given App id for update request is "665b0de2c728e2049bf7490a"
    And User id for update request is "60d0fe4f5311236168a109fa"
    And Updated user data is "{\"title\": \"ms\"}"
    When Sending a PUT request
    Then The response status code for update request should be 200
    And The response body for update request should match JSONSchema "schema.json"

  Scenario: Change Title to 'mrs' for User
    Given App id for update request is "665b0de2c728e2049bf7490a"
    And User id for update request is "60d0fe4f5311236168a109fa"
    And Updated user data is "{\"title\": \"mrs\"}"
    When Sending a PUT request
    Then The response status code for update request should be 200
    And The response body for update request should match JSONSchema "schema.json"
