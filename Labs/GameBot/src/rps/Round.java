/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rps;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Round {
    
    private Player player;
    private Computer computer;
    private int roundNumber;
    private boolean isValid = false;
    private int playerWins = 0;
    private int computerWins = 0;
    private int ties = 0;

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public void setComputerWins(int computerWins) {
        this.computerWins = computerWins;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }
    
    public void startRounds() {
        
        while (!this.isValid) {
            this.roundNumber = getValidNumberOfRounds();
            this.isValid = isValidNumber(this.roundNumber);
        }
        
        int count = 1;
        while(count <= this.roundNumber) {
            this.player = new Player();
            this.computer = new Computer();
            System.out.print("\nRound " + count + ": ");
            String result = compareChoices(this.player.getChoice(), this.computer.getChoice());
            this.playerWins = updatePlayerWins(result, this.playerWins);
            this.computerWins = updateCompWins(result, this.computerWins);
            this.ties = updateTies(result, this.ties);
            count++;
        }
        printResult(this.playerWins, this.computerWins, this.ties);
        
        printOverallResult(this.playerWins, this.computerWins);
    }
    
    public int getValidNumberOfRounds() {
        Scanner sc = new Scanner(System.in);
        int numRounds;
        System.out.print("\nHow many rounds would you like to play? Please enter a number between 1-10: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input!");
            numRounds = getValidNumberOfRounds();
        }
        else {
            String numString = sc.nextLine();
            numRounds = Integer.parseInt(numString);
        }
        return numRounds;
    }
    
    public boolean isValidNumber(int number) {
        if (number < 1 || number > 10) {
            System.out.println("Invalid input!");
            return false;
        }
        return true;
    }
    
    public String compareChoices(String userChoice, String compChoice) {
        System.out.println("You picked " + userChoice + ". Computer picked " + compChoice + ". ");
        String result = "";
        if (userChoice.equals(compChoice)) {
            System.out.println("It's a tie!");
            result = "It's a tie!";
        }
        else {
            if (userChoice.equals("rock")) {
                if (compChoice.equals("paper")) {
                    System.out.println("Computer wins!");
                    result = "Computer wins!";
                } else {
                    System.out.println("You win!");
                    result = "You win!";
                }
            }
            if (userChoice.equals("paper")) {
                if (compChoice.equals("scissors")) {
                    System.out.println("Computer wins!");
                    result = "Computer wins!";
                } else {
                    System.out.println("You win!");
                    result = "You win!";
                }
            }
            if (userChoice.equals("scissors")) {
                if (compChoice.equals("rock")) {
                    System.out.println("Computer wins!");
                    result = "Computer wins!";
                } else {
                    System.out.println("You win!");
                    result = "You win!";
                }
            }
        }
        return result;
    }
    
    public int updatePlayerWins(String result, int wins) {
        if (result.equals("You win!")) {
            wins += 1;
        }
        return wins;
    }
    
    public int updateCompWins(String result, int losses) {
        if (result.equals("Computer wins!")) {
            losses += 1;
        }
        return losses;
    }
    
    public int updateTies(String result, int ties) {
        if (result.equals("It's a tie!")) {
            ties += 1;
        }
        return ties;
    }
    
    
    public void printResult(int win, int loss, int ties) {
        System.out.println("\nOVERALL RESULTS:");
        System.out.println("# Player wins: " + win);
        System.out.println("# Computer wins: " + loss);
        System.out.println("# Ties: " + ties);
    }
    
    public static void printOverallResult(int wins, int losses) {
        if (wins > losses) {
            System.out.println("\nCONGRATULATIONS! You won more games overall!");
        } else if (wins < losses) {
            System.out.println("\nTHAT'S TOO BAD! The computer won more games overall!");
        } else {
            System.out.println("\nWOW...You tied with the computer overall!");
        }
    }
}
