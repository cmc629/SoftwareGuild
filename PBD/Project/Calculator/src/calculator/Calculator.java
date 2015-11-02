/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double a, b, c;
        String op;

        do
        {
            System.out.print("> ");
            a  = keyboard.nextDouble();
            op = keyboard.next();
            b  = keyboard.nextDouble();

            if ( op.equals("+") )
                c = a + b;
            else if (op.equals("-"))
                c = a - b;
            else if (op.equals("*"))
                c = a * b;
            else if (op.equals("/"))
                c = a / b;
            else if (op.equals("^")) {
                c = a;
                for (int i = 1; i < b; i++) {
                    c *= a;
                }
            }
            else {
                System.out.println("Undefined operator: '" + op + "'.");
                c = 0;
            }

            System.out.println(c);

        } while (a != 0);
            System.out.println("Bye now!");
	}
}
    
   