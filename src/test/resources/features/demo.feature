Feature: Just a simple demo

  Scenario: Sum of two
    Given number 10 and number 20
    When the numbers are added together
    Then the sum must be equal to 30

  Scenario Outline: Sum of two
    Given number <a> and number <b>
    When the numbers are added together
    Then the sum must be equal to <c>
    Examples:
      | a | b | c |
      | 1 | 2 | 3 |
      | 2 | 4 | 6 |
