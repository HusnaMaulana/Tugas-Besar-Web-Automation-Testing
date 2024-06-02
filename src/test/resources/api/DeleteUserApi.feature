Feature: Delete User API Test

  Scenario: Deleting User Data without Authorization
    Given App id delete request ""
    And Id user delete request "60d0fe4f5311236168a10a01"
    When Sending DELETE request
    Then Response status code of delete request should be 403
    And Response body of delete request should be "{\"error\":\"APP_ID_MISSING\"}"

  Scenario: Deleting User by Valid User ID
    Given App id delete request "665b0de2c728e2049bf7490a"
    And Id user delete request "665bf6554fd1793de6762a01"
    When Sending DELETE request
    Then Response status code of delete request should be 200
    And Response body of delete request should match JSONSchema "schema_id_only.json"

  Scenario: Deleting User by Incorrect User ID 
    Given App id delete request "665b0de2c728e2049bf7490a"
    And Id user delete request "abc"
    When Sending DELETE request
    Then Response status code of delete request should be 400
    And Response body of delete request should be "{\"error\":\"PARAMS_NOT_VALID\"}"

  Scenario: Deleting User by User ID not found 
    Given App id delete request "665b0de2c728e2049bf7490a"
    And Id user delete request "60d0fe4f5311236168a109fa"
    When Sending DELETE request
    Then Response status code of delete request should be 404
    And Response body of delete request should be "{\"error\":\"RESOURCE_NOT_FOUND\"}"

  Scenario: Deleting User with invalid User ID and APP ID
    Given App id delete request "665b0de2c728e2049bf7490b"
    And Id user delete request "66375c50906c3a525fc6e33b"
    When Sending DELETE request
    Then Response status code of delete request should be 403
    And Response body of delete request should be "{\"error\":\"APP_ID_NOT_EXIST\"}"
