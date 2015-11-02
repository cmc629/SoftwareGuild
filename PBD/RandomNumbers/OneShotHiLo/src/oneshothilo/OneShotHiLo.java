/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneshothilo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class OneShotHiLo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int num = 1 + r.nextInt(100);
        System.out.println("I'm thinking of a number between 1-100. Try to guess it.");
        int guess = Integer.parseInt(sc.nextLine());
        
        if (num == guess) {
            System.out.println("You guessed it! What are the odds?!?");
        } else if (guess >= num) {
            System.out.println("Sorry, you are too high. I was thinking of " + num);
        } else {
            System.out.println("Sorry, you are too low. I was thinking of " + num);
        }
        
    }
    
}
