/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlepuzzle;

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
public class LittlePuzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Open which file: ");
        String file = keyboard.nextLine();
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
            String puzzle = sc.nextLine();
            for (int i = 2; i < puzzle.length(); i+=3) {
                System.out.print(puzzle.charAt(i));
            }
            System.out.println();
//            System.out.println("Printing out thrown away letters");
//            int count = 0;
//            for (int i = 0; i < puzzle.length(); i++) {
//                if (count!=2) {
//                    System.out.print(puzzle.charAt(i));
//                    count++;
//                } else {
//                    count = 0;
//                }
//            }
            System.out.println("Printing out thrown away letters");
            int count = 0;
            for (int i = 0; i < puzzle.length(); i+=3) {
                System.out.print(puzzle.charAt(i));
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LittlePuzzle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
