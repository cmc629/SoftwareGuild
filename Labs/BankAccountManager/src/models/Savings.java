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
public class Savings extends Account {    
    
    private static final double withdrawalPenalty = 15;
    
    public void withdraw(double amount) {
        this.balance -= (amount + withdrawalPenalty);
    }
    
}
