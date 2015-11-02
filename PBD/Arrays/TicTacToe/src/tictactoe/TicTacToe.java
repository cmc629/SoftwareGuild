/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    private static char[][] board = new char[3][3];
    //refactor later on
    public void run() {
        Scanner keyboard = new Scanner(System.in);

        initBoard();
        displayBoard();
        
        boolean isFull = false;
        boolean hasWinner = false;
        while (!isFull && !hasWinner) {
            
            
            playerOTurn();
            hasWinner = checkWinner();
            System.out.println();
            displayBoard();
            isFull = checkFullBoard();
            
            if (!hasWinner && !isFull) {
                playerXTurn();
                hasWinner = checkWinner();
                System.out.println();
                displayBoard();
                
            }
        }
        
        
    }

    private void initBoard() {
        // fills up the board with blanks
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
    }


    private void displayBoard() {
        System.out.println("  0  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("    ---+---+---");
        System.out.println("  1  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("    ---+---+---");
        System.out.println("  2  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println("     0   1   2 ");
    }

    //displays board without inner borders. no need to use this 
    private void displayBoard2() {
        for (int r = 0; r < 3; r++) {
            System.out.print("\t" + r + " ");
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("\t  0 1 2 ");
    }
    
    private void playerOTurn() {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("\n'O', choose your location (row, column): ");
        int row = keyboard.nextInt();
        int column = keyboard.nextInt();
        if ((row < 3 && row >= 0) && (column < 3 && column >= 0)) {
            if (board[row][column] == 'O' || board[row][column] == 'X') {
                System.out.println("That spot is occupied! Choose a different spot!");
                playerOTurn();
            } else {
                board[row][column] = 'O';
            }
        } else {
            System.out.println("Invalid rows and column! Please re-enter!");
            playerOTurn();
        }
        
    }
    
    private void playerXTurn() {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("\n'X', choose your location (row, column): ");
        int row = keyboard.nextInt();
        int column = keyboard.nextInt();
        if ((row < 3 && row >= 0) && (column < 3 && column >= 0)) {
            if (board[row][column] == 'O' || board[row][column] == 'X') {
                System.out.println("That spot is occupied! Choose a different spot!");
                playerXTurn();
            } else {
                board[row][column] = 'X';
            }
        } else {
            System.out.println("Invalid rows and column! Please re-enter!");
            playerXTurn();
        }
    }
    
    private boolean checkWinner() {
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != ' ') {
            System.out.println("\nPlayer '" + board[0][0] + "' has won!");
            return true;
        } else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != ' ') {
            System.out.println("\nPlayer '" + board[1][0] + "' has won!");
            return true;
        } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != ' ') {
            System.out.println("\nPlayer '" + board[2][0] + "' has won!");
            return true;
        } else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != ' ') {
            System.out.println("\nPlayer '" + board[0][0] + "' has won!");
            return true;
        } else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != ' ') {
            System.out.println("\nPlayer '" + board[0][1] + "' has won!");
            return true;
        } else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != ' ') {
            System.out.println("\nPlayer '" + board[0][2] + "' has won!");
            return true;
        } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            System.out.println("\nPlayer '" + board[0][0] + "' has won!");
            return true;
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            System.out.println("\nPlayer '" + board[0][2] + "' has won!");
            return true;
        } else {
            return false;
        }
    }
    
    private boolean checkFullBoard() {
        if (board[0][0] != ' ' && board[0][1] != ' ' && board[0][2] != ' ' &&
            board[1][0] != ' ' && board[1][1] != ' ' && board[1][2] != ' ' &&
            board[2][0] != ' ' && board[2][1] != ' ' && board[2][2] != ' ') {
            System.out.println("\nThe game is a tie.");
            return true;
        } else {
            return false;
        }
    }
    
}
