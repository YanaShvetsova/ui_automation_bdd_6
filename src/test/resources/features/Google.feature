Feature: Google search functionality

  Scenario Outline: Validate the title and url after search
    Given user navigates to "https://www.google.com"
    When user search for "<input>"
    Then user should see "<input>" in the url
    And user should see "<input>" in the title

    Examples:
      | input     |
      | Tesla     |
#      | Apple     |
#      | Microsoft |
#      | Amazon    |