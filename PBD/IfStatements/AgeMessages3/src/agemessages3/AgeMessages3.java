/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agemessages3;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class AgeMessages3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Your name: ");
        String name = sc.nextLine();
        
        System.out.print("Your age: ");
        String stringAge = sc.nextLine();
        int age = Integer.parseInt(stringAge);
        
        if (age < 16) {
            System.out.println("You can't drive, " + name + ".");
        }
        if (age >= 16 && age <= 17) {
            System.out.println("You can drive but not vote " + name + ".");
        }
        if (age >= 18 && age <= 24) {
            System.out.println("You can vote but not rent a car " + name + ".");
        }
        if (age >= 25) {
            System.out.println("You can do pretty much anything " + name + ".");
        }
    }
    
}
