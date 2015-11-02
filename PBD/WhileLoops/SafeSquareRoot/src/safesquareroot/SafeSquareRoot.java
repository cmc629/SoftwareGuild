/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safesquareroot;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class SafeSquareRoot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("SQUARE ROOT!");
        System.out.print("Enter a number: ");
        int number = Integer.parseInt(sc.nextLine());
        
        while (number < 0) {
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.print("Try again: ");
            number = Integer.parseInt(sc.nextLine());
        }
        
        System.out.println("The square root of " + number + " is " + Math.sqrt(number) + ".");
    }
    
}
