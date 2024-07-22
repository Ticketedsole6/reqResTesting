Feature: Delete User

  Scenario: Delete User and validate status code success
    Given tester load customer information
      | id |
      | 2  |
    When tester call delete user API
    Then tester should get status code 204
