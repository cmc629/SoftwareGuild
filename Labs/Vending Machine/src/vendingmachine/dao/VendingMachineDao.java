/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import vendingmachine.items.Item;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author apprentice
 */
public class VendingMachineDao {

    private static final String itemDescriptions = "items.txt";
    private static final String itemQuantities = "quantities.txt";

    public Map<Item, Integer> readItems() {
        Map<Item, Integer> items = new HashMap<>();
        File itemsFile = new File(itemDescriptions);
        File quantityFile = new File(itemQuantities);
        try {
            //Populate items
            Scanner in = new Scanner(itemsFile);
            in.useDelimiter("[,\n]");
            while (in.hasNext()) {
                items.put(new Item(in.next(), in.nextInt()), 0);
            }
            //Populate quantities
            Map<String, Integer> quantities = new HashMap<>();
            in = new Scanner(quantityFile);
            in.useDelimiter("[,\n]");
            while (in.hasNext()) {
                quantities.put(in.next(), in.nextInt());
            }

            for (Item item : items.keySet()) {
                items.put(item, quantities.getOrDefault(item.getName(), 0));
            }

        } catch (IOException ex) {
            System.err.println("There was an error reading from the file.");
        }
        return items;
    }

    public void writeItems(Map<Item, Integer> items) {
        File quantityFile = new File(itemQuantities);
        PrintWriter itemWriter;
        try {
            itemWriter = new PrintWriter(quantityFile);
            for (Item item : items.keySet()) {
                itemWriter.println(String.format("%s,%d", item.getName(), items.get(item)));
            }
            itemWriter.flush();
        } catch (FileNotFoundException ex) {
            System.err.println("There was an error writing to the disk.");
        }
    }
}
