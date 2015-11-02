/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.items.Item;

/**
 *
 * @author apprentice
 */
public class VendingMachineTest {

    Item candy;
    VendingMachine machine;

    public VendingMachineTest() {
    }

    @Before
    public void setUp() {
        Map<Item, Integer> items = new HashMap<>();
        candy = new Item("Skittles", 100);
        items.put(candy, 1);
        machine = new VendingMachine(items);
    }

    @Test
    public void testAddMoney() {
        machine.addMoney(100);
        assertEquals(machine.getAvailableMoney(), 100, .1);
    }

    @Test
    public void testVendItem() {
        machine.addMoney(100);
        assertTrue(machine.vendItem(candy));
    }

    @Test
    public void testVendWithoutMoney() {
        assertFalse(machine.vendItem(candy));
    }

    @Test
    public void testVendNonexistantItem() {
        assertFalse(machine.vendItem(new Item("Butterfinger", 0)));
    }

    @Test
    public void testVendOutOfStockItem() {
        machine.addMoney(100);
        machine.addMoney(100);
        assertTrue(machine.vendItem(candy));
        assertFalse(machine.vendItem(candy));
    }

    @Test
    public void testDispenseChange() {
        machine.addMoney(100);
        assertEquals(machine.dispenseChange(), new Change(10_000));
    }

    @Test
    public void testGetAvailableMoney() {
        assertEquals(machine.getAvailableMoney(), 0.00, .001);
        machine.addMoney(1.00);
        assertEquals(machine.getAvailableMoney(), 1.00, .001);
    }

}
