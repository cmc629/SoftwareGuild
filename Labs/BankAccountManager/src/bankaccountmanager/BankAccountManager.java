/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountmanager;

import models.ATM;
import models.Checking;
import ui.ConsoleIO;

/**
 *
 * @author Christian Choi
 */
public class BankAccountManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ATM atm = new ATM();
        ConsoleIO io = new ConsoleIO();
        
        int pinNumber = io.promptInt("Please enter your PIN: ");
        if (pinNumber != atm.getPin()) {
            io.println("Incorrect PIN! Goodbye!");
        }
        else {
            boolean isRunning = true;
            while(isRunning) {
                io.println(String.format("\nChecking Account Balance: $%s", atm.getCheckingAccount().getBalance()));
                io.println(String.format("Savings Account Balance: $%s", atm.getSavingsAccount().getBalance()));
                String option = io.promptString("\nPlease select an account ('checking' or 'savings') or enter 'quit': ");
                if (option.equals("checking")) {
                    String choice = io.promptString("\nWould you like to deposit or withdraw? ");
                    if (choice.equals("deposit")) {
                        double amount = io.promptDouble("\nHow much would you like to deposit? ", 0, Double.POSITIVE_INFINITY);
                        atm.getCheckingAccount().deposit(amount);
                        io.println(String.format("$%s was deposited in your checking account.", amount));
                    }
                    if (choice.equals("withdraw")) {
                        double amount = io.promptDouble("\nHow much would you like to withdraw? ", 0, atm.getCheckingAccount().getBalance() + atm.getCheckingAccount().getOverdraft());
                        atm.getCheckingAccount().withdraw(amount);
                        if (atm.getCheckingAccount().getBalance() < 0) {
                            atm.getSavingsAccount().setBalance(atm.getSavingsAccount().getBalance() - Checking.getOverdraftFee());
                        } else {
                            io.println(String.format("$%s was withdrawn from your checking account.", amount));
                        }
                    }
                }
                if (option.equals("savings")) {
                    String choice = io.promptString("\nWould you like to deposit or withdraw? ");
                    if (choice.equals("deposit")) {
                        double amount = io.promptDouble("\nHow much would you like to deposit? ", 0, 10000);
                        atm.getSavingsAccount().deposit(amount);
                        io.println(String.format("$%s was deposited in your savings account.", amount));
                    }
                    if (choice.equals("withdraw")) {
                        double amount = io.promptDouble("\nHow much would you like to withdraw? ", 0, atm.getSavingsAccount().getBalance());
                        atm.getSavingsAccount().withdraw(amount);
                        io.println(String.format("$%s was withdrawn from your savings account.", amount));
                    }
                }
                if (option.equals("quit")) {
                    isRunning = false;
                    io.println("Thank you! Have a nice day!");
                }
            }
        }
        
        
    }
    
}
