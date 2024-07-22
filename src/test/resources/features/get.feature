Feature: get information to individual user

  Scenario: Get individual information user and validate status code success
    Given tester load customer information
      | id |
      | 2  |
    When tester call user API
    Then tester should get status code 200

  Scenario: Get individual information user and validate the response schema
    Given tester load customer information
      | id |
      | 2  |
    When tester call user API
    And tester validate schema response "GetJsonSchema"

  Scenario: Get individual information user and validate the numbers of keys
    Given tester load customer information
      | id |
      | 2  |
    When tester call user API
    Then tester validate keys quantity is 2

  Scenario: Get individual information user and validate the response data
    Given tester load customer information
      | id |
      | 2  |
    When tester call user API
    Then tester validate response contains data expected
