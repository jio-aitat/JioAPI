@SingleUserData
Feature: The sample feature


  Scenario: GET users data
    Given user hit to end point "/users" with get method
    Then user should able to see the status as 200
    And user validates response

  Scenario: GET single user data
    Given user hit to end point "/users/2" with get method
    Then user should able to see the status as 200
    And user validates response

  Scenario: With parameters Scenario
    Given user has parameters "page" as "2"
    When users hit to end point "/users" with get method
    Then user should able to see the status as 200
    And user validates response

  Scenario: Post scenario
    Given user has input data "name" as "nameValue"
    Given user has input data "job" as "job value"
    When user hits to end point "/users" with post method
    Then user should able to see the status as 201
      