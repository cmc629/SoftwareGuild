/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradesinanarrayandafile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class GradesInAnArrayAndAFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Name (first last): ");
        String name = sc.nextLine();
        System.out.print("Filename: ");
        String textName = sc.nextLine();
        
        Random r = new Random();
        System.out.println("\nHere are your randomly-selected grades (hope you pass):");
        int num1 = 1 + r.nextInt(100);
        int num2 = 1 + r.nextInt(100);
        int num3 = 1 + r.nextInt(100);
        int num4 = 1 + r.nextInt(100);
        int num5 = 1 + r.nextInt(100);
        System.out.println("Grade 1: " + num1);
        System.out.println("Grade 2: " + num2);
        System.out.println("Grade 3: " + num3);
        System.out.println("Grade 4: " + num4);
        System.out.println("Grade 5: " + num5);
        
        try {
            PrintWriter out = new PrintWriter(new FileWriter(textName));
            out.println("Name: " + name);
            out.println("Grade 1: " + num1);
            out.println("Grade 2: " + num2);
            out.println("Grade 3: " + num3);
            out.println("Grade 4: " + num4);
            out.println("Grade 5: " + num5);
            
            out.flush();
            out.close();
            System.out.println("\nDate saved in \""+ textName + "\"");
        } catch (IOException ex) {
            Logger.getLogger(GradesInAnArrayAndAFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
