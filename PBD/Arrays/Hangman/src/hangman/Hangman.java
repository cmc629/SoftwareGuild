/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Hangman {

    private String[] wordArray = {"pulchritude", "malicious", "olfactory"};
    private String word = "";
    private String guesses = "";
    private String[] empty;
    private String misses = "";
    private final int MAX_NUMBER_OF_TRIES = 15;
    private int tries = 1;
    
    public void run() {
        
        generateWord();
        createEmpty();
        while (this.tries <= this.MAX_NUMBER_OF_TRIES) {
            displayGame();
            if (checkComplete()) {
                System.out.println("You guessed it!");
                break;
            }
        }
        if (!checkComplete()) {
            System.out.println("Too bad. Try again.");
        }
        
    }
    
    private void generateWord() {
        
        Random r = new Random();
        int index = r.nextInt(this.wordArray.length);
        
        this.word = this.wordArray[index];
    }
    
    private void displayGame() {
        
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Try: " + this.tries);
        displayWord();
        displayMisses();
        String guess = askForGuess();
        checkGuess(guess);
        
    }
    
    private void createEmpty() {
        int length = this.word.length();
        this.empty = new String[length];
        for (int i = 0; i < length; i ++) {
            this.empty[i] = "_";
        }
    }
    
    private void displayWord() {
        System.out.print("\nWord: ");
        int length = this.empty.length;
        for (int i = 0; i < length; i++) {
            System.out.print(" " + this.empty[i] + " ");
        }
        System.out.println();
    }
    
    private void displayMisses() {
        System.out.print("\nMisses: ");
        System.out.print(this.misses);
        System.out.println();
    }
    
    private String askForGuess() {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nGuess: ");
        String guess = sc.nextLine();
        return guess;
    }
    
    private void checkGuess(String guess) {
        
        if (this.guesses.contains(guess)) {
            System.out.println("Already guessed!");
        } else {
            if (this.word.contains(guess)) {
                for (int i = 0; i < this.word.length(); i++) {
                    String character = String.valueOf(word.charAt(i));
                    if (character.equals(guess)) {
                        this.empty[i] = guess;
                    }
                }
            } else {
                this.misses += guess;
            }
            this.tries++;
            this.guesses += guess;
        }
    }
    
    private boolean checkComplete() {
        
        return !Arrays.asList(this.empty).contains("_"); //checks to see if array contains value. DOES NOT WORK FOR PRIMITIVE TYPES
        
    }
}
