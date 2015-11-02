/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keychains2;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Keychains2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int keychain = 0;
        int price = 10;
        System.out.println("Ye Olde Keychain Shoppe");
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n1) Add Keychains to Order" +
            "\n2) Remove Keychains from Order\n3) View Current Order" +
            "\n4) Checkout");
            System.out.print("\nPlease enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            System.out.println();
            
            if (input == 1) {
                keychain = add_keychains(keychain);
                System.out.println("You now have " + keychain + " keychains.");
            }
            if (input == 2) {
                keychain = remove_keychains(keychain);
                System.out.println("You now have " + keychain + " keychains.");
            }
            if (input == 3) {
                view_order(keychain, price);
            }
            if (input == 4) {
                checkout(keychain, price);
                isRunning = false;
            }
        }
    }
    
    public static int add_keychains(int keychains) {
        System.out.print("You have " + keychains + " keychains. How many to add? ");
        Scanner sc = new Scanner(System.in);
        int add = sc.nextInt();
        keychains += add;
        return keychains;
    }
    
    public static int remove_keychains(int keychains) {
        System.out.print("You have " + keychains + " keychains. How many to remove? ");
        Scanner sc = new Scanner(System.in);
        int remove = sc.nextInt();
        keychains -= remove;
        return keychains;
    }
    
    public static void view_order(int num, int cost) {
        System.out.println("You have " + num + " key chains.");
        System.out.println("Keychains cost $" + cost + " each.");
        System.out.println("Total cost is " + (num*cost) + ".");
        
    }
    
    public static void checkout(int num, int cost) {
        System.out.println("CHECKOUT");
        System.out.print("\nWhat is your name? ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        view_order(num, cost);
        System.out.println("Thanks for your order, " + name + "!");
    }
    
}
