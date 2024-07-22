Feature: Create User

  Scenario Outline: Create User and validate status code success
    Given tester load customer information
      | name   | job   |
      | <name> | <job> |
    When tester call post user API
    Then tester should get status code 201

    Examples:
      | name | job |
      ##@externaldata@./src/test/resources/data/CreateUserData.xlsx@Hoja1@1
   |morpheus   |leader|

  Scenario Outline: Create User and validate the response schema success
    Given tester load customer information
      | name   | job   |
      | <name> | <job> |
    When tester call post user API
    Then tester validate schema response "PostJsonSchema"

    Examples:
      | name | job |
      ##@externaldata@./src/test/resources/data/CreateUserData.xlsx@Hoja1@1
   |morpheus   |leader|

  Scenario Outline: Create User and validate the numbers of keys success
    Given tester load customer information
      | name   | job   |
      | <name> | <job> |
    When tester call post user API
    Then tester validate keys quantity is 4

    Examples:
      | name | job |
      ##@externaldata@./src/test/resources/data/CreateUserData.xlsx@Hoja1@1
   |morpheus   |leader|

  Scenario Outline: Create User and validate the response data success
    Given tester load customer information
      | name   | job   |
      | <name> | <job> |
    When tester call post user API
    Then tester validate post response contains data expected

    Examples:
      | name | job |
      ##@externaldata@./src/test/resources/data/CreateUserData.xlsx@Hoja1@1
   |morpheus   |leader|
