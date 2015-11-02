/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsstep1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        
        boolean shouldContinue = true;
        
        String UserChoice;
        
        System.out.print("Let's play rock, paper, scissors! Please enter rock, paper, or scissors: ");
        UserChoice = sc.next().toLowerCase();
        
        while(shouldContinue) {
            if ("rock".equals(UserChoice) || "paper".equals(UserChoice) || 
                    "scissors".equals(UserChoice)) {
                shouldContinue = false;
            }
            else {
                System.out.print("Invalid input! Please enter rock, paper, or scissors: ");
                UserChoice = sc.next().toLowerCase();
            }
        } 
            
        
        Random rGen = new Random();
        int numberChoice = rGen.nextInt(3) + 1;
        
        String CompChoice;
        switch (numberChoice) {
            case 1:
                CompChoice = "rock";
                switch (UserChoice) {
                    case "rock":
                        System.out.println("It's a tie!");
                        break;
                    case "paper":
                        System.out.println("You win!");
                        break;
                    case "scissors":
                        System.out.println("You lose!");
                        break;
                }
                break;
            case 2:
                CompChoice = "paper";
                switch (UserChoice) {
                    case "rock":
                        System.out.println("You lose!");
                        break;
                    case "paper":
                        System.out.println("It's a tie!");
                        break;
                    case "scissors":
                        System.out.println("You win!");
                        break;
                }
                break;
            case 3:
                CompChoice = "scissors";
                switch (UserChoice) {
                    case "rock":
                        System.out.println("You win!");
                        break;
                    case "paper":
                        System.out.println("You lose!");
                        break;
                    case "scissors":
                        System.out.println("It's a tie!");
                        break;
                }
                break;
        }

    }
    
}
