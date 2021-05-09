Feature: Validate Token from the User

  Scenario: validate token
    Given user has access token


  Scenario: GET users data
    Given user hit to end point "/users" with get method
    Then user should able to see the status as 200
    And user validates response
    And user validates the data "2" from the response