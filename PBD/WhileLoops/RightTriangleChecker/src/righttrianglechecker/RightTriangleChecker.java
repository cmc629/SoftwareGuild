/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package righttrianglechecker;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class RightTriangleChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter three integers:");
        System.out.print("Side 1: ");
        int side1 = Integer.parseInt(sc.nextLine());
        System.out.print("Side 2: ");
        int side2 = Integer.parseInt(sc.nextLine());
        while (side2 < side1) {
            System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
            System.out.print("Side 2: ");
            side2 = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Side 3: ");
        int side3 = Integer.parseInt(sc.nextLine());
        while (side3 < side2) {
            System.out.println(side3 + "is smaller than " + side2 + ". Try again.");
            System.out.print("Side 3: ");
            side3 = Integer.parseInt(sc.nextLine());
        }
        
        System.out.println("\nYour three sides are " + side1 + " " + side2 + " " + side3);
        if (side3 == Math.sqrt((side1*side1) + side2*side2)) {
            System.out.println("These sides *do* make a right triangle. Yippy-skippy!");
        } else {
            System.out.println("NO! These sides do not make a right triangle!");
        }
    }
    
}
