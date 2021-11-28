Feature: Brand Query

  Scenario: Query single brand
    Given User has url to search id
    When User send post request with id as parameter
    Then single branad is returned

  Scenario: Query all brands
    Given User has url to get all brands
    When User send post request
    Then List of brands is returned