Feature: Checkout Process
  As a user, I want to efficiently checkout products on the SauceDemo website.

  Scenario: Checkout Succes
    Given Already login on website sauce demo
    And Already adding two items "onesie" and "allthethings" to cart
    Then Already on cart page
    When User Remove one item
    And Click checkout button
    Then Redirect to checkout page
    When User input "Danu" as firstName "Mahesa" as lastName and 456789 as zipPostalCode
    And Click continue button
    And Click finish button
    Then Click back home button

  Scenario: Checkout with firstName field empty
    Given Already login on website sauce demo
    And Already adding two items "onesie" and "allthethings" to cart
    Then Already on cart page
    When User Remove one item
    And Click checkout button
    Then Redirect to checkout page
    When User input "" as firstName "Mahesa" as lastName and 456789 as zipPostalCode
    And Click continue button
    Then I should see an error message first name required

  Scenario: Checkout with lastName field empty
    Given Already login on website sauce demo
    And Already adding two items "onesie" and "allthethings" to cart
    Then Already on cart page
    When User Remove one item
    And Click checkout button
    Then Redirect to checkout page
    When User input "Danu" as firstName "" as lastName and 456789 as zipPostalCode
    And Click continue button
    Then I should see an error message last name required

 