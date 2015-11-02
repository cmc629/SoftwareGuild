/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsstep4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        boolean shouldPlay = true;
        while (shouldPlay) {
            
            boolean shouldContinue = true;

            int wins = 0;
            int losses = 0;
            int ties = 0;

            int numRounds = getValidNumRounds();

            if (checkNotValidNumber(numRounds)) return; //not too sure about this return?

            String userChoice;
            int count = 1;
            while (count <= numRounds) {
                System.out.print("Round " + count + "! Please enter rock, paper, or scissors: ");
                userChoice = sc.next().toLowerCase();

                userChoice = checkValidRockPaperScissors(shouldContinue, userChoice);

                String compChoice = getCompChoice();

                String result = playRound(userChoice, compChoice);
                
                wins = updateWins(result, wins);
                losses = updateLosses(result, losses);
                ties = updateTies(result, ties);

                count += 1;
                
                shouldContinue = true;
            }

            System.out.println("Number of wins: " + wins);
            System.out.println("Number of losses: " + losses);
            System.out.println("Number of ties: " + ties);

            printOverallResult(wins, losses);
            
            shouldPlay = playAgain(shouldPlay);
        }
    }

    public static int updateWins(String result, int wins) {
        if (result.equals("You win!")) {
            wins += 1;
        }
        return wins;
    }
    
    public static int updateLosses(String result, int losses) {
        if (result.equals("You lose!")) {
            losses += 1;
        }
        return losses;
    }
    
    public static int updateTies(String result, int ties) {
        if (result.equals("It's a tie!")) {
            ties += 1;
        }
        return ties;
    }
    
    public static boolean playAgain(boolean shouldPlay) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you wish to play again? (Yes/No): ");
        String answer = sc.next().toLowerCase();
        switch (answer) {
            case "yes":
                System.out.println("Let's play again!");
                break;
            case "no":
                System.out.println("Thanks for playing!");
                shouldPlay = false;
                return shouldPlay;
            default:
                System.out.println("Invalid Input!");
                playAgain(shouldPlay);
        }
        return shouldPlay;
    }

    public static void printOverallResult(int wins, int losses) {
        if (wins > losses) {
            System.out.println("Congratulations! You won more games overall!");
        } else if (wins < losses) {
            System.out.println("That's too bad! You lost more games overall! I win!");
        } else {
            System.out.println("Wow. We tied overall!");
        }
    }
    
    public static String playRound(String userChoice, String compChoice) {
        System.out.println("You picked " + userChoice + ". I picked " + compChoice + ". ");
        String result = "";
        if (userChoice.equals(compChoice)) {
            System.out.println("It's a tie!");
            result = "It's a tie!";
        }
        else {
            if (userChoice.equals("rock")) {
                if (compChoice.equals("paper")) {
                    System.out.println("You lose!");
                    result = "You lose!";
                } else {
                    System.out.println("You win!");
                    result = "You win!";
                }
            }
            if (userChoice.equals("paper")) {
                if (compChoice.equals("scissors")) {
                    System.out.println("You lose!");
                    result = "You lose!";
                } else {
                    System.out.println("You win!");
                    result = "You win!";
                }
            }
            if (userChoice.equals("scissors")) {
                if (compChoice.equals("rock")) {
                    System.out.println("You lose!");
                    result = "You lose!";
                } else {
                    System.out.println("You win!");
                    result = "You win!";
                }
            }
        }
        return result;
    }
    
    public static String getCompChoice() {
        Random rGen = new Random();
        int numberChoice = rGen.nextInt(3) + 1;
        String compChoice = "";
        if (numberChoice == 1) compChoice = "rock";
        else if (numberChoice == 2) compChoice = "paper";
        else if (numberChoice == 3) compChoice = "scissors";
        return compChoice;
    }

    public static String checkValidRockPaperScissors(boolean shouldContinue, String UserChoice) {
        Scanner sc = new Scanner(System.in);
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
        return UserChoice;
    }

    public static boolean checkNotValidNumber(int numRounds) {
        if (numRounds < 1 || numRounds > 10) {
            System.out.println("Invalid input! Closing program...");
            return true;
        } else {
            System.out.println(numRounds + " round(s)? Alright, let's play!");
        }
        return false;
    }

    public static int getValidNumRounds() {
        Scanner sc = new Scanner(System.in);
        int numRounds;
        System.out.println("How many rounds would you like to play? Please enter a number between 1-10: ");
        if (!sc.hasNextInt()) {
            System.out.println("That's not a number!");
            numRounds = getValidNumRounds();
        }
        else {
            numRounds = sc.nextInt();
        }
        return numRounds;
        

    }
    
}
