Feature: Get User API Test

  Scenario: Perform GET User data without authorization process
    Given App id for get request ""
    And User id for get request "60d0fe4f5311236168a109ca"
    When Sending a GET request
    Then The response status code for get request should be 403
    And The response body for get request should be "{\"error\":\"APP_ID_MISSING\"}"

  Scenario: Perform GET User data with invalid app-id
    Given App id for get request "665b0de2c728e2049bf7490b"
    And User id for get request "60d0fe4f5311236168a109fa"
    When Sending a GET request
    Then The response status code for get request should be 403
    And The response body for get request should be "{\"error\":\"APP_ID_NOT_EXIST\"}"

  Scenario: Perform GET User by valid User ID (ID exists in the system)
    Given App id for get request "665b0de2c728e2049bf7490a"
    And User id for get request "60d0fe4f5311236168a109fa"
    When Sending a GET request
    Then The response status code for get request should be 200
    And The response body for get request should match JSONSchema "schema.json"

  Scenario: Perform GET User by invalid User ID (ID never existed in the system and incorrect ID format)
    Given App id for get request "665b0de2c728e2049bf7490a"
    And User id for get request "abc"
    When Sending a GET request
    Then The response status code for get request should be 400
    And The response body for get request should be "{\"error\":\"PARAMS_NOT_VALID\"}"

  Scenario: Perform GET User by invalid User ID and APP ID(ID existed in the system but already deleted)
    Given App id for get request "665b0de2c728e2049bf7490a"
    And User id for get request "6636e15710f9d4ee0843783c"
    When Sending a GET request
    Then The response status code for get request should be 404
    And The response body for get request should be "{\"error\":\"RESOURCE_NOT_FOUND\"}"
