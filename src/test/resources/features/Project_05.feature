Feature: Pagination page functionality

  Background:
    Given user navigates to "https://techglobal-training.com/frontend/project-5"

  @PaginationMainContent
  Scenario: 01 - Validate the main content
    Then the user should see the "Pagination" heading
    And the user should see the "World City Populations 2022" heading
    And the user should see the "What are the most populated cities in the world? Here is a list of the top five most populated cities in the world:" paragraph

  @NextPrevButtons
    Scenario: 02 - Validate the Pagination Next/Previous buttons
    Then the user should see the "Previous" button is disabled
    And the user should see the "Next" button is enabled
    When the user clicks on the "Next" button
    Then the user should see the "Previous" button is enabled
    When the user clicks on the "Next" button till it becomes disabled
    Then the user should see the "Previous" button is enabled
    And the user should see the "Next" button is disabled

  @CitiesContent
  Scenario Outline: 03 - Validate the Pagination Cities content
    Then the user should see City as "<City>", Country as "<Country>" and Population "<Population>"  with the info below and an image
    When the user clicks on the "Next" button

    Examples:
      |City             | Country        | Population|
      |City: Tokyo      | Country: Japan | Population: 37,435,191|
      |City: Delhi      | Country: India | Population: 29,399,141|
      |City: Shangai    | Country: China | Population: 26,317,104|
      |City: Sao Paulo  | Country: Brasil| Population: 21,846,507|
      |City: Mexico City| Country: Mexico| Population: 21,671,908|
