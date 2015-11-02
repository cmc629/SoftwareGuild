/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.items;

/**
 *
 * @author apprentice
 */
public class Item {

    private final String name;
    private final int costInPennies;

    public Item(String name, int costInPennies) {
        this.name = name;
        this.costInPennies = costInPennies;
    }

    public String getName() {
        return name;
    }

    public int getCostInPennies() {
        return costInPennies;
    }

}
