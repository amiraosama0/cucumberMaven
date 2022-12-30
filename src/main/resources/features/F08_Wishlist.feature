Feature: user could add product to wishList
  Scenario: user add product to wishList
    When user click on wishlist button
    Then product successfully added to wishlist

  Scenario: user open the wishlist
    When user click on wishlist button
    And user click on wishlist tap
    Then get product quantity value bigger than zero
