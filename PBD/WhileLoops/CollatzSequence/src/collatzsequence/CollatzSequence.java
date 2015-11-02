/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collatzsequence;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class CollatzSequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Starting number: ");
        int number = Integer.parseInt(sc.nextLine());
        System.out.println(number);
        int steps = 0;
        while (number > 1) {
            if (number % 2 == 0) {
                number = number/2;
            }
            else {
                number = 3*number + 1;
            }
            System.out.println(number);
            steps++;
        }
        System.out.println("Terminated after " + steps + " steps.");
    }
    
}
