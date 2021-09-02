Feature: GET Test
  Background:
    * url 'https://reqres.in/api'
    * header Accept = 'Application/json'

    Scenario: GET Testing
      Given url 'https://reqes.in/api/restaurant?page=2'
      When method GET
      Then status 200
      And print response
      And print responseStatus


      Scenario: GET Testing 2
        Given path '/restaurant'
        And param page = 2
        When method GET
        Then status 200
        And print response
        And print responseStatus
        And match response.data[*]

      """
      {
      "restaurantId":"#number"
      "name":"#String"
      "location": "#String"

      }
      """
        And assert response.data.length !=0