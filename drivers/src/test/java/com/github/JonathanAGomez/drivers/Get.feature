Feature: GET Test
  Background:
    # * url 'https://reqres.in/api'
    * url 'http://host.docker.internal:51360/actuator/info'
    * header Accept = 'application/json'

  Scenario: GET Testing
    Given path ''
    When method GET
    Then status 200
    And print response
    And print responseStatus
