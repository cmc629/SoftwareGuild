/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twentyquestions;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class TwentyQuestions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("TWO QUESTIONS!");
        System.out.println("Think of an object, and I'll try to guess it.");
        
        System.out.println("\nQuestion 1) Is it animal, vegetable, or mineral?");
        String ans1 = sc.nextLine();
        
        System.out.println("\nQuestion 2) Is it bigger than a breadbox?");
        String ans2 = sc.nextLine().toLowerCase();
        
        String object = "";
        if (ans1.equals("animal")) {
            if (ans2.equals("no")) {
                object = "squirrel";
            }
            else {
                object = "moose";
            }
        }
        if (ans1.equals("vegetable")) {
            if (ans2.equals("no")) {
                object = "carrot";
            }
            else {
                object = "watermelon";
            }
        }
        if (ans1.equals("mineral")) {
            if (ans2.equals("no")) {
                object = "paper clip";
            }
            else {
                object = "Camaro";
            }
        }
        
        System.out.println("\nMy guess is you are thinking of a " + object + ".");
        System.out.println("I would ask you if I'm right, but I don't actually care.");
        
    }
    
}
