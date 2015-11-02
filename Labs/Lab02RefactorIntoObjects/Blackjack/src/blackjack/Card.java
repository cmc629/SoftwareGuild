/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class Card {
    
    public static int drawCard() {
        Random r = new Random();
        int value = 2 + r.nextInt(10);
        return value;
    }
    
}
