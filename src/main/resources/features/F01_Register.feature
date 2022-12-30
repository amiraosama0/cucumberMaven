Feature: users could create new accounts with valid credentials

  Scenario: : user register new account successfully
    Given user go to register page
    When user select gender type
    And user enter first & last name
    And user enter date of birth
    And user enter validEmail
    And user enter password & confirm password
    And user click on register button
    Then account created successfully