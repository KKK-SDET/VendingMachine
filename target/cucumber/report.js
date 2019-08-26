$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/vendingMachineTest.feature");
formatter.feature({
  "name": "testing vending machine",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "vending machine is loaded",
  "rows": [
    {
      "cells": [
        "itemName"
      ]
    },
    {
      "cells": [
        "COKE"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefsVM.vending_machine_is_loaded(String,String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "purchase item without change",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user selects item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefsVM.user_selects_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deposits funds",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefsVM.user_deposits_funds()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "vending machine dispenses item",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefsVM.vending_machine_dispenses_item()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "vending machine is loaded",
  "rows": [
    {
      "cells": [
        "itemName"
      ]
    },
    {
      "cells": [
        "COKE"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefsVM.vending_machine_is_loaded(String,String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "purchase item with change returned",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user selects item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefsVM.user_selects_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deposits funds",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefsVM.user_deposits_funds()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "vending machine dispenses item",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefsVM.vending_machine_dispenses_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "and user get refunded",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefsVM.andUserGetRefunded()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "vending machine is loaded",
  "rows": [
    {
      "cells": [
        "itemName"
      ]
    },
    {
      "cells": [
        "COKE"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefsVM.vending_machine_is_loaded(String,String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "cancel purchase and refund",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user selects item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefsVM.user_selects_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deposits funds",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefsVM.user_deposits_funds()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user cancels purchase and get refunded",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefsVM.user_cancels_purchase_and_get_refunded()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "vending machine is loaded",
  "rows": [
    {
      "cells": [
        "itemName"
      ]
    },
    {
      "cells": [
        "COKE"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefsVM.vending_machine_is_loaded(String,String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "selecting a missing item",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user selects item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefsVM.user_selects_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "vending machine gives error message",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefsVM.vendingMachineGivesErrorMessage()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "vending machine is loaded",
  "rows": [
    {
      "cells": [
        "itemName"
      ]
    },
    {
      "cells": [
        "COKE"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefsVM.vending_machine_is_loaded(String,String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "insufficient amount is provided",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user selects item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefsVM.user_selects_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deposits funds and vending machine gives insufficient funds error message",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefsVM.userDepositsFundsAndVendingMachineGivesInsufficientFundsErrorMessage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deposits insufficient amount",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefsVM.user_deposits_insufficient_amount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "vending machine dispenses item",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefsVM.vending_machine_dispenses_item()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "vending machine is loaded",
  "rows": [
    {
      "cells": [
        "itemName"
      ]
    },
    {
      "cells": [
        "COKE"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefsVM.vending_machine_is_loaded(String,String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "vending machine has insufficient change",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user selects item",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefsVM.user_selects_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deposits funds and vending machine gives insufficient change error message",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefsVM.userDepositsFundsAndVendingMachineGivesInsufficientChangeErrorMessage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user cancels purchase and get refunded",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefsVM.user_cancels_purchase_and_get_refunded()"
});
formatter.result({
  "status": "passed"
});
});