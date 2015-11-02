/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class UI {
    
    public static void main(String[] args) {
        
        SimpleCalculator calc = new SimpleCalculator();
        ConsoleIO console = new ConsoleIO();
        Scanner sc = new Scanner(System.in);
        
        boolean isClosed = false;
        while (!isClosed) {
            int input = console.promptInt("Pick an operation:\n1) Addition  2) Subtraction  3) Multiplication\n4) Division  5) Quit\n> ", 1, 5);    

            if (input != 5) {
                double operand1 = console.promptDouble("Please enter operand 1: ");
                double operand2 = console.promptDouble("Please enter operand 2: ");
                double result;
                if (input == 1) {
                    result = calc.addition(operand1, operand2);
                    System.out.println("The result of " + operand1 + " plus " + operand2 + " is: " + result + ".");
                }
                if (input == 2) {
                    result = calc.subtraction(operand1, operand2);
                    System.out.println("The result of " + operand1 + " minus " + operand2 + " is: " + result + ".");
                }
                if (input == 3) {
                    result = calc.multiplication(operand1, operand2);
                    System.out.println("The result of " + operand1 + " multiplied by " + operand2 + " is: " + result + ".");
                }
                if (input == 4) {
                    result = calc.division(operand1, operand2);
                    if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) console.printToConsole("Can't divide by zero!");
                    else console.printToConsole("The result of " + operand1 + " divides " + operand2 + " is: " + result + ".");
                }
            }
            else {
                console.printToConsole("Thank you. Closing program...");
                isClosed = true;
            }
        }
    }
    
}
