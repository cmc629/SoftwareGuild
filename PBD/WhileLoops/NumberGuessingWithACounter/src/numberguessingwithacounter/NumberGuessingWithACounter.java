/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessingwithacounter;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class NumberGuessingWithACounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int random = 1 + r.nextInt(10);
        
        System.out.println("I have chose a number between 1 and 10. Try to guess it.");
        System.out.print("Your guess: ");
        int guess = Integer.parseInt(sc.nextLine());
        int tries = 1;
        while (random != guess) {
            System.out.println("That is incorrect. Guess again.");
            System.out.print("Your guess: ");
            guess = Integer.parseInt(sc.nextLine());
            tries += 1;
        }
        System.out.println("That's right! You're a good guesser.");
        System.out.println("It only took you " + tries + " tries.");
    }
    
}
