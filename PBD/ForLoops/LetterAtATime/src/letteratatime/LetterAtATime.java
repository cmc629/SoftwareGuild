/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letteratatime;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class LetterAtATime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is your message? ");
        String message = sc.nextLine();
        
        int length = message.length();
        int firstIndex = 0;
        int lastIndex = message.length() - 1;
        System.out.println("\nYour message is " + length + " characters long.");
        System.out.println("The first character is at position " + firstIndex + " and is '" + message.charAt(firstIndex) + "'.");
        System.out.println("The last character is at position " + lastIndex + " and is '" + message.charAt(lastIndex) + "'.");
        
        System.out.println("\nHere are all the characters, one at a time:\n");
        int vowelCount = 0;
        String vowelString = "aAeEiIoOuU";
        for (int i = firstIndex; i < length; i++) {
            System.out.println("    " + i + " - '" + message.charAt(i) + "'");
            for (int j = 0; j < vowelString.length(); j++) {
                if (message.charAt(i) == vowelString.charAt(j)) {
                    vowelCount++;
                }
            }
        }
        System.out.println("Your message contains " + vowelCount + " vowels. Isn't that interesting?");
        
    }
    
}
