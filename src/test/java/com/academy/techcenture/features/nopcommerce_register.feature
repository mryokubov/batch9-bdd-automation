@regression
Feature: NopCommerce Register Feature
  Scenario Outline: NopCommerce Register User Scenario
    Given user is on the homepage
    When user clicks on register link on top
    Then user should be navigated to register page
    And user selects gender "<gender>"
    And user enters "<firstname>" in firstname input
    And user enters "<lastname>" in lastname input
    And user selects "<birth_day>" for day, "<birth_month>" for month and "<birth_year>" for year
    And user enters "<email>" in email input
    And user enters "<company_name>" in company name input
    And user selects "<newsletter>" on newsletter radio box
    And user enters "<password>" in password input
    And user confirms "<confirm_password>" in confirm password input
    When user clicks on register button
    Then user should see "<register_success_msg>" success message
    When user clicks on continue button
    Then user is on the homepage
    When user clicks on login link
    Then user is on the login page
    And user enters valid username and password as login credentials
    And user selects "<remember_me>" on remember me radio box
    When user clicks on the login button
    Then user is on the homepage
    And user can see my account link
    And user can logout

    Examples:
    |gender  | firstname   | lastname | birth_day | birth_month | birth_year | email                     | company_name        | newsletter | password | confirm_password| register_success_msg        | remember_me|
    | male   | Kevin       | Lee      | 17        | January     | 1998       |kevin.lee@techcenture.com  | Techcenture Academy | check      | Kev-17Lee| Kev-17Lee       | Your registration completed | check      |
    | female | Sarah       | Peterson | 19        | March       | 1956       |sarah.peterson@yahoo.com   | Freddie Mac         | un-check   | Kev-17Lee| Kev-17Lee       | Your registration completed | un-check   |
    | male   | James       | Lee      | 17        | January     | 1998       |james.lee@techcenture.com  | Techcenture Academy | check      | Kev-17Lee| Kev-17Lee       | Your registration completed | check      |

    @smoke
    Examples:
    |gender  | firstname   | lastname | birth_day | birth_month | birth_year | email                     | company_name        | newsletter | password | confirm_password| register_success_msg        | remember_me|
    | female | Lilly       | Peterson | 19        | March       | 1956       |lilly.peterson@yahoo.com   | Freddie Mac         | un-check   | Kev-17Lee| Kev-17Lee       | Your registration completed | un-check   |