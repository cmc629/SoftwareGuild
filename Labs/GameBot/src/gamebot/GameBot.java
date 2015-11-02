/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamebot;

import blackjack.Blackjack;
import hangman.Hangman;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import luckysevens.LuckySevens;
import rps.RPS;
import tictactoe.TicTacToe;

/**
 *
 * @author Christian Choi
 */
public class GameBot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        LuckySevens luckySevens = new LuckySevens();
        Blackjack blackjack = new Blackjack();
        Hangman hangman = new Hangman();
        RPS rps = new RPS();
        TicTacToe ttt = new TicTacToe();
        
        List<Game> games = new ArrayList<>();
        
        games.add(luckySevens);
        games.add(blackjack);
        games.add(hangman);
        games.add(rps);
        games.add(ttt);
        
        boolean stillPlaying = true;
        
        while (stillPlaying) {
            
            System.out.println("\nHello, I am GameBot. Here is a list of games:\n");
            
            for (Game game : games) {
                System.out.println("Game name: " + game.getName());
            }
            System.out.println("Please enter a game name to play. Or type 'exit' to exit.");
            String input = sc.nextLine();
            
            for (Game game : games) {
                if (input.equals(game.getName())) {
                    game.run();
                }
            }
            
            if ("exit".equals(input)) {
                stillPlaying = false;
            }
            
        }
        
    }
    
}
