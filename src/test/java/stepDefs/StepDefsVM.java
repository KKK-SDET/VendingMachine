package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.*;
import org.junit.After;
import services.Inventory;
import services.VendingMachine;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StepDefsVM {

    VendingMachine vm;
    Coin coin;
    Coin coin1;
    Inventory inventory;
    Item item;


    @After
    public void resetVM() {
        vm.reset();
    }

    @Given("vending machine is loaded")
    public void vending_machine_is_loaded(List<Map<String, String>> itemAndCoinData) {
        vm = new VendingMachine();
        inventory = new Inventory();
        coin = new Coin(CoinEnum.QUARTER.getValue(), 1);
        coin1 = new Coin(CoinEnum.DIME.getValue(), 1);
        item = new Item(ItemEnum.valueOf(itemAndCoinData.get(0).get("itemName")).toString(),
                ItemEnum.valueOf(itemAndCoinData.get(0).get("itemName")).getValue());
    }

    @When("user selects item")
    public void user_selects_item() throws Exception {
        long price = vm.selectItemAndGetPrice(item.toString());
        vm.selectItemAndGetPrice(item.toString());
        assertEquals("item price and selected item price mismatch", item.getPrice(), price);
    }

    @When("user deposits funds")
    public void user_deposits_funds() throws Exception {
        vm.insertCoin(coin);
    }

    @Then("vending machine dispenses item")
    public void vending_machine_dispenses_item() throws Exception {
        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
        Item item = bucket.getFirst();
        assertEquals("Bucket contains wrong Item", item.toString(), item.getName());
        List<Coin> change = bucket.getSecond();
        assertFalse("Item was not dispensed", inventory.hasItemByName(item.toString()));

    }

    @Then("user cancels purchase and get refunded")
    public void user_cancels_purchase_and_get_refunded() throws Exception {
        vm.refund();
    }

    @Then("user deposits insufficient amount")
    public void user_deposits_insufficient_amount() throws Exception {
        int insuffAmount = (int) (item.getPrice() - coin1.denomination * coin1.count);
        vm.insertCoin(new Coin(insuffAmount, 1));
    }

    @And("user deposits funds and vending machine gives insufficient funds error message")
    public void userDepositsFundsAndVendingMachineGivesInsufficientFundsErrorMessage() {
        vm.insertCoin(coin1);
        try {
            vm.collectItemAndChange();
        } catch (Exception e) {
            if (e.getMessage().equals("Price not full paid, remaining : ")) {
                System.out.println("Price not full paid, remaining : "
                        + (item.getPrice() - coin1.count * coin1.denomination));
            }
        }
    }

    @And("and user get refunded")
    public void andUserGetRefunded() throws Exception {
        vm.refund();
    }

    @Then("vending machine gives error message")
    public void vendingMachineGivesErrorMessage() {
        try {
            vm.selectItemAndGetPrice(item.getName());
        } catch (Exception e) {
            if (e.getMessage().equals("Sold Out, Please buy another item")) {
                vm.reset();
            }
        }
    }

    @And("user deposits funds and vending machine gives insufficient change error message")
    public void userDepositsFundsAndVendingMachineGivesInsufficientChangeErrorMessage() {
        vm.insertCoin(coin);
        vm.insertCoin(coin);
        try {
            vm.collectItemAndChange();
        } catch (Exception e) {
            if (e.getMessage().equals("Not Sufficient change in services.Inventory")
                    || e.getMessage().equals("NotSufficientChange, Please try another product")) {
                System.out.println("NotSufficientChange, Please try another product");
            }
        }
    }
}