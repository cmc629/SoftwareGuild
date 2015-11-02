/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gendergame;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class GenderGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is your gender (M or F): ");
        String gender = sc.nextLine();
        
        System.out.print("First name: ");
        String first = sc.nextLine();
        
        System.out.print("Last name: ");
        String last = sc.nextLine();
        
        System.out.print("Age: ");
        String stringAge = sc.nextLine();
        int age = Integer.parseInt(stringAge);
        
        if (gender.equals("F") && age >= 20) {
            System.out.print("Are you married, " + first + " (y or n)? ");
            String marry = sc.nextLine();
            
            if (marry.equals("y")) {
                System.out.println("Then I shall call you Mrs. " + last + ".");
            } else {
                System.out.println("Then I shall call you Ms. " + last + ".");
            }
        }
        
        if (gender.equals("F") && age < 20) {
            System.out.println("Then I shall call you " + first + " " + last + ".");
        }
        
        if (gender.equals("M")) {
            if (age >= 20) {
                System.out.println("Then I shall call you Mr. " + last + ".");
            } else {
                System.out.println("Then I shall call you " + first + " " + last + ".");
            }
        }
        
    }
    
}
