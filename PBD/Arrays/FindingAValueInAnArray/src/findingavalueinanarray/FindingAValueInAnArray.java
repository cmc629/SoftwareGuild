/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findingavalueinanarray;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class FindingAValueInAnArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] array = new int[10];
        Random r = new Random();
        System.out.print("Array: ");
        for (int i = 0; i < 10; i++) {
            array[i] = 1 + r.nextInt(50);
            System.out.print(array[i] + " ");
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nValue to find: ");
        int find = sc.nextInt();
        
        for (int i = 0; i < 10; i++) {
            if (array[i] == find) {
                System.out.println(find + " is in the array.");
            }
        }
    }
    
}
