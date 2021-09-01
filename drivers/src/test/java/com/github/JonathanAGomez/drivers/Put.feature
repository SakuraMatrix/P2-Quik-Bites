Feature: Put Test

  Background:
    * url 'https://reqres.in/api'
    * header Accept = 'application/json'

  Scenario: Put Testing
    Given path '/users'
    And request {"name": "morpheus","job": "zion resident"}
    When method PUT
    Then status 200
    And print response
