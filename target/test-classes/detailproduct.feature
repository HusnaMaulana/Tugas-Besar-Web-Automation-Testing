Feature: Click Product name

  Scenario: User views item product overview
    Given I am logged in and on the products page
    When I click the product name
    Then I should be redirected to the detail product page