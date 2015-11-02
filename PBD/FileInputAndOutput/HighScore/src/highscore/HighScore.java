/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highscore;

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
public class HighScore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("You got a high score!");
        
        System.out.print("Please enter your score: ");
        String highscore = sc.nextLine();
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        
        try {
            PrintWriter out = new PrintWriter(new FileWriter("score.txt"));
            
            out.println("Name: " + name + ", High Score: " + highscore);
            
            out.flush();
            out.close();
            
            System.out.println("Data stored into score.txt");
        } catch (IOException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
