Feature: Brand Get Api

  Scenario: Get all brands
    Given User has url and id to get one brand
    When User send get request with id 1
    Then server return facebook brand
    And server return 200 status

  Scenario: Get non existing brands
    Given User has url and id of brand that does not exist in database
    When User send get request with id 100
    Then server return 404 status
