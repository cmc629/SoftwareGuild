/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomness;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class Randomness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r = new Random();

        int x = 1 + r.nextInt(10);

        System.out.println( "My random number is " + x );

        System.out.println( "Here are some numbers from 1 to 5!" );
        System.out.print( 1 + r.nextInt(5) + " " );
        System.out.print( 1 + r.nextInt(5) + " " );
        System.out.print( 1 + r.nextInt(5) + " " );
        System.out.print( 1 + r.nextInt(5) + " " );
        System.out.print( 1 + r.nextInt(5) + " " );
        System.out.print( 1 + r.nextInt(5) + " " );
        System.out.println();

        System.out.println( "Here are some numbers from 1 to 100!" );
        System.out.print( 1 + r.nextInt(100) + "\t" );
        System.out.print( 1 + r.nextInt(100) + "\t" );
        System.out.print( 1 + r.nextInt(100) + "\t" );
        System.out.print( 1 + r.nextInt(100) + "\t" );
        System.out.print( 1 + r.nextInt(100) + "\t" );
        System.out.print( 1 + r.nextInt(100) + "\t" );
        System.out.println();

        int num1 = 1 + r.nextInt(10);
        int num2 = 1 + r.nextInt(10);

        if ( num1 == num2 )
        {
                System.out.println( "The random numbers were the same! Weird." );
        }
        if ( num1 != num2 )
        {
                System.out.println( "The random numbers were different! Not too surprising, actually." );
        }
        
    }
    
}
