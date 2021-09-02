Feature: Delete test

  Background:
    # * url 'https://reqres.in/api'
    * url 'http://host.docker.internal:51360/actuator/info'
    * header Accept = 'application/json'

    Scenario: Delete Testing
      Given path '/4'
      When method DELETE
      Then status 204
      And print response