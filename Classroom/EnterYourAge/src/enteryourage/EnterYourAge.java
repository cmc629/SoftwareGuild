/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteryourage;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class EnterYourAge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What is your age?");
        int age = sc.nextInt();
        
        if (age < 18) {
            System.out.println("You must be in school");
        }
        else if (age < 65) {
            System.out.println("Time to go to work!");
        }
        else {
            System.out.println("Enjoy retirement!");
        }
        
    }
    
}
