/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.rps;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class Computer {
    
    private String choice;
    
    public Computer() {
        this.choice = getCompChoice();
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
    
    public String getCompChoice() {
        Random r = new Random();
        
        int numChoice = 1 + r.nextInt(3);
        String compChoice;
        if (numChoice == 1) {
            compChoice = "rock";
        }
        else if (numChoice == 2) {
            compChoice = "paper";
        }
        else {
            compChoice = "scissors";
        }
        return compChoice;
    }
    
    
    
    
}
