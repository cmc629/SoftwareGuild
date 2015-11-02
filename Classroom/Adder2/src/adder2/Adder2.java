/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adder2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Adder2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int sum = 0;
        int operand1 = 0;
        int operand2 = 0;
        
        Scanner sc = new Scanner(System.in);
        
        String stringOperand1 = "";
        String stringOperand2 = "";
        
        System.out.println("Please enter the first number to be added:");
        //need to add scanner object to prompt user to enter input
        stringOperand1 = sc.nextLine(); //nextLine() is a method in the scanner object
        
        System.out.println("Please enter the second number to be added:");
        
        stringOperand2 = sc.nextLine();
        
        
        operand1 = Integer.parseInt(stringOperand1); //convert string to int
        operand2 = Integer.parseInt(stringOperand2);
        
        sum = operand1 + operand2;
        
        System.out.println("Sum is: " + sum);
        
        
    }
    
}
