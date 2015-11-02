/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copyingarrays;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class CopyingArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r = new Random();
        
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = 1 + r.nextInt(100);
        }
        
        int[] arrayCopy = new int[10];
        for (int i = 0; i < 9; i++) {
            arrayCopy[i] = array[i]; 
        }
        array[9] = -7;
        
        System.out.print("Array 1: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        
        System.out.print("\nArray 2: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arrayCopy[i] + " ");
        }
        System.out.println();
    }
    
}
