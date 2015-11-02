/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keychains3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Keychains3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int keychain = 0;
        double price = 10;
        double tax = 0.0825;
        int baseShipping = 5;
        int additionalPerShipping = 1;
        System.out.println("Ye Olde Keychain Shoppe");
        boolean isRunning = true;
        while (isRunning) {
            boolean isValid = false;
            int input = 0;
            while (!isValid) {
                System.out.println("\n1) Add Keychains to Order" +
                "\n2) Remove Keychains from Order\n3) View Current Order" +
                "\n4) Checkout");
                System.out.print("\nPlease enter your choice: ");
                Scanner sc = new Scanner(System.in);
                try {
                    input = sc.nextInt();
                    if (input >= 1 && input <= 4) {
                        isValid = true;
                    }
                    else System.out.println("Invalid input.");
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input.");
                }
            }
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
                view_order(keychain, price, tax, baseShipping, additionalPerShipping);
            }
            if (input == 4) {
                checkout(keychain, price, tax, baseShipping, additionalPerShipping);
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
        if (remove > keychains) {
            System.out.println("You cannot remove more than you have. Enter again.");
            keychains = remove_keychains(keychains);
        } else {
            keychains -= remove;
        }
        return keychains;
    }
    
    public static void view_order(int num, double cost, double tax, int base, int perKeychain) {
        System.out.println("You have " + num + " key chains.");
        System.out.println("Keychains cost $" + cost + " each.");
        int shipping = base + (num*perKeychain);
        System.out.println("Shipping charges amount to $" + shipping + ".");
        double subtotal = shipping + (num * cost);
        System.out.println("Subtotal before tax is $" + subtotal + ".");
        double taxOrder = tax * subtotal;
        System.out.println("Tax on the order is $ " + taxOrder + ".");
        double finalCost = subtotal + taxOrder;
        System.out.println("Total cost is $" + finalCost + ".");
        
    }
    
    public static void checkout(int num, double cost, double tax, int base, int perKeychain) {
        System.out.println("CHECKOUT");
        System.out.print("\nWhat is your name? ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        view_order(num, cost, tax, base, perKeychain);
        System.out.println("Thanks for your order, " + name + "!");
    }
    
}