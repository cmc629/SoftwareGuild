/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worstguessing;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class WorstGuessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int secretNum = 6;
        
        System.out.println("THE WORST GUESSING GAME EVER!!!!!!");
        System.out.print("\nIM THINKING OF A NUMBER BETWEEN 1-10. TRY TO GUESS! ");
        int guess = Integer.parseInt(sc.nextLine());

        if (guess == secretNum) {
            System.out.println("\nLOL YOU GOT IT! I CANT BELIEVE YOU GUESSED IT WAS "+ secretNum + "!");
        } else {
            System.out.println("\nWOW YOU SUCK! I DESTROYED YOU. THE NUMBER WAS " + secretNum + "!");
        }
        
    }
    
}
