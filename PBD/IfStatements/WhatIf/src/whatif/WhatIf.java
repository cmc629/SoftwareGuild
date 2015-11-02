/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatif;

/**
 *
 * @author apprentice
 */
public class WhatIf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
                int people = 30;
		int cats = 30;
		int dogs = 15;
                
                //if statements are used so that if a condition is met, the
                //code written within the curly braces is exexcuted
                //value of people changed to 30 to avoid any cat messages
		if ( people < cats ) {
                    System.out.println( "Too many cats!  The world is doomed!" );
		}

		if ( people > cats ) {
                    System.out.println( "Not many cats!  The world is saved!" );
		}

		if ( people < dogs ) {
                    System.out.println( "The world is drooled on!" );
		}

		if ( people > dogs ) {
                    System.out.println( "The world is dry!" );
		}

		dogs += 5;

		if ( people >= dogs ) {
                    System.out.println( "People are greater than or equal to dogs." );
		}

		if ( people <= dogs ) {
                    System.out.println( "People are less than or equal to dogs." );
		}

		if ( people == dogs ) {
                    System.out.println( "People are dogs." );
		}
    }
    
}
