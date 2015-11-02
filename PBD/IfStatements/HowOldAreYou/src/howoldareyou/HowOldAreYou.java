/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howoldareyou;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HowOldAreYou {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Hey, what's your name? ");
        String name = sc.nextLine();
        
        System.out.println("Ok, " + name + ", how old are you? ");
        int age = sc.nextInt();
        
        if (age < 16) {
            System.out.println("You can't drive, " + name + ".");
        }
        
        if (age < 18) {
            System.out.println("You can't vote, " + name + ".");
        }
        
        if (age < 25) {
            System.out.println("You can't rent a car, " + name + ".");
        }
        
        if (age >= 25) {
            System.out.println("You can do anything that's legal, " + name + ".");
        }
        
        
    }
    
}
