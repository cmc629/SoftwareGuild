/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addingvaluesforloop;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class AddingValuesForLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Number: ");
        int number = Integer.parseInt(sc.nextLine());
        
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println("The sum is " + sum + ".");
        
    }
    
}
