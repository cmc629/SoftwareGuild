/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlequiz;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LittleQuiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Are you ready for a quiz? ");
        String answer = sc.nextLine().toLowerCase();
        
        if (answer.equals("no")) {
            System.out.println("Okay, let's play another time! Closing program...");
        }
        else {
            System.out.println("Okay here it come!");
            System.out.println("Q1) What is the capital of Alaska?");
            System.out.println("       1) Melbourne");
            System.out.println("       2) Anchorage");
            System.out.println("       3) Juneau");
            int ans1 = sc.nextInt();
            int count = 0;
            if (ans1 == 3) {
                System.out.println("That's right!");
                count += 1;
            }
            else {
                System.out.println("Sorry that's the wrong answer!");
            }
            
            System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");
            System.out.println("       1) yes");
            System.out.println("       2) no");
            int ans2 = sc.nextInt();
            if (ans2 == 1) {
                System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.");
            }
            else if (ans2 == 2) {
                System.out.println("Correct!");
                count += 1;
            }
            else {
                System.out.println("Invalid answer.");
            }
            
            System.out.println("Q3) What is the result of 9+6/3?");
            System.out.println("        1) 5");
            System.out.println("        2) 11");
            System.out.println("        3) 15/3");
            int ans3 = sc.nextInt();
            if (ans3 == 2) {
                System.out.println("That's correct!");
                count += 1;
            }
            else {
                System.out.println("Wrong answer.");
            }
            
            System.out.println("Overall, you got " + count + " out of 3 correct.");
            System.out.println("Thanks for playing!");
        }
        
        
        
    }
    
}
