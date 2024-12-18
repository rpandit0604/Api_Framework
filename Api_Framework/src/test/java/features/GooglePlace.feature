Feature: Http method on PlaceApi

  Scenario: Adding a Place
    Given Add the Payload
    When send the Post request
    Then the user get response code as 200
    And the response contains the "PlaceId"

  Scenario: Update the Address
    Given the Update Place API payload with place_id "PlaceId" and new address "70 Summer walk, USA"
    When the user calls the UpdatePlace API with PUT HTTP request
    Then the update API call is successful with status code 200
    And the response contains the message Address successfully updated

  Scenario: Retrieve the PlaceDetails
    Given the place_id "PlaceId"
    When the user calls the GetPlace API with GET HTTP request
    Then the get API call is successful with status code 200
    And the response contains the name "Test Place"
    And the response contains the address "70 Summer walk, USA"

  Scenario: Delete the Place
    Given the Delete Place API payload with place_id "PlaceId"
    When the user calls the DeletePlace API with DELETE HTTP request
    Then the delete API call is successful with status code 200
    And the response contains the message Place deleted successfully
