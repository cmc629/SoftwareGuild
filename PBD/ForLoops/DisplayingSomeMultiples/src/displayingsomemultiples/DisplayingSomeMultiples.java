/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displayingsomemultiples;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class DisplayingSomeMultiples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Choose a number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        for (int i = 1; i <= 12; i++) {
            System.out.println(number + "x" + i + " = " + (number*i));
        }
    }
    
}
