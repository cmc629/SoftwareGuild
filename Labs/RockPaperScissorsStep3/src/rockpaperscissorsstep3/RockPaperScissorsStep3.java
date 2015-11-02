/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsstep3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        boolean shouldContinue = true;
        
        int wins = 0;
        int losses = 0;
        int ties = 0;
        
        System.out.print("How many rounds would you like to play? Please enter a number between 1-10: ");
        int numRounds = sc.nextInt();
        
        if (numRounds < 1 || numRounds > 10) {
            System.out.println("Invalid input! Closing program...");
            return;
        } else {
            System.out.println(numRounds + " round(s)? Alright, let's play!");
        }
        
        String UserChoice;
        int count = 1;
        while (count <= numRounds) {
            System.out.print("Round " + count + "! Please enter rock, paper, or scissors: ");
            UserChoice = sc.next().toLowerCase();

            while(shouldContinue) {
                if (UserChoice.equals("rock") || UserChoice.equals("paper") || 
                        UserChoice.equals("scissors")) {
                    shouldContinue = false;
                }
                else {
                    System.out.println("Invalid input! Please enter rock, paper, or scissors: ");
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
                            ties += 1;
                            break;
                        case "paper":
                            System.out.println("You win!");
                            wins += 1;
                            break;
                        case "scissors":
                            System.out.println("You lose!");
                            losses += 1;
                            break;
                    }
                    break;
                case 2:
                    CompChoice = "paper";
                    switch (UserChoice) {
                        case "rock":
                            System.out.println("You lose!");
                            losses += 1;
                            break;
                        case "paper":
                            System.out.println("It's a tie!");
                            ties += 1;
                            break;
                        case "scissors":
                            System.out.println("You win!");
                            wins += 1;
                            break;
                    }
                    break;
                case 3:
                    CompChoice = "scissors";
                    switch (UserChoice) {
                        case "rock":
                            System.out.println("You win!");
                            wins += 1;
                            break;
                        case "paper":
                            System.out.println("You lose!");
                            losses += 1;
                            break;
                        case "scissors":
                            System.out.println("It's a tie!");
                            ties += 1;
                            break;
                    }
                    break;
            }
            count += 1;
            shouldContinue = true;
        }
        
        System.out.println("Number of wins: " + wins);
        System.out.println("Number of losses: " + losses);
        System.out.println("Number of ties: " + ties);
        
        if (wins > losses) {
            System.out.println("Congratulations! You won more games overall!");
        } else if (wins < losses) {
            System.out.println("That's too bad! You lost more games overall! I win!");
        } else {
            System.out.println("Wow. We tied overall!");
        }
    }
    
}
