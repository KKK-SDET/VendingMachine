package services;

import domain.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory
{
    //Map of (domain.Item, Qty)
    private Map<Item, Integer> inventory = new HashMap<Item, Integer>();


    /// <summary>
    /// Returns the quantity held for the given item
    /// </summary>
    /// <param name="item"></param>
    /// <returns></returns>
    public int getQuantity(Item item)
    {
        return inventory.getOrDefault(item,0) ;
    }
    public void add(Item item)
    {
        inventory.put(item, inventory.getOrDefault(item,0)+1);
    }
    /// <summary>
    /// Removes the item from the inventory
    /// </summary>
    /// <param name="item"></param>
    public void deduct(Item item)
    {
        if (inventory.containsKey(item))
        {
            inventory.put(item, inventory.get(item) - 1);
        }
    }

    /// <summary>
    /// Check by name if the inventory has the item
    /// </summary>
    /// <param name="name"></param>
    /// <returns></returns>
    public boolean hasItemByName(String name)
    {
        return inventory.keySet().stream().anyMatch(i -> i.getName().equals(name));
    }
    /// <summary>
    /// Gets item by name
    /// </summary>
    /// <param name="name"></param>
    /// <returns></returns>

    public Item getItemByName(String name)
    {
        return inventory.keySet().stream().filter(i -> i.getName().equals(name)).findAny().get();
    }
    /// <summary>
    /// Clears inventory
    /// </summary>
    public void clear(){ inventory.clear(); }
    /// <summary>
    /// Adds item with given quantity to inventory
    /// </summary>
    /// <param name="item"></param>
    /// <param name="quantity"></param>
    public void put(Item item, int quantity) { inventory.put(item, quantity); } }
