/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Player {
    
    private int card1;
    private int card2;
    private int newCard;
    private int cardTotal;
    private String choice; //choose hit or stay
    private boolean isBust; //bust or not

    public Player() {
        this.card1 = Card.drawCard();
        this.card2 = Card.drawCard();
        this.cardTotal = this.card1 + this.card2;
        this.isBust = false;
        System.out.println("\nYou get a " + this.card1 + " and " + this.card2 + ".");
        System.out.println("Your total is " + this.cardTotal + ".");
    }
    
    public int getCard1() {
        return card1;
    }

    public void setCard1(int card1) {
        this.card1 = card1;
    }

    public int getCard2() {
        return card2;
    }

    public void setCard2(int card2) {
        this.card2 = card2;
    }

    public int getNewCard() {
        return newCard;
    }

    public void setNewCard(int newCard) {
        this.newCard = newCard;
    }

    public int getCardTotal() {
        return cardTotal;
    }

    public void setCardTotal(int cardTotal) {
        this.cardTotal = cardTotal;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public boolean getIsBust() {
        return isBust;
    }

    public void setIsBust(boolean isBust) {
        this.isBust = isBust;
    }

    
    public void drawCard(boolean isHit) {
        if (isHit) {
            this.newCard = Card.drawCard();
            this.cardTotal += this.newCard;
            System.out.println("You drew a " + this.newCard + ".");
            System.out.println("Your total is " + this.cardTotal + ".");
        }
    }
    
    public void checkBust() {
        if (this.cardTotal > 21) {
            this.isBust = true;
        } 
    }
    
}
