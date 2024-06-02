Feature: Dashboard Product Interactions

  Background:
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page

  Scenario: Click Twitter button and go to Twitter Page
    When I click the twitter button
    Then The twitter page appear

  Scenario: Filter item product by name Z-A
    When I click the filter button
    Then I click the option name Z-A
    Then The product sorted by name

  Scenario: Filter item product by price low to high
    When I click the filter button
    When I click the option price (low to high)
    Then The product sorted by price