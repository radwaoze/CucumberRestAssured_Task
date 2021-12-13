Feature: GET Request
  I Want To Send a GET Request to get ColourLovers api details

  Scenario: Send a GET request

    Given I send a get request to the URL
    Then the response will return status code 200
    And assert that numViews is greater than 4000




