Feature: Login feature
  I want to login into wordpress website

  Scenario Outline: Login scenario
    Given I want to open the wordpress website
    And verify the website name
    When I enter the "<customer>" login details
    And I click on login continue button
    Then I verify the reader page title

    Examples: 
      | customer |
      | Praveen |
