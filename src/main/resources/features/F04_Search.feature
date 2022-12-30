Feature: user could search for products
  Scenario:  user could search using product name
    When user enter product "laptop"
    When user press on search button
    Then results must be shown

  Scenario: user could search using product sku
    When user enter product "APPLE_CAM"
    When user press on search button
    And user press on the product
    Then sku of the product must be the same like on search