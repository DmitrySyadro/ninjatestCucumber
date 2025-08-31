Feature: Registration functionality
  A user has to register the account
  Scenario: A user creates an account with obligatory fields with a valid data
    Given A User navigates to the register account page
    When A user enters the details into the fields
      | firstname            | Dmytro                  |
      | lastname             | Syadro                  |
      | email                | dmytro.syadro@gmail.com |
      | telephone            | 222222                  |
      | password             | 111111                  |
      | passwordconfirmation | 111111                  |
    And A user selects Privacy Policy
    And A user clicks on the Continue button
    Then A user's account should be created successfully



  Scenario: A user creates a duplicate account
    Given A User navigates to the register account page
    When A user enters the details into the fields with a duplicate email
      | firstname            | Dmytro                  |
      | lastname             | Syadro                  |
      | email                | dmytro.syadro@gmail.com |
      | telephone            | 222222                  |
      | password             | 111111                  |
      | passwordconfirmation | 111111                  |
    And A user selects Yes for Newsletter
    And A user selects Privacy Policy
    And A user clicks on the Continue button
    Then A user's account should get a proper warning that the account with those credentials was created


  Scenario: A user creates an account without filling any details
    Given A User navigates to the register account page
    When A user doesn't enter any details into fields
    And A user clicks on the Continue button
    Then A user should be proper warning message for every mandatory field

