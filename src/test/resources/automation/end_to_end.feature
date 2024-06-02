Feature: End to end Testing

  Scenario: Checkout Succes
    Given Already login on website sauce demo
    When I click the product image
    Then I should be redirected to the detail product page
    And I click back to product button
    Then I should be redirected again to the products page
    When Click on the cart icon
    Then Already on cart page
    And Click continue shopping button
    Then I should be redirected to the products page
    And Already adding two items "onesie" and "allthethings" to cart
    Then Already on cart page
    When User Remove one item
    And Click checkout button
    Then Redirect to checkout page
    When User input "Danu" as firstName "Mahesa" as lastName and 456789 as zipPostalCode
    And Click continue button
    And Click finish button
    Then Click back home button
    Then I should be redirected to the products page
    When I click the menu button
    And I click the logout button
    Then I should be redirected to the login page