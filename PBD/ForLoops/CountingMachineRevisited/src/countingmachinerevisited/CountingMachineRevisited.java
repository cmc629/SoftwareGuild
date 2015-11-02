/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingmachinerevisited;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class CountingMachineRevisited {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Count from: ");
        int start = sc.nextInt();
        System.out.print("Count to: ");
        int end = sc.nextInt();
        System.out.print("Count by: ");
        int increment = sc.nextInt();
        
        for (int i = start; i <= end; i+=increment) {
            System.out.print(i + " ");
        }
        
    }
    
}
