Feature: logout from SauceDemo

  Scenario: Successful login and logout
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page

    When I click the menu button
    And I click the logout button
    Then I should be redirected to the login page