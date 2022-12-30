@g15
Feature: user could switch between different currencies
  Scenario: verify that dollar select first option
   Then first option is dollar
    Scenario: user could select different option than dollar
      When user select Euro option
      Then price changed successfully
