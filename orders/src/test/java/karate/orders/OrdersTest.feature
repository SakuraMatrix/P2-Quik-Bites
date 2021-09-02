Feature: Orders Tests

Background:
* url 'http://localhost:8080/ORDERS'
* header Accept = 'application/json'

  Scenario: Test the basic GetAll Method
    Given path ''
    When method GET
    Then status 200
  
  Scenario: Get the first order
    Given path '/1'
    When method GET
    Then status 200
    And print response

  Scenario: Update the status of an order
    Given path '/1/posted'
    When method GET
    Then status 200

  Scenario: Post a new order
    Given path ''
	When request '{"orderId":500,"customerId":5,"driverId":9,"resturantId":15,"total":10.0,"orderStatus":"posted","orderItems":{"1":1,"2":1,"3":5}}'
	And header Content-Type = 'application/json'
    And method POST
    Then status 200

  Scenario: Delete an order
    Given path 'delete/500'
    When method DELETE
    Then status 200