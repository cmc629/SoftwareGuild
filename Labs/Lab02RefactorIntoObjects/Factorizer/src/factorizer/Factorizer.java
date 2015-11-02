/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorizer;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Factorizer {
    
    private int number;
    private int[] factorArray;
    private int factorSum;

    public Factorizer() {
        this.number = getNumToFactor();
        this.factorArray = this.createFactorArray(this.number, this.getFactorArrayLength(this.number));
        this.factorSum = generateFactorSum(this.number);
    }
    
    public Factorizer(int number) {
        this.number = number;
        this.factorArray = this.createFactorArray(this.number, this.getFactorArrayLength(this.number));
        this.factorSum = generateFactorSum(this.number);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int[] getFactorArray() {
        return factorArray;
    }

    public void setFactorArray(int[] factorArray) {
        this.factorArray = factorArray;
    }

    public int getFactorSum() {
        return factorSum;
    }

    public void setFactorSum(int factorSum) {
        this.factorSum = factorSum;
    }
    
    public void run() {
        
        System.out.println("The factors of " + this.number + " are:");
        
        printFactors(this.factorArray);     
        
        boolean isPerfect = isPerfect(this.number, this.factorSum);
        boolean isPrime = isPrime(this.number, this.factorSum);
        printIfPerfect(this.number, isPerfect);
        printIfPrime(this.number, isPrime);    
                      
    }
    
    public static int getNumToFactor() {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.print("What number would you like to factor? ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.");
            number = getNumToFactor();
        }
        else {
            String stringNumber = sc.next();
            number = Integer.parseInt(stringNumber);
        }
        return number;
    }
    
    public int getFactorArrayLength(int number) {
        int length = 0;
        for (int factor = 1; factor <= number / 2; factor++) {
            if (number % factor == 0) {
                length++;
            }
        }
        return length;
    }
    
    public int[] createFactorArray(int number, int length) {
        int[] factorArr = new int[length];
        int index = 0;
        while (index < length) {
            int factor = 1;
            while (factor <= number / 2) {
                if (number % factor == 0) {
                    factorArr[index] = factor;
                    index += 1;
                    factor += 1;
                }
                else {
                    factor += 1;
                }
            }
        }
        return factorArr;    
    }
    
    public void printFactors(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    public int generateFactorSum(int number) {
        int factorsum = 0;
        
        for (int factor = 1; factor <= number / 2; factor++) {
            if (number % factor == 0) {
                factorsum += factor;
            }
        }
        return factorsum;
    }
    
    public boolean isPerfect(int number, int factorSum) {
        if (number == 1) {
            return false;
        } else {
            return factorSum == number;
        }
    }
    
    public boolean isPrime(int number, int factorSum) {
        if (number == 1) {
            return false;
        } else {
            return factorSum == 1;
        }
    }
    
    public void printIfPerfect(int number, boolean isPerfect) {
        if (isPerfect) {
            System.out.println(number + " is a perfect number.");
        } else {
            System.out.println(number + " is not a perfect number.");
        }
    }
    
    public void printIfPrime(int number, boolean isPrime) {
        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
}
