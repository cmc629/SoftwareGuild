/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

/**
 *
 * @author apprentice
 */
public class Change {

    private final int pennies;
    private final int nickels;
    private final int dimes;
    private final int quarters;

    public int getPennies() {
        return pennies;
    }

    public int getNickels() {
        return nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public int getQuarters() {
        return quarters;
    }

    public boolean isEmpty() {
        return quarters == 0 && dimes == 0 && nickels == 0 && pennies == 0;
    }

    public Change(int availableMoney) {
        quarters = availableMoney / 25;
        availableMoney -= quarters * 25;
        dimes = availableMoney / 10;
        availableMoney -= dimes * 10;
        nickels = availableMoney / 5;
        availableMoney -= nickels * 5;
        pennies = availableMoney;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.pennies;
        hash = 83 * hash + this.nickels;
        hash = 83 * hash + this.dimes;
        hash = 83 * hash + this.quarters;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Change other = (Change) obj;
        if (this.pennies != other.pennies) {
            return false;
        }
        if (this.nickels != other.nickels) {
            return false;
        }
        if (this.dimes != other.dimes) {
            return false;
        }
        if (this.quarters != other.quarters) {
            return false;
        }
        return true;
    }

}
