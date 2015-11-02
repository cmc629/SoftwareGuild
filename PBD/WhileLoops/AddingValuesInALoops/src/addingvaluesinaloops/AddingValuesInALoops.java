/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addingvaluesinaloops;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class AddingValuesInALoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("I will add up the numbers you give me.");
        int sum = 0;
        System.out.print("Number: ");
        int number = Integer.parseInt(sc.nextLine());
        while (number != 0) {
            sum += number;
            System.out.println("The total so far is " + sum);
            System.out.print("Number: ");
            number = Integer.parseInt(sc.nextLine());
        }
        System.out.println("\nThe total is " + sum);
    }
    
}
