Feature: Post Test

  Background:
    * url 'https://reqres.in/api'
    * header Accept = 'application/json'

    Scenario: Post Testing
      Given path '/users'
      And request {"name": "Jonathan","job": "teacher"}
      When method POST
      Then status 201
      And match response == {"createdAt": "#ignore","name": "Jonathan", "id": "#string", "job": "teacher"}
      And print response