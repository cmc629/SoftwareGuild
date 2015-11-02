/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class Exceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        try {
//            
//            Scanner sc = new Scanner(new BufferedReader(new FileReader("out.txt")));
//            //PrintWriter out = new PrintWriter(new FileWriter("out.txt")); 
//        } 
//        
//        catch (IOException ex) { //specify type of exception
//            
//            ex.printStackTrace();  
//            //Logger.getLogger(Exceptions.class.getName()).log(Level.SEVERE, null, ex);
//            
//        } finally {
//            
//            int i = 0;
//            
//        }
        
//        TestBrokenMethod tbm = new TestBrokenMethod();
//        
//        try {
//            tbm.divide(11, 1);
//        } catch (IOException ex) {
//            System.out.println("io exception");
//        } catch (IllegalArgumentException ex) {
//            System.out.println("illegal argument");
//        }
        
        //example of unchecked exception
        String s = null;
        if (s != null) {
            s.toString();
        }
    }
    
    
}
