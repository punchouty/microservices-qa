Feature: Brand Query

#  Scenario: Query single brand
#    Given User has url to search id
#    When User send post request with id as parameter
#    Then single brand is returned

  Scenario: Query all brands
    Given Prepare url to get all brands
    When Send graphql request
    Then Number of brands returned is 4
    And Status code is 200