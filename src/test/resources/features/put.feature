Feature: Update user information data

  Scenario Outline: Update user information data and validate status code success
    Given tester load customer information
      | id   | name   | job   |
      | <id> | <name> | <job> |
    When tester call put user API
    Then tester should get status code 200

    Examples:
      | id | name | job |
      ##@externaldata@./src/test/resources/data/UpdateUserData.xlsx@Hoja1@1
   |2   |morpheus   |zion resident|

  Scenario Outline: Update user information data and validate the response schema success
    Given tester load customer information
      | id   | name   | job   |
      | <id> | <name> | <job> |
    When tester call put user API
    Then tester validate schema response "PutJsonSchema"

    Examples:
      | id | name | job |
      ##@externaldata@./src/test/resources/data/UpdateUserData.xlsx@Hoja1@1
   |2   |morpheus   |zion resident|

  Scenario Outline: Update user information data and validate the numbers of keys success
    Given tester load customer information
      | id   | name   | job   |
      | <id> | <name> | <job> |
    When tester call put user API
    Then tester validate keys quantity is 3

    Examples:
      | id | name | job |
      ##@externaldata@./src/test/resources/data/UpdateUserData.xlsx@Hoja1@1
   |2   |morpheus   |zion resident|

  Scenario Outline: Update user information data and validate the response data success
    Given tester load customer information
      | id   | name   | job   |
      | <id> | <name> | <job> |
    When tester call put user API
    Then tester validate put response contains data expected

    Examples:
      | id | name | job |
      ##@externaldata@./src/test/resources/data/UpdateUserData.xlsx@Hoja1@1
   |2   |morpheus   |zion resident|
