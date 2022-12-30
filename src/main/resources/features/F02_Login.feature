Feature: users could use login functionality to use their acc

  Scenario: user could login with valid email and pass
    Given user go to login page
    When user login with "amira.osama03655@gmeil.com" and "123456"
    When user press on login button
    Then  user login to the system successfully

  Scenario: user could login with invalid email and pass
    Given user go to login page
    When user login with "invalid mail" and "pass"
    And user press on login button
    Then user could not login to the system

