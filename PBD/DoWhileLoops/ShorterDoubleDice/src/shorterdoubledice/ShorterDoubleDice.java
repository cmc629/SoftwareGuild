/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorterdoubledice;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class ShorterDoubleDice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r = new Random();
        
        System.out.println("HERE COMES THE DICE!");
        int dice1, dice2;
        
        do {
            dice1 = 1 + r.nextInt(6);
            dice2 = 1 + r.nextInt(6);
            System.out.println("\nRoll #1: " + dice1);
            System.out.println("Roll #2: " + dice2);
            System.out.println("The total is " + (dice1 + dice2) + "!");
        } while (dice1 != dice2);
        
    }
    
}
