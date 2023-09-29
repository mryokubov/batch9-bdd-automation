Feature: NopCommerce Register Feature
  Scenario: NopCommerce Register User Scenario
    Given user is on the homepage
    When user clicks on register link on top
    Then user should be navigated to register page
    And user selects gender "male"
    And user enters "Kevin" in firstname input
    And user enters "Lee" in lastname input
    And user selects "17" for day, "January" for month and "1960" for year
    And user enters "kevin.lee@techcenture.com" in email input
    And user enters "Techcenture Academy" in company name input
    And user selects "check" on newsletter radio box
    And user enters "Kev-17Lee" in password input
    And user confirms "Kev-17Lee" in confirm password input
    When user clicks on register button
    Then user should see "Your registration completed" success message
    When user clicks on continue button
    Then user is on the homepage
    When user clicks on login link
    Then user is on the login page
    And user enters valid username and password as login credentials
    And user selects "check" on remember me radio box
    When user clicks on the login button
    Then user is on the homepage
    And user can see my account link