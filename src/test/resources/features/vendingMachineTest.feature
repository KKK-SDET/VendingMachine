Feature: testing vending machine

  Background:
    Given vending machine is loaded
      | itemName |
      | COKE     |

  Scenario: purchase item without change
    When user selects item
    And user deposits funds
    Then vending machine dispenses item

  Scenario: purchase item with change returned
    When user selects item
    And user deposits funds
    Then vending machine dispenses item
    And and user get refunded

  Scenario: cancel purchase and refund
    When user selects item
    And user deposits funds
    And user cancels purchase and get refunded

  Scenario: selecting a missing item
    When user selects item
    Then vending machine gives error message

  Scenario: insufficient amount is provided
    When user selects item
    And user deposits funds and vending machine gives insufficient funds error message
    Then user deposits insufficient amount
    And vending machine dispenses item

  Scenario: vending machine has insufficient change
    When user selects item
    And user deposits funds and vending machine gives insufficient change error message
    Then user cancels purchase and get refunded
