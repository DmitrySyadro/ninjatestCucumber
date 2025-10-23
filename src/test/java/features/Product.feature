Feature: Adding a product to the shopping cart
  Scenario: Verify that the user is able to add products to the shopping cart with valid data
    Given The user is logging in the site
    When a user clicks on the search bar
    And a user enters valid the product "Apple Cinema"
    And a user clicks on the icon of the product
    And a user clicks on the below checkbox
    And a user selects colour of the monitor
    And a user enters the text into TextArea "Quicker"
    And a user ticks the date
    And a user ticks the time
    And a user enters