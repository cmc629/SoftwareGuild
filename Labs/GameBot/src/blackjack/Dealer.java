/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Christian Choi
 */
public class Dealer {
    
    private int card1;
    private int card2;
    private int newCard;
    private int cardTotal;
    //private String choice;
    private boolean isBust; //bust or not

    public Dealer() {
        this.card1 = Card.drawCard();
        this.card2 = Card.drawCard();
        this.cardTotal = this.card1 + this.card2;
        this.isBust = false;
        System.out.println("\nThe dealer has a " + this.card1 + " showing, and a hidden card.");
        System.out.println("His total is hidden, too.");
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

    public boolean getIsBust() {
        return isBust;
    }

    public void setIsBust(boolean isBust) {
        this.isBust = isBust;
    }
    
    public void revealDealerCard() {
        System.out.println("\nOkay, dealer's turn.");
        System.out.println("His hidden card was a " + this.card2 + ".");
        System.out.println("His total was " + this.cardTotal + ".");
    }
    
    public void drawCard() {
        this.newCard = Card.drawCard();
        this.cardTotal += this.newCard;
        System.out.println("\nDealer chooses to hit.");
        System.out.println("He draws a " + this.newCard + ".");
        System.out.println("His total is " + this.cardTotal + ".");
    }
    
    public void checkBust() {
        if (this.cardTotal > 21) {
            this.isBust = true;
        } 
    }
    
    public void checkStay(int number) {
        if (number > 16 && number < 22) System.out.println("\nDealer stays.");
    }
}
