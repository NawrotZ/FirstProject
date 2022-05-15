Feature: Internet

  Scenario: Check for Zuzanna Sielska on University page
    Given I open a browser
    And I go to University page
    When I search for Zuzanna Sielska
    Then I see results