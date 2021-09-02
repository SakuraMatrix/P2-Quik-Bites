Feature: Post Test

  Background:
    * url 'https://reqres.in/api'
    * header Accept = 'application/json'

  Scenario: Post Testing
    Given path '/restaurants'
    And request {"restaurantId": "1","name": "McDonald"}
    When method POST
    Then status 201
    And match response == {"createdAt": "#ignore","restaurantId": "6", "name": "#string", "location": "texas"}
    And print response