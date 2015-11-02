/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinlockout;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class PinLockout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        int pin = 12345;
        int tries = 0;

        System.out.println("WELCOME TO THE BANK OF MITCHELL.");
        System.out.print("ENTER YOUR PIN: ");
        int entry = keyboard.nextInt();
        tries++;

        while ( entry != pin && tries < 4 )
        {
            System.out.println("\nINCORRECT PIN. TRY AGAIN.");
            System.out.print("ENTER YOUR PIN: ");
            entry = keyboard.nextInt();
            tries++;
        }

        if ( entry == pin )
            System.out.println("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
        else if ( tries >= 4 )
            System.out.println("\nYOU HAVE RUN OUT OF TRIES. ACCOUNT LOCKED.");
        
    }
    
}
