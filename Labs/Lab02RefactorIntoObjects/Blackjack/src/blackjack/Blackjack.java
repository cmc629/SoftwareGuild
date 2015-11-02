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
    
    private Player player;
    private Dealer dealer;
    private boolean playerHit = true;
    private boolean playAgain = true;

    public Blackjack() {
        
    }
    
    public Blackjack(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public boolean isPlayerHit() {
        return playerHit;
    }

    public void setPlayerHit(boolean playerHit) {
        this.playerHit = playerHit;
    }

    public boolean isPlayAgain() {
        return playAgain;
    }

    public void setPlayAgain(boolean playAgain) {
        this.playAgain = playAgain;
    }
    
    
    public void play() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Time to play Blackjack!");
        
        this.player = new Player();
        this.dealer = new Dealer();
        
        
        while (this.player.getCardTotal() <= 21 && this.playerHit) {
            this.player.setChoice(askPlayerOption());
            this.playerHit = checkPlayerHit(this.player.getChoice());
            this.player.drawCard(this.playerHit);
            this.player.checkBust();
            if (this.player.getIsBust()) System.out.println("\nBUST! Dealer wins.");
        }
        if (!this.player.getIsBust() && this.dealer.getCardTotal() <= 21) {
            this.dealer.revealDealerCard();
            
            if (this.dealer.getCardTotal() > 16) {
                this.dealer.checkStay(this.dealer.getCardTotal());
            }
            
            while(this.dealer.getCardTotal() <= 16) {
                this.dealer.drawCard();
                this.dealer.checkBust();
                if(this.dealer.getIsBust()) System.out.println("\nBUST! Player wins.");
                this.dealer.checkStay(this.dealer.getCardTotal());
            }
        }
        if (!this.player.getIsBust() && !this.dealer.getIsBust()) {
            printResults(this.dealer.getCardTotal(), this.player.getCardTotal());
        }
    }        
    
    public String askPlayerOption() {
        
        Scanner sc = new Scanner(System.in);
        
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
        return answer;
    }
    
    public boolean checkPlayerHit(String answer) {
        return (answer.equals("hit"));
    }
    
    public void printResults(int num1, int num2) {
        System.out.println("\nDealer total is " + num1 + ".");
        System.out.println("Your total is " + num2 + ".");
        if (num2 > num1) {
            System.out.println("\nYOU WIN!");
        } else if (num1 > num2) {
            System.out.println("\nYOU LOSE!");
        } else {
            System.out.println("\nIt's a tie!");
        }
    }
    
}
