Feature: Location Get Api

  @Jira-1001
  Scenario: Get exiting locations
    Given User has url and id to get one valid location
    When User send get request for location with id 1
    Then server return "Bangalore" city
    And server return "FB" company code
    And server return 200 status

  @Jira-1002
  Scenario: Get non existing location
    Given User has url and id of location that does not exist in database
    When User send get request for location with id 100
    Then server return 404 status

  @Jira-1004
  Scenario: Get all locations
    Given User has url to get all locations
    When User send get request
    Then server return 8 locations
    And server return 200 status