/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingwhile;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class CountingWhile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner keyboard = new Scanner(System.in);

        System.out.println( "Type in a message, and I'll display it several times." );
        System.out.print( "Message: " );
        String message = keyboard.nextLine();
        System.out.print("How many times? ");
        int limit = Integer.parseInt(keyboard.nextLine());
        
        int n = 0;
        while ( n < limit )
        {
            System.out.println( ((n+1)*10) + ". " + message );
            n++;
        }
    }
    
}
