/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Christian Choi
 */
public class Account {
    
    protected double balance;
    protected double unclearedBalance;
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getUnclearedBalance() {
        return unclearedBalance;
    }

    public void setUnclearedBalance(double unclearedBalance) {
        this.unclearedBalance = unclearedBalance;
    }
    
//    public boolean checkValidWithdraw(double amount) {
//        if (this.balance < amount) {
//            return false;
//        }
//        return true;
//    }
    
    public void deposit(double amount) {
        if (amount <= 10000) {
            this.balance += amount;
        }
        if (amount > 10000) {
            System.out.println("Bank manager contacted to clear deposit.");
            this.unclearedBalance += amount;
        }
    }
    
    public void withdraw(double amount) {
        this.balance -= amount;
    }
    
}
