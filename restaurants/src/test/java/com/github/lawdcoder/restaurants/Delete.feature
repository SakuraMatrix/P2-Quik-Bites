Feature: Delete test

  Background:

  *url 'https://regres.in/api'
  *header Accept ='application/json'

    Scenario: Delete Testing
      Given path '/users/2'
      When method DELETE
      Then status 204
      And print response