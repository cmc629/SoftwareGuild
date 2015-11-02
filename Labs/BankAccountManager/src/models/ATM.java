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
public class ATM {
    
    private int pin = 1234;
    private Checking checkingAccount = new Checking();
    private Savings savingsAccount = new Savings();
    

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Checking getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(Checking checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public Savings getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(Savings savingsAccount) {
        this.savingsAccount = savingsAccount;
    }
    
    
}
