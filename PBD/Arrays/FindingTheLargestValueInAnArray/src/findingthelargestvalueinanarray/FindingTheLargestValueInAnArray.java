/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findingthelargestvalueinanarray;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class FindingTheLargestValueInAnArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = new int[10];
        Random r = new Random();
        
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + r.nextInt(100);
            System.out.print(array[i] + " ");
        }
        
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("\nThe largest value is " + max);
    }
    
}
