/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilolimited;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class HiLoLimited {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int random = 1 + r.nextInt(100);
        int numGuess = 1;
        
        System.out.println("I'm thinking of a number between 1-100. You have 7 guesses.");
        System.out.print("First guess: ");
        int guess = Integer.parseInt(sc.nextLine());
        while (guess != random && numGuess <= 7) {
            if (guess < random) {
                System.out.println("Sorry, you are too low.");
                System.out.print("Guess # " + numGuess + ": ");
                guess = Integer.parseInt(sc.nextLine());
                numGuess++;
            } else {
                System.out.println("Sorry, you are too high.");
                System.out.print("Guess # " + numGuess + ": ");
                guess = Integer.parseInt(sc.nextLine());
                numGuess++;
            }
        }
        if (numGuess <= 7) {
            System.out.println("You guessed it! What are the odds?!?");
        } else {
            System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");
        }
    }
    
}
