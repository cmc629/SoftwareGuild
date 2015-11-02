/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flipagain;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class FlipAgain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Program works even if again is not set to "y" since condition is set at the end of the loop and by then again is set to either "y" or "n"
        Scanner keyboard = new Scanner(System.in);
        Random rng = new Random();

        String again;

        do {
            int flip = rng.nextInt(2);
            String coin;

            if ( flip == 1 )
                    coin = "HEADS";
            else
                    coin = "TAILS";

            System.out.println( "You flip a coin and it is... " + coin );

            System.out.print( "Would you like to flip again (y/n)? " );
            again = keyboard.next();
        } while (again.equals("y"));

    }
    
}
