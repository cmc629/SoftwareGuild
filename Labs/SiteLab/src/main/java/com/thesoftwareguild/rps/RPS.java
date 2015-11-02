/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.rps;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class RPS {

    private Round rounds;
    private boolean gameStatus;

    public RPS() {
        this.rounds = new Round();
        this.gameStatus = true;
    }
    
    public Round getRounds() {
        return rounds;
    }

    public void setRounds(Round rounds) {
        this.rounds = rounds;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }
    
    public void run() {
        
        while (this.gameStatus) {
            
            this.rounds = new Round();
            this.rounds.startRounds();
            
            String playAgainString = getPlayAgainInput();
            this.gameStatus = playAgain(playAgainString);
            
        }
    }
    
    public String getPlayAgainInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nDo you wish to play again? (Yes/No): ");
        String answer = sc.next().toLowerCase();
        if (!answer.equals("yes") && !answer.equals("no")) {
            System.out.println("Invalid input!");
            answer = getPlayAgainInput();
        }
        else {
            return answer;
        }
        return answer;
    }
    
    public boolean playAgain(String answer) {
        if (answer.equals("yes")) {
            System.out.println("\nLet's play again!");
            return true;
        } else {
            System.out.println("\nThanks for playing!");
            return false;
        }
    }
}
