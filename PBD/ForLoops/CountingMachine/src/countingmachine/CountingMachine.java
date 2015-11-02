/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingmachine;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class CountingMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Count to: ");
        int num = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i <= num; i++) {
            System.out.print(i + " ");
        }
        
    }
    
}
