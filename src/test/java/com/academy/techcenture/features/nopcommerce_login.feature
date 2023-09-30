Feature: NopCommerce Login Feature
  Scenario: NopCommerce User Login Scenario One User
    Given user is on the homepage
    When user clicks on login link
    Then user is on the login page
    And user enters valid "kevin.lee29510@techcenture.com" and "Kev-17Lee" as login credentials
    And user selects "check" on remember me radio box
    When user clicks on the login button
    Then user is on the homepage
    And user can see my account link
    And user can logout

  Scenario Outline: NopCommerce User Login Scenario Multiple Users
    Given user is on the homepage
    When user clicks on login link
    Then user is on the login page
    And user enters valid "<username>" and "<password>" as login credentials
    And user selects "<remember_me>" on remember me radio box
    When user clicks on the login button
    Then user is on the homepage
    And user can see my account link
    And user can logout

    Examples:
    |username                       | password | remember_me|
    |kevin.lee29510@techcenture.com | Kev-17Lee| check      |
    |sarah.peterson11232@yahoo.com | Kev-17Lee | un-check   |
    |lilly.peterson24144@yahoo.com | Kev-17Lee | check      |
    |kevin.lee29510@techcenture.com | Kev-17Lee| un-check   |