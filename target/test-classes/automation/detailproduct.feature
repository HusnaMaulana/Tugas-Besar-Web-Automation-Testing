Feature: Click Product name

  Scenario: User views item product overview with click name
    Given I am logged in and on the products page
    When I click the product name
    Then I should be redirected to the detail product page

  Scenario: User views item product overview with click image
    Given I am logged in and on the products page
    When I click the product image
    Then I should be redirected to the detail product page

  Scenario: User views item product overview and back to product page
    Given I am logged in and on the products page
    When I click the product image
    Then I should be redirected to the detail product page
    And I click back to product button
    Then I should be redirected again to the products page