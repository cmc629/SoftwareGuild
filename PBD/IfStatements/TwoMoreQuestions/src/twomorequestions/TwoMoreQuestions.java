/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twomorequestions;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class TwoMoreQuestions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Think of something and I'll try to guess it!");
        
        System.out.print("Question 1) Does it stay inside or outside or both? ");
        String location = sc.nextLine();
        
        System.out.print("Question 2) Is it a living thing? ");
        String status = sc.nextLine();
        
        if (location.equals("inside") && status.equals("yes")) {
            System.out.println("You're thinking of a houseplant!");
        }
        if (location.equals("inside") && status.equals("no")) {
            System.out.println("You're thinking of a shower curtain!");
        }
        if (location.equals("outside") && status.equals("yes")) {
            System.out.println("You're thinking of a bison!");
        }
        if (location.equals("outside") && status.equals("no")) {
            System.out.println("You're thinking of a billboard!");
        }
        if (location.equals("both") && status.equals("yes")) {
            System.out.println("You're thinking of a dog!");
        }
        if (location.equals("both") && status.equals("no")) {
            System.out.println("You're thinking of a cell phone!");
        }
    
    }
    
}
