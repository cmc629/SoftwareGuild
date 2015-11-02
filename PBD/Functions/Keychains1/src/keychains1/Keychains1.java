/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keychains1;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Keychains1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ye Olde Keychain Shoppe");
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n1) Add Keychains to Order" +
            "\n2) Remove Keychains from Order\n3) View Current Order" +
            "\n4) Checkout");
            System.out.print("\nPlease enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            
            if (input == 1) {
                add_keychains();
            }
            if (input == 2) {
                remove_keychains();
            }
            if (input == 3) {
                view_order();
            }
            if (input == 4) {
                checkout();
                isRunning = false;
            }
        }
    }
    
    public static void add_keychains() {
        System.out.println("\nADD KEYCHAINS");
    }
    
    public static void remove_keychains() {
        System.out.println("\nREMOVE KEYCHAINS");
    }
    
    public static void view_order() {
        System.out.println("\nVIEW ORDER");
    }
    
    public static void checkout() {
        System.out.println("\nCHECKOUT");
    }
}
