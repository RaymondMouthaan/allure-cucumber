Feature: Google Search
  Scenario: Search on Google
    Given the Google search page
    When we search for "hello world"
    Then the first result must be "hell world"
