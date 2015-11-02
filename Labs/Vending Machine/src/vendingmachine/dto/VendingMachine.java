/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import vendingmachine.items.Item;

/**
 *
 * @author apprentice
 */
public class VendingMachine {

    private final Map<Item, Integer> items;
    private int availableMoney = 0;

    public VendingMachine(Map<Item, Integer> items) {
        this.items = new TreeMap<>((Item o1, Item o2) -> o1.getName().compareTo(o2.getName()));
        this.items.putAll(items);
    }

    VendingMachine() {
        items = new TreeMap<>();
    }

    public Map<Item, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public void addMoney(double amountIn) {
        availableMoney += (int) (amountIn * 100);
    }

    /**
     * Attempts to vend the item. If the machine has the item, has at least one
     * available and available money is greater than or equal to the cost of the
     * item, the item is vended.
     *
     * @param item
     * @return true if the item was vended
     */
    public boolean vendItem(Item item) {
        if (item.getCostInPennies() > availableMoney || !items.containsKey(item) || items.get(item) <= 0) {
            return false;
        }
        items.put(item, items.get(item) - 1);
        availableMoney -= item.getCostInPennies();
        return true;
    }

    public double getAvailableMoney() {
        return ((double) availableMoney) / 100;
    }

    public Change dispenseChange() {
        return new Change(availableMoney);
    }
}
