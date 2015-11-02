/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howmanytimes;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class HowManyTimes {

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
        
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count += 1;
            }
        }
        System.out.println(String.format("\n%d was found %d times.", value, count));
    }
    
}
