@Test
Feature: Search Feature
  Scenario Outline: search using product name
    When  user click on search field
    And user search with "<product name>"
    Then user could find "<product name>"


    Examples:
      | product name |
      | laptop      |
      | book       |
      | adidas     |
      | nike       |


  Scenario Outline: search using product sku
    When  user click on search field
    And user search with "<sku>"
    Then user could find "<sku>" in product details


    Examples:
      | sku          |
      | HP_ESB_15    |
      | SCI_FAITH    |
      | AD_C80_RS   |
      | NK_FRC_RS   |
      | APPLE_CAM   |
      |  SF_PRO_11   |