/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vowelcapitalization;

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
public class VowelCapitalization {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Open which file: ");
        String fileName = keyboard.nextLine();
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
            while(sc.hasNext()) {
                String line = sc.nextLine();
                line = line.replace("a", "A");
                line = line.replace("e", "E");
                line = line.replace("i", "I");
                line = line.replace("o", "O");
                line = line.replace("u", "U");
                System.out.println(line);
                }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(VowelCapitalization.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
} 

