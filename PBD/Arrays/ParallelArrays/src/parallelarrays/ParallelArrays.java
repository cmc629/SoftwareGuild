/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelarrays;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class ParallelArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] arr1 = {"Mitchell", "Ortiz", "Luu", "Zimmerman", "Brooks"};
        double[] arr2 = {99.5, 78.5, 95.6, 96.8, 82.7};
        int[] arr3 = {123455, 813225, 823669, 307760, 827131};
        
        System.out.print("Values:\n\t");
        
        for (int i = 0; i < 5; i++) {
            System.out.print(String.format("%s %.1f %d\n\t", arr1[i], arr2[i], arr3[i]));
            
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nID number to find: ");
        int find = sc.nextInt();
        
        int index = 5;
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] == find) {
                index = i;
            }
        }
        
        if (index == 5) {
            System.out.println("\nID number not found!");
        } else {
            System.out.println("\nFound in slot " + index);
            System.out.println("\tName: " + arr1[index]);
            System.out.println("\tAverage: " + arr2[index]);
            System.out.println("\tID: " + arr3[index]);
        }
    }
    
}
