Feature: Login functionality
  The User logins into the Application

  Scenario: Login with a valid data
    Given User navigates to the login page
    When User has entered the valid email into the email field "dmytro.syadro@gmail.com"
    And User has entered the valid password into the password field "11111111"
    And User has clicked on the Login button
    Then User should be redirected to the successful page logged in


    Scenario: Login with an invalid data
      Given User navigates to the login page
      When User has entered the invalid email into the email field "dmyddddtro.syadro@gmail.com"
      And User has entered the invalid password into the password field "1111ddd11111"
      And User has clicked on the Login button
      Then The error message should be displayed below the fields

  Scenario: Login with an invalid email and valid password
    Given User navigates to the login page
    When User has entered the invalid email into the email field "dmyddtro.syadro@gmail.com"
    And User has entered the valid password into the password field "111111111"
    And User has clicked on the Login button
    Then The error message should be displayed below the fields