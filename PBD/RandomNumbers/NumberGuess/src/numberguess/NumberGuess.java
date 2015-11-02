/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguess;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class NumberGuess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int secretNum = 1 + r.nextInt(10);
        
        System.out.println("I'm thinking of a number from 1 to 10.");
        System.out.print("Your guess: ");
        int guess = Integer.parseInt(sc.nextLine());

        if (guess == secretNum) {
            System.out.println("\nThat's right! My secret number was "+ secretNum + "!");
        } else {
            System.out.println("\nSorry, but I was really thinking of " + secretNum + "!");
        }
        
    }
    
}
