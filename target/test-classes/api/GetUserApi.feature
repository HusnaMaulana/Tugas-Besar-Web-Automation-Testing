Feature: Get User API Test

  Scenario: Perform GET User data without authorization process
    Given App id for get request ""
    And User id for get request "60d0fe4f5311236168a109ca"
    When Sending a GET request
    Then The response status code for get request should be 403
    And The response body for get request should be "{\"error\":\"APP_ID_MISSING\"}"

  Scenario: Perform GET User by valid User ID 
    Given App id for get request "665b0de2c728e2049bf7490a"
    And User id for get request "60d0fe4f5311236168a10a01"
    When Sending a GET request
    Then The response status code for get request should be 200
    And The response body for get request should match JSONSchema "schema.json"

  Scenario: Perform GET User by incorrect User ID 
    Given App id for get request "665b0de2c728e2049bf7490a"
    And User id for get request "abc"
    When Sending a GET request
    Then The response status code for get request should be 400
    And The response body for get request should be "{\"error\":\"PARAMS_NOT_VALID\"}"

  Scenario: Perform GET User with User ID not found 
    Given App id for get request "665b0de2c728e2049bf7490a"
    And User id for get request "6636e15710f9d4ee0843783c"
    When Sending a GET request
    Then The response status code for get request should be 404
    And The response body for get request should be "{\"error\":\"RESOURCE_NOT_FOUND\"}"

  Scenario: Perform GET User data with invalid App id and User Id
    Given App id for get request "665b0de2c728e2049bf7490b"
    And User id for get request "60d0fe4f5311236168a10a01"
    When Sending a GET request
    Then The response status code for get request should be 403
    And The response body for get request should be "{\"error\":\"APP_ID_NOT_EXIST\"}"
