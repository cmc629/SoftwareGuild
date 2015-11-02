/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplewebinput;

import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class SimpleWebInput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        URL mcool = new URL("https://cs.leanderisd.org/mitchellis.txt");
        Scanner webIn = new Scanner(mcool.openStream());
            
//        
//        String one = webIn.nextLine();
//        
//        webIn.close();
//        System.out.println(one);
        while(webIn.hasNextLine()) {
            System.out.println(webIn.nextLine());
        }    
        webIn.close();
        
    }
    
}
