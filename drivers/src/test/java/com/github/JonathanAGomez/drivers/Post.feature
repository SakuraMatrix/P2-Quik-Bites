Feature: Post Test

  Background:
    # * url 'https://reqres.in/api'
    * url 'http://host.docker.internal:51360/actuator/info'
    * header Accept = 'application/json'

    Scenario: Post Testing
      Given path ''
      And request {"driver_id": 4, "driver_name": "Jonathan", "cust_location": "NULL", "location": "NULL", "rest_location": "NULL"}
      When method POST
      Then status 201
      And print response