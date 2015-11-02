/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primefinder;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class PrimeFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        boolean isRunning = true;
        
        while (isRunning) {
            
            int num = 0;
            boolean shouldContinue = true;
            num = isValidNumber(shouldContinue, num);

            System.out.println("Searching for prime numbers...");

            int primeCount = 0;
            for (int count = 1; count <= num; count++) {
                int numSum = 0;
                primeCount = findPrimeNumbers(count, numSum, num, primeCount);
            }

            System.out.println("The number of prime numbers found between 0 and " +
                    num + " is: " + primeCount + ".");
            
                
            isRunning = playAgain(isRunning);         
        }
            
    }
    
    
    public static boolean playAgain(boolean isRunning) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Would you like to run again? Yes/No ");
        String answer = sc.next().toLowerCase();
        switch (answer) {
            case "yes":
                System.out.println("Rerunning program...");
                break;
            case "no":
                System.out.println();
                isRunning = false;
                return isRunning;
            default:
                System.out.println("Invalid Input!");
                playAgain(isRunning);
        }
        return isRunning;
    }
    
    
    public static int findPrimeNumbers(int count, int numSum, int num, int primeCount) {
        for (int factor = 1; factor <= count / 2; factor ++) {
            if (count % factor == 0) {
                numSum += factor;
            }
        }
        if (num != 1 && numSum == 1) {
            System.out.println(count);
            primeCount += 1;
        }
        return primeCount;
    }

    public static int isValidNumber(boolean shouldContinue, int num) {
        Scanner sc = new Scanner(System.in);
        while (shouldContinue) {
            System.out.print("Please enter a number and a list numbers between" +
                    " 0 and the number that are prime will be printed: ");
            num = sc.nextInt();
            if (num < 0) {
                System.out.println("Invalid input! Please try again.");
            }
            else {
                shouldContinue = false;
            }
        }
        return num;
    }
    
}
