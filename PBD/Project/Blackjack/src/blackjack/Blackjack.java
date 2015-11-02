/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        System.out.println("Time to play Blackjack!");
        
        int playerCard1 = 2 + r.nextInt(10);
        int playerCard2 = 2 + r.nextInt(10);
        int playerSum = playerCard1 + playerCard2;
        System.out.println("You get a " + playerCard1 + " and " + playerCard2 + ".");
        System.out.println("Your total is " + playerSum + ".");
        
        int dealerCard1 = 2 + r.nextInt(10);
        int dealerCard2 = 2 + r.nextInt(10);
        int dealerSum = playerCard1 + playerCard2;
        System.out.println("\nThe dealer has a " + dealerCard1 + " showing, and a hidden card.");
        System.out.println("His total is hidden, too.");
        
        System.out.print("\nWould you like to hit or stay? ");
        String answer = sc.nextLine().toLowerCase();
        boolean shouldContinue = true;
        while (shouldContinue) {
            if (answer.equals("hit") || answer.equals("stay")) {
                shouldContinue = false;
            } else {
                System.out.print("Invalid input. Would you like to hit or stay? ");
                answer = sc.nextLine().toLowerCase();
            }
        }
        while (answer.equals("hit")) {
            int newCard = 2 + r.nextInt(10);
            playerSum += newCard;
            System.out.print("You drew a " + newCard + ".");
            System.out.println("\nYour total is " + playerSum + ".");
            if (playerSum > 21) {
                System.out.println("BUST! Dealer wins. YOU LOSE!");
                break;
            }

            System.out.print("\nWould you like to hit or stay? ");
            answer = sc.nextLine().toLowerCase();
            boolean playerContinue = true;
            while (playerContinue) {
                if (answer.equals("hit") || answer.equals("stay")) {
                    playerContinue = false;
                } else {
                    System.out.print("Invalid input. Would you like to hit or stay? ");
                    answer = sc.nextLine().toLowerCase();
                }
            }
        }
        
        if (playerSum <= 21) {
            System.out.println("\nOkay, dealer's turn.");
            System.out.println("His hidden card was a " + dealerCard2 + ".");
            System.out.println("His total was " + dealerSum + ".");
            
            while(dealerSum <= 16) {
                System.out.println("\nDealer chooses to hit.");
                int newDealerCard = 2 + r.nextInt(10);
                dealerSum += newDealerCard;
                if (dealerSum > 21) {
                    System.out.println("Bust for dealer! YOU WIN!");
                    break;
                }
                System.out.println("He draws a " + newDealerCard + ".");
                System.out.println("His total is " + dealerSum + ".");
            }
            if (dealerSum <= 21) {
                System.out.println("\nDealer stays.");
                System.out.println("\nDealer total is " + dealerSum + ".");
                System.out.println("Your total is " + playerSum + ".");
                if (playerSum > dealerSum) {
                    System.out.println("\nYOU WIN!");
                } else if (dealerSum > playerSum) {
                    System.out.println("\nYOU LOSE!");
                } else {
                    System.out.println("\nIt's a tie!");
                }
            }
        }
        
        
        
    }
    
}
