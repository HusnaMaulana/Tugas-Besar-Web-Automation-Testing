Feature: Cart Process

  Scenario: Cart with no item 
    Given Already login on website sauce demo
    When Click on the cart icon
    Then Already on cart page
    And Click checkout button
    Then Redirect to checkout page

  Scenario: Cart with two items 
    Given Already login on website sauce demo
    And Already adding two items "onesie" and "allthethings" to cart
    Then Already on cart page
    And Click checkout button
    Then Redirect to checkout page

  Scenario: Cart and go back to product page
    Given Already login on website sauce demo
    And Already adding two items "onesie" and "allthethings" to cart
    Then Already on cart page
    And Click continue shopping button
    Then I should be redirected to the products page
