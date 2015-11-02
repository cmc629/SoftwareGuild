/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
public class FileIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            PrintWriter out = new PrintWriter(new FileWriter("out.txt"));
            
            out.println("this is the first line");
            out.println("this is the second line");
            out.println("this is the third line");
            
            out.flush();
            out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            Scanner sc = new Scanner(new BufferedReader(new FileReader("out.txt")));
            
            //loop through every line in file
            while(sc.hasNextLine()) {
                
                String currentLine = sc.nextLine();
                System.out.println(currentLine);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
