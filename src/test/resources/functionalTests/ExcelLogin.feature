Feature: ExcelLogin feature
  I want to login into wordpress website

  Scenario Outline: ExcelLogin scenario
    Given I want to open the wordpress website
    And verify the website name
    When I input username and password with excel row "<row_index>" dataset
    And I click on login continue button
    Then I verify the reader page title

    Examples: 
      | row_index |
      |0|
      |1|

      