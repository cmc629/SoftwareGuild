/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summingseveralnumbersfromanyfile;

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
public class SummingSeveralNumbersFromAnyFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Which file would you like to read numbers from: ");
        String file = keyboard.nextLine();
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
            int total = 0;
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                total += num;
                System.out.print(num + " ");
            }
            System.out.println("\nTotal is " + total);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SummingSeveralNumbersFromAnyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
