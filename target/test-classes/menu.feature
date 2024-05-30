Feature: Menu Interactions

  Background:
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page

  Scenario: Click menu button and menu appears
    When I click the menu button
    Then The menu should appear

  Scenario: Click about button
    When I click the menu button
    Then I click the about button
    Then I should be redirected to the Sauce Labs About

  Scenario: Click all items link
    When I click the menu button
    And I click the all items link
    Then I should be redirected again to the products page
