/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.olympian;

/**
 *
 * @author Christian Choi
 */
public class SpeedSkatingEvent implements Event {

    @Override
    public String compete() {
        System.out.println("Competing in speed skating");
        System.out.println();
        return "SpeedSkating";
    }
    
    
    
}
