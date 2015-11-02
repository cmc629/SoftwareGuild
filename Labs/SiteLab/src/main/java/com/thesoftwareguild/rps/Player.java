/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.rps;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Player {
    
    private String choice;

    
    public Player() {
        this.choice = getPlayerChoice();
    }
    
    
    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
    
    public static String getPlayerChoice() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter rock, paper, or scissors: ");
        String userChoice = sc.nextLine().toLowerCase();
        if (!userChoice.equals("rock") && !userChoice.equals("paper") &&
                !userChoice.equals("scissors")) {
            System.out.println("Invalid input!");
            userChoice = getPlayerChoice();
        }
        return userChoice;   
    }
    
}
