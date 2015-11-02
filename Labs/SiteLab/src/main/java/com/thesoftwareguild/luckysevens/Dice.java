/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.luckysevens;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class Dice {
    
    public static int rollDice() {
        Random r = new Random();
        int value = 1+ r.nextInt(6);
        return value;
    }
    
}
