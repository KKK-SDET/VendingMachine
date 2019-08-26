import domain.*;
import org.junit.Before;
import org.junit.Test;
import services.Inventory;
import services.VendingMachine;
import java.util.List;

import static org.junit.Assert.*;

/**
 * <summary>
 * This class is for VendingMachine and Inventory classes unit testing
 * WhiteBox testing type
 * </summary>
 */
public class VendingMachineTest {

    VendingMachine vm;
    Inventory inventory;
    Item item;
    Coin coin;

    /**
     * <summary>
     * init() method initializes classes of domain and services packages
     * </summary>
     */
    @Before
    public void init() {
        vm = new VendingMachine();
        inventory = new Inventory();
        item = new Item(ItemEnum.COKE.toString(), ItemEnum.COKE.getValue());
        coin = new Coin(CoinEnum.QUARTER.getValue(), 1);
    }

    /**
     * <summary>
     * This is a method to test if Vending Machine is empty
     * </summary>
     */
    @Test
    public void isVMisLoaded() {
        assertFalse("VM is loaded", inventory.hasItemByName(ItemEnum.PEPSI.toString()));
    }

    /**
     * <summary>
     * This is a method to test getQuantity() method in Inventory class
     * </summary>
     */
    @Test
    public void testGetQuantity() {
        assertFalse("the vending machine is loaded",inventory.hasItemByName(item.getName()));
        inventory.put(item, 1);
        assertEquals("item is not in the vending machine", 1, inventory.getQuantity(item));
    }

    /**
     * <summary>
     * This is a method to test getAdd() method in Inventory class
     * </summary>
     */
    @Test
    public void testAdd() {
        inventory.add(item);
        assertTrue("Item was not added", inventory.hasItemByName(item.getName()));
    }

    /**
     * <summary>
     * This is a method to test getPut() method in Inventory class
     * </summary>
     */
    @Test
    public void testPut() {
        inventory.put(item, 1);
        assertEquals("Item is not in inventory", 1, inventory.getQuantity(item));
    }

    /**
     * <summary>
     * This is a method to test getDeduct() method in Inventory class
     * </summary>
     */
    @Test
    public void testDeduct() {
        inventory.add(item);
        assertTrue("Item was not added", inventory.hasItemByName(item.getName()));
        inventory.deduct(item);
        assertEquals("item was not deducted", 0, inventory.getQuantity(item));
    }

    /**
     * <summary>
     * This is a method to test hasItemByName() method in Inventory class
     * </summary>
     */
    @Test
    public void testHasItemByName() {
        inventory.add(item);
        assertTrue("inventory has no such item", inventory.hasItemByName(item.getName()));
    }

    /**
     * <summary>
     * This is a method to test getItemByName() method in Inventory class
     * </summary>
     */
    @Test
    public void testGetItemByName() {
        inventory.put(item, 1);
        assertEquals("there is no such item in inventory",
                item, inventory.getItemByName(item.getName()));
    }

    /**
     * <summary>
     * This is a method to test clear() method in Inventory class
     * </summary>
     */
    @Test
    public void testClearInventory() {
        inventory.put(item, 1);
        assertTrue("inventory has no such item", inventory.hasItemByName(item.getName()));
        inventory.clear();
        assertFalse("inventory was not cleared",inventory.hasItemByName(item.getName()));
    }

    /**
     * <summary>
     * This is a method to test selectItemAndGetPrice() method in Inventory class
     * </summary>
     */
    @Test
    public void testSelectItemAndGetPrice() throws Exception {
        inventory.put(item, 1);
        assertTrue("inventory has no such item",
                inventory.hasItemByName(item.getName()));
        assertEquals(item.getPrice(), vm.selectItemAndGetPrice(item.getName()));
    }

    /**
     * <summary>
     * This is a method to test insertCoin() method in VendingMachine class
     * </summary>
     */
    @Test
    public void testInsertCoin() throws Exception {
        vm.insertCoin(coin);
        List<Coin> list = vm.refund();
        assertEquals("VM has no such denomination",
                coin.getDenomination(), list.get(0).denomination);
    }

    /**
     * <summary>
     * This is a method to test refund() method in VendingMachine class
     * </summary>
     */
    @Test
    public void testRefund() throws Exception {
        Coin coin1 = new Coin(CoinEnum.DIME.getValue(), 1);
        vm.insertCoin(coin);
        vm.insertCoin(coin1);
        List<Coin> list = vm.refund();
        assertEquals("Wrong denomination coin was refunded",
                coin.getDenomination()+coin1.getDenomination(),
                list.get(0).denomination+list.get(1).denomination);
    }

    /**
     * <summary>
     * This is a method to test collectItemAndChange() method in VendingMachine class
     * </summary>
     */
    @Test
    public void testCollectItemAndChange() throws Exception {
        inventory.put(item, 1);
        assertTrue("Vending machine is empty", inventory.hasItemByName(item.getName()));
        vm.insertCoin(coin);
        vm.selectItemAndGetPrice(item.toString());
        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
        Item item1 = bucket.getFirst();
        List<Coin> change = bucket.getSecond();
        assertEquals("Item was not dispensed", item.getName(), item1.getName());
        assertTrue("change was given by mistake", change.isEmpty());
    }
}
