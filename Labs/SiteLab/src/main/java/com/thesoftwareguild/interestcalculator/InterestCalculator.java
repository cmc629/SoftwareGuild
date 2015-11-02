/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.interestcalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalculator {

    private float initialPrincipal;
    private float annualInterestRate;
    private int year;
    private int compound;

    public InterestCalculator() {
        this.initialPrincipal = getFloatInput("initial principal");
        this.annualInterestRate = getFloatInput("annual interest rate");
        this.year = getIntInput("number of years");
        this.compound = checkValidCompound(); //had error? to get it again un-set the method from final
    }
    
    public InterestCalculator(float initial, float rate, int year, int compound) {
        this.initialPrincipal = initial;
        this.annualInterestRate = rate;
        this.year = year;
        this.compound = compound;
    }

    public float getInitialPrincipal() {
        return initialPrincipal;
    }

    public void setInitialPrincipal(float initialPrincipal) {
        this.initialPrincipal = initialPrincipal;
    }

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public int getCompound() {
        return compound;
    }
    
    public void setCompound(int compound) {
        this.compound = compound;
    }
        
    public void run() {
        
        float currentBalance = this.initialPrincipal; //set current balance to initial principal
        float totalInterest;
        int yrCount = 1;
        
        while (yrCount <= year) {
            int compoundCount = 1;
            
            currentBalance = getCurrentBalance(compoundCount, this.compound, currentBalance, this.annualInterestRate);
            totalInterest = currentBalance - this.initialPrincipal;
            printInfo(yrCount, totalInterest, currentBalance);

            this.initialPrincipal = currentBalance; //Set the initial principal to the ending balance as you loop into the next year
            yrCount += 1;
        }
    }

    public void printInfo(int yrCount, float totalInterest, float currentBalance) {
        //System.out.println(currentBalance);
        System.out.println("During Year " + yrCount + ", Initial Balance: $" +
                String.format("%.2f", this.initialPrincipal)+ ", Total Interest Earned: $" +
                String.format("%.2f", totalInterest) + ", and Ending Balance: $" +
                String.format("%.2f", currentBalance));
    }
    
    public final float getFloatInput(String initialOrInterest) {
        Scanner sc = new Scanner(System.in);
        float floatInput;
        System.out.print("Please enter the " + initialOrInterest + ": ");
        if (!sc.hasNextFloat()) {
            System.out.println("Invalid Input.");
            floatInput = getFloatInput(initialOrInterest);
        }
        else {
            String stringInput = sc.next();
            floatInput = Float.parseFloat(stringInput);
        }
        return floatInput;
    }
    
    public final int getIntInput(String year) {
        Scanner sc = new Scanner(System.in);
        int intInput;
        System.out.print("Please enter the " + year + ": ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid Input.");
            intInput = getIntInput(year);
        }
        else {
            String stringInput = sc.next();
            intInput = Integer.parseInt(stringInput);
        }
        return intInput;
    }
    
    public final int checkValidCompound() {
        boolean shouldContinue = true;
        int compoundNumber = 0; //Number corresponding to quarterly (4), monthly (12), or daily (365)    
        //Check for quarterly, monthly, and daily inputs. If invalid, retype.
        while (shouldContinue) {
            compoundNumber = getCompoundValue();
            if (compoundNumber == 4 || compoundNumber == 12 || compoundNumber == 365) {
                shouldContinue = false;
            }
        }
        return compoundNumber;
    }

    public float getCurrentBalance(int compoundCount, int compound, float currentBalance, float annualIR) {
        while(compoundCount <= compound) {
            currentBalance += currentBalance * (annualIR / compound / 100);
            compoundCount += 1;
        }
        return currentBalance;
    }   

    public int getCompoundValue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter quarterly, monthly, or daily: ");
        String stringCompound = sc.next();
        int compoundNumber = compoundStringToInt(stringCompound);
        return compoundNumber;  
    }
    
    public int compoundStringToInt(String stringCompound) {
        int compoundNumber = 0;
        switch (stringCompound) {
            case "quarterly":
                compoundNumber = 4;
                break;
            case "monthly":
                compoundNumber = 12;
                break;
            case "daily":
                compoundNumber = 365;
                break;
            default:
                System.out.print("Invalid input. ");
        }
        return compoundNumber;
    }
    
}
