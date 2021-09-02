Feature: Customer Tests
  Scenario: Testing with Tests
    Given url 'https://reqres.in/api/users?page=2'
    When method GET
    Then status 200