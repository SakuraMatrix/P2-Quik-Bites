Feature: GET Test
  Background:
    * url 'https://reqres.in/api'
    * header Accept = 'application/json'

  Scenario: GET Testing
    Given url 'https://reqres.in/api/users?page=2'
    When method GET
    Then status 200
    And print response
    And print responseStatus