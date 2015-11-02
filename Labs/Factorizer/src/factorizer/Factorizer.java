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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int number = numToFactor();
        
        System.out.println("The factors of " + number + " are:");
        
        int factorsum = 0;
        
        for (int factor = 1; factor <= number / 2; factor++) {
            if (number % factor == 0) {
                System.out.println(factor);
                factorsum += factor;
            }
        }
        
        printIfPerfect(number, factorsum);
        printIfPrime(number, factorsum);    
                      
    }
    
    public static int numToFactor() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What number would you like to factor? ");
        String stringNumber = sc.next();
        
        int number = Integer.parseInt(stringNumber);
        
        return number;
    }
    
    public static void printIfPerfect(int number, int factorsum) {
        if (number == 1) {
            System.out.println("1 is not a perfect number.");
        } else if (factorsum == number) {
            System.out.println("" + number + " is a perfect number.");
        } else {
            System.out.println("" + number + " is not a perfect number.");
        }
    }
    
    public static void printIfPrime(int number, int factorsum) {
        if (number == 1) {
            System.out.println("1 is not a prime number.");
        } else if (factorsum == 1) {
            System.out.println("" + number + " is a prime number.");
        } else {
            System.out.println("" + number + " is not a prime number.");
        }
    }
}
