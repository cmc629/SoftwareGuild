/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceboxing;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SpaceBoxing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter your current earth weight: ");
        int weight = sc.nextInt();
        
        System.out.println("I have information for the following planets:");
        System.out.println("   1. Venus   2. Mars    3. Jupiter");
        System.out.println("   4. Saturn  5. Uranus  6. Neptune");
        
        System.out.print("Which planet are you visiting? ");
        int planet = sc.nextInt();
        
        if (planet == 1) {
            System.out.println("Your weight would be " + (0.78 * weight) + " pounds on that planet.");
        } else if (planet == 2) {
            System.out.println("Your weight would be " + (0.39 * weight) + " pounds on that planet.");
        } else if (planet == 3) {
            System.out.println("Your weight would be " + (2.65 * weight) + " pounds on that planet.");
        } else if (planet == 4) {
            System.out.println("Your weight would be " + (1.17 * weight) + " pounds on that planet.");
        } else if (planet == 5) {
            System.out.println("Your weight would be " + (1.05 * weight) + " pounds on that planet.");
        } else if (planet == 6) {
            System.out.println("Your weight would be " + (1.23 * weight) + " pounds on that planet.");
        }
        
    }
    
}
