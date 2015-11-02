/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabeticalorder;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class AlphabeticalOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is your last name: ");
        String last = sc.nextLine();
        
        if (last.compareTo("Carswell") <= 0) {
            System.out.println("You don't have to wait too long.");
        } else if (last.compareTo("Jones") <= 0) {
            System.out.println("That's not bad.");
        } else if (last.compareTo("Smith") <= 0) {
            System.out.println("Looks like a bit of a wait.");
        } else if (last.compareTo("Young") <= 0) {
            System.out.println("It's going to be a while.");
        } else {
            System.out.println("Not going anywhere for a while?");
        }
        
    }
    
}
