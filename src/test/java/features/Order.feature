Feature: Order functionality
  @Order
  Scenario: Verify that the user is able to place orders
    Given The user login in the app
    When The user add any product to back and checkout
    And The user place an order
    Then The user should see that order is places successfully
