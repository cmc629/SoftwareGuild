/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isitthereornot;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class IsItThereOrNot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = new int[10];
        Random r = new Random();
        
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + r.nextInt(50);
            System.out.print(array[i] + " ");
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nValue to find: ");
        int value = sc.nextInt();
        
        boolean hasValue = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                hasValue = true;
            }
        }
        if (hasValue) {
            System.out.println(String.format("\n%d is in the array.", value));
        } else {
            System.out.println(String.format("\n%d is not in the array.", value));
        }
        
    }
    
}
