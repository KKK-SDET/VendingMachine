package services;

import domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private Map<Integer, Integer> cashInventory = new HashMap<>();
    private Inventory itemInventory = new Inventory();
    private long totalSales;
    private Item currentItem;
    private long currentBalance;

    public VendingMachine() {
        initialize();
    }

    private void initialize() {
        //initialize machine with 5 coins of each denomination
        cashInventory = new HashMap<>();
        cashInventory.put(25, 5);
        cashInventory.put(10, 5);
        cashInventory.put(5, 5);
        cashInventory.put(1, 5);

        //Initialise Items inventory with 5 cans of each domain.Item
        for (ItemEnum i : ItemEnum.values()) {
            Item itm = new Item(i.name(), i.getValue());
            itemInventory.put(itm, 5);
        }
    }

    public long selectItemAndGetPrice(String itemName) throws Exception {
        if (itemInventory.hasItemByName(itemName)) {
            currentItem = itemInventory.getItemByName(itemName);
            return currentItem.getPrice();
        }
        throw new Exception("Sold Out, Please buy another item");

    }

    /// <summary>
    /// Adds the inserted coin to the coin inventory and updates the current balance too.
    /// </summary>
    /// <param name="coin"></param>
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + (coin.getDenomination() * coin.getCount());

        cashInventory.put(coin.getDenomination(), coin.getDenomination() + coin.getCount());
    }

    /// <summary>
    /// Refunds the inserted money
    /// </summary>
    /// <returns></returns>
    public List<Coin> refund() throws Exception {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    /// <summary>
    /// Returns the selected Item and change if any
    /// </summary>
    /// <returns></returns>
    public Bucket<Item, List<Coin>> collectItemAndChange() throws Exception {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        List<Coin> change = collectChange();
        return new Bucket<Item, List<Coin>>(item, change);

    }

    private List<Coin> collectChange() throws Exception {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    private Item collectItem() throws Exception {
        if (isFullPaid()) {
            if (hasSufficientChange()) {
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new Exception("Not Sufficient change in services.Inventory");
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new Exception("Price not full paid, remaining : " + remainingBalance);
    }

    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private boolean hasSufficientChangeForAmount(long amount) {
        boolean hasChange = true;
        try {
            getChange(amount);
        } catch (Exception ex) {
            return hasChange = false;
        }
        return hasChange;
    }

    private boolean isFullPaid() {
        if (currentBalance >= currentItem.getPrice()) {
            return true;
        }
        return false;
    }

    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

    /// <summary>
    /// Decides what coins of what denominations to return to match the amount passed as parameter
    /// </summary>
    /// <param name="amount"></param>
    /// <returns></returns>
    private List<Coin> getChange(long amount) throws Exception {
        List<Coin> changes = new ArrayList<>();

        if (amount > 0) {
            changes = new ArrayList<>();
            long balance = amount;
            while (balance > 0) {
                if (balance >= CoinEnum.QUARTER.getValue() && cashInventory.get(CoinEnum.QUARTER.getValue()) > 0) {
                    changes.add(new Coin(CoinEnum.QUARTER.getValue(), 1));
                    balance = balance - CoinEnum.QUARTER.getValue();
                } else if (balance >= CoinEnum.DIME.getValue() && cashInventory.get(CoinEnum.DIME.getValue()) > 0) {
                    changes.add(new Coin(CoinEnum.DIME.getValue(), 1));
                    balance = balance - (int) CoinEnum.DIME.getValue();
                } else if (balance >= CoinEnum.NICKLE.getValue() && cashInventory.get(CoinEnum.NICKLE.getValue()) > 0) {
                    changes.add(new Coin(CoinEnum.NICKLE.getValue(), 1));
                    balance = balance - CoinEnum.NICKLE.getValue();
                } else if (balance >= CoinEnum.PENNY.getValue() && cashInventory.get(CoinEnum.PENNY.getValue()) > 0) {
                    changes.add(new Coin(CoinEnum.PENNY.getValue(), 1));
                    balance = balance - CoinEnum.PENNY.getValue();
                } else {
                    throw new Exception("NotSufficientChange, Please try another product");
                }
            }
        }

        return changes;
    }

    /// <summary>
    /// Updates the cash inventory. Deducts the coins given as change from the inventory
    /// </summary>
    /// <param name="change"></param>
    private void updateCashInventory(List<Coin> change) {
        for (Coin c : change) {
            //cashInventory.deduct(c);
            cashInventory.put(c.getDenomination(), c.getDenomination() - c.getCount());
        }
    }


}
