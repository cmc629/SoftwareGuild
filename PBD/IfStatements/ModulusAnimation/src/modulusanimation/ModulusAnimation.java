/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulusanimation;

/**
 *
 * @author apprentice
 */
public class ModulusAnimation {

    /**
     * @param args the command line arguments
     */
    
    public static void main( String[] args ) throws Exception {
	for (int i = 0; i < 80; i++) {
            if (i % 10 == 0) 
                System.out.print(" Mr. Mitchell is cool. \r");

            Thread.sleep(200);
            
        }
		
    }
}
