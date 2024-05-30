Feature: Login to SauceDemo

  Scenario: Successful open SauceDemo login page
    Given I am on the SauceDemo login page

  Scenario: Successful login
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page

  Scenario: Login with Empty Field
    Given I am on the SauceDemo login page
    When I enter username "" and password ""
    And I click the login button
    Then I should see an error message needed

  Scenario: Login with empty password
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password ""
    And I click the login button
    Then I should see an error message Password is required

  Scenario: Login with empty Username
    Given I am on the SauceDemo login page
    When I enter username "" and password "secret_sauce"
    And I click the login button
    Then I should see an error message Username is required

  Scenario: Login with incorrect password
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "bukanpassword"
    And I click the login button
    Then I should see an error message

  Scenario: Login with incorrect username
    Given I am on the SauceDemo login page
    When I enter username "bukan_user" and password "secret_sauce"
    And I click the login button
    Then I should see an error message username

  Scenario: Login with incorrect username and password
    Given I am on the SauceDemo login page
    When I enter username "bukan_user" and password "bukanpassword"
    And I click the login button
    Then I should see an error message