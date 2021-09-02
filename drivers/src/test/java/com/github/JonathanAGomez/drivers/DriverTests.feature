Feature: Tests
  Background:
    * url 'http://localhost:8080/DRIVERS'
    * header Accept = 'application/json'

  Scenario: GET Testing
    Given path ''
    When method GET
    Then status 200
    And print response

  Scenario: POST Testing
    Given path ''
    When request {"driver_id": 4, "driver_name": "Jonathan", "cust_location": "NULL", "location": "NULL", "rest_location": "NULL"}
    And header Content-Type = 'application/json'
    And method POST
    Then status 200
    And print response

  Scenario: DELETE Testing
    Given path '/4'
    When method DELETE
    Then status 200
    And print response