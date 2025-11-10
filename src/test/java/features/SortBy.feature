
Feature: Sorting functionality


  Scenario: User sorts monitors by Name (A - Z)
    Given The user navigates to the "Components" page
    And The user opens the "Monitors" section
    When The user selects "Name (A - Z)" from the "Sort By" dropdown
    Then The products should be sorted alphabetically by name in ascending order

  Scenario: User sorts monitors by Name (Z - A)
    Given The user navigates to the "Components" page
    When The user selects "Name (Z - A)" from the "Sort By" dropdown
    Then The products should be sorted alphabetically by name in descending order
    And The first product name should start with a letter closer to "Z"
    And The last product name should start with a letter closer to "A"

  # ---------------- PRICE ----------------
  Scenario: User sorts monitors by Price (Low > High)
    Given The user navigates to the "Components" page
    When The user selects "Price (Low > High)" from the "Sort By" dropdown
    Then The products should be sorted by price in ascending order
    And The first product should have the lowest price
    And The last product should have the highest price

  Scenario: User sorts monitors by Price (High > Low)
    Given The user navigates to the "Components" page
    When The user selects "Price (High > Low)" from the "Sort By" dropdown
    Then The products should be sorted by price in descending order
    And The first product should have the highest price
    And The last product should have the lowest price

  # ---------------- RATING ----------------
  Scenario: User sorts monitors by Rating (Highest)
    Given The user navigates to the "Components" page
    When The user selects "Rating (Highest)" from the "Sort By" dropdown
    Then The products should be sorted by rating in descending order
    And The first product should have the highest rating
    And The last product should have the lowest rating

  Scenario: User sorts monitors by Rating (Lowest)
    Given The user navigates to the "Components" page
    When The user selects "Rating (Lowest)" from the "Sort By" dropdown
    Then The products should be sorted by rating in ascending order
    And The first product should have the lowest rating
    And The last product should have the highest rating

  # ---------------- MODEL ----------------
  Scenario: User sorts monitors by Model (A - Z)
    Given The user navigates to the "Components" page
    When The user selects "Model (A - Z)" from the "Sort By" dropdown
    Then The products should be sorted alphabetically by model in ascending order
    And The first product model should start with a letter closer to "A"
    And The last product model should start with a letter closer to "Z"

  Scenario: User sorts monitors by Model (Z - A)
    Given The user navigates to the "Components" page
    When The user selects "Model (Z - A)" from the "Sort By" dropdown
    Then The products should be sorted alphabetically by model in descending order
    And The first product model should start with a letter closer to "Z"
    And The last product model should start with a letter closer to "A"
