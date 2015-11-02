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
public class Checking extends Account {
    
    private double overdraft = 100;
    private static final double overdraftFee = 10;
    
    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public static double getOverdraftFee() {
        return overdraftFee;
    }
    
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (this.balance < 0) {
            System.out.println("Overdraft fee of $10 applied.");
        }
    }
    

}
