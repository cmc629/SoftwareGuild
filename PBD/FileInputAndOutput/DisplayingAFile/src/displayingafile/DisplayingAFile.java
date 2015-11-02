/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displayingafile;

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
public class DisplayingAFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Open which file: ");
        String name = keyboard.nextLine();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(name)));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisplayingAFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
