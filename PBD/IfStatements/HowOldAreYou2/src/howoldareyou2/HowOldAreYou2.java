/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howoldareyou2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HowOldAreYou2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Hey, what's your name? (Sorry, I keep forgetting.) ");
        String name = sc.nextLine();
        
        System.out.println("Ok, " + name + ", how old are you?");
        int age = sc.nextInt();
        
        if (age < 16) {
            System.out.println("You can't drive, " + name + ".");
        } else if (age <= 17) {
            System.out.println("You can drive but not vote, " + name + ".");
        } else if (age <= 24) {
            System.out.println("You can vote but not rent a car, " + name + ".");
        } else {
            System.out.println("You can do pretty much anything, " + name + ".");
        }
        
    }
    
}
