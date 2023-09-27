Feature: Google Search Test
  Scenario: Google Search Test Scenario
    Given user launches a browser
    And user navigates to google search page
    When user searches for "Mechanical Keyboard"
    Then user should see search result