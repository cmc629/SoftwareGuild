/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summingthreenumbersfromafile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class SummingThreeNumbersFromAFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("3nums.txt")));
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            System.out.println("Reading numbers from file \"3nums.txt\"...done.");
            System.out.println();
            System.out.println(a + " + " + b + " + " + c + " = " + (a+b+c));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SummingThreeNumbersFromAFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
