/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areacalculator;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class AreaCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean isRunning = true;
        while (isRunning) {
            Scanner sc = new Scanner(System.in);
            System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n1) Triangle" +
                    "\n2) Rectangle\n3) Square\n4) Circle\n5) Quit\nWhich shape: ");
            int input = sc.nextInt();

            if (input == 1) {
                System.out.print("\nBase: ");
                int base = sc.nextInt();
                System.out.print("Height: ");
                int height = sc.nextInt();

                System.out.println("\nThe area is " + area_triangle(base, height) + ".");
            }
            if (input == 2) {
                System.out.print("\nLength: ");
                int length = sc.nextInt();
                System.out.print("Width: ");
                int width = sc.nextInt();

                System.out.println("\nThe area is " + area_rectangle(length, width) + ".");
            }
            if (input == 3) {
                System.out.print("\nSide length: ");
                int side = sc.nextInt();

                System.out.println("\nThe area is " + area_square(side) + ".");
            }
            if (input == 4) {
                System.out.print("\nRadius: ");
                int radius = sc.nextInt();

                System.out.println("\nThe area is " + area_circle(radius) + ".");
            }
            if (input == 5) {
                System.out.println("\nGoodbye.");
                isRunning = false;
            }
        }
    }
    
    public static double area_circle( int radius ) {             // returns the area of a circle
        return Math.PI * radius * radius;
    }
    
    public static int area_rectangle( int length, int width ) {   // returns the area of a rectangle
        return length * width;
    }
    
    public static int area_square( int side ) {                   // returns the area of a square
        return (int) Math.pow(side, 2);
    }
    
    public static double area_triangle( int base, int height ) { // returns the area of a triangle
        return base * height / 2;
    }
    
}
