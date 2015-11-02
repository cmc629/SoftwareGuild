/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        float initialPrincipal = getFloatInput("initial principal");
        float annualIR = getFloatInput("annual interest rate");
        int year = getIntInput("number of years");
        
        boolean shouldContinue = true;
        int compound = 0; //Number corresponding to quarterly (4), monthly (12), or daily (365)    
        
        //Check for quarterly, monthly, and daily inputs. If invalid, retype.
        while (shouldContinue) {
            compound = getCompoundValue();
            if (compound == 4 || compound == 12 || compound == 365) {
                shouldContinue = false;
            }
        }
        
        float currentBalance = initialPrincipal; //set current balance to initial principal
        float totalInterest;
        int yrCount = 1;
        
        while (yrCount <= year) {
            int compoundCount = 1;
            currentBalance = getCurrentBalance(compoundCount, compound, currentBalance, annualIR);
            
            totalInterest = currentBalance - initialPrincipal;
            
            System.out.println("During Year " + yrCount + 
                    ", Initial Balance: $" + String.format("%.2f", initialPrincipal)+ 
                    ", Total Interest Earned: $" + String.format("%.2f", totalInterest) +
                    ", and Ending Balance: $" + String.format("%.2f", currentBalance));
            
            yrCount += 1;
            initialPrincipal = currentBalance; //Set the initial principal to the ending balance as you loop into the next year
            
        }
    }

    public static float getCurrentBalance(int compoundCount, int compound, float currentBalance, float annualIR) {
        while(compoundCount <= compound) {
            currentBalance += currentBalance * (annualIR / compound / 100);
            compoundCount += 1;
        }
        return currentBalance;
    }
    
    public static float getFloatInput(String initialOrInterest) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter the " + initialOrInterest + ": ");
        String stringInput = sc.next();
        
        float floatInput = Float.parseFloat(stringInput);
        
        return floatInput;
    }
    
    public static int getIntInput(String year) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter the " + year + ": ");
        String stringInput = sc.next();
        
        int intInput = Integer.parseInt(stringInput);
        
        return intInput;
    }
    
    public static int getCompoundValue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter quarterly, monthly, or daily: ");
        String stringCompound = sc.next();
        int compound = compoundStringToInt(stringCompound);
        return compound;  
    }
    
    public static int compoundStringToInt(String stringCompound) {
        int compound = 0;
        switch (stringCompound) {
            case "quarterly":
                compound = 4;
                break;
            case "monthly":
                compound = 12;
                break;
            case "daily":
                compound = 365;
                break;
            default:
                System.out.print("Invalid input. ");
        }
        return compound;
    }
    
}
