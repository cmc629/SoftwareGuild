/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyblackjack;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class BabyBlackjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r = new Random();
        
        int playerCard1 = 1 + r.nextInt(10);
        int playerCard2 = 1 + r.nextInt(10);
        int dealerCard1 = 1 + r.nextInt(10);
        int dealerCard2 = 1 + r.nextInt(10);
        int playerSum = playerCard1 + playerCard2;
        int dealerSum = dealerCard1 + dealerCard2;;
        
        System.out.println("Baby Blackjack!\n");
        System.out.println("You drew " + playerCard1 + " and " + playerCard2 + ".");
        System.out.println("Your total is " + playerSum + ".");
        
        System.out.println("\nThe dealer drew " + dealerCard1 + " and " + dealerCard2 + ".");
        System.out.println("Dealer's total is " + dealerSum + ".");
        
        if (playerSum > dealerSum) {
            System.out.println("\nYOU WIN!");
        } else if (playerSum == dealerSum) {
            System.out.println("\nIT'S A TIE!");
        } else {
            System.out.println("\nYOU LOSE!");
        }
        
    }
    
}
