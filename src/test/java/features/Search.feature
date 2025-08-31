Feature: Search functionality
  Scenario: A user looks for a valid product
    Given A user opens the Application
    When A user enters the valid product "HP" into Search box field
    And A user clicks on the Search button
    Then The product should be displayed in the search results

    Scenario: User looks for an invalid product
      Given A user opens the Application
      When A user enters the invalid product "Honda" into the Search box field
      And A user clicks on the Search button
      Then A user should get a warning message about "no product matching"

      Scenario: A user looks for without any product
        Given A user opens the Application
        When A user doesn't enter any details into the Search box field
        And A user clicks on the Search button
        Then A user should get a warning message about "no product matching"
