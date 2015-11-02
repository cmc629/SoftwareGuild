/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letterrevisited;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class LetterRevisited {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            PrintWriter out = new PrintWriter(new FileWriter("letter.txt"));
            out.println("+-------------------------------------------+");
            out.println("|                                      #### |");
            out.println("|                                      #### |");
            out.println("|                                      #### |");
            out.println("|                                           |");
            out.println("|                                           |");
            out.println("|                       Bill Gates          |");
            out.println("|                       1 Microsoft Way     |");
            out.println("|                       Redmond, WA 98104   |");
            out.println("|                                           |");
            out.println("+-------------------------------------------+");
            
            out.flush();
            out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(LetterRevisited.class.getName()).log(Level.SEVERE, null, ex);
        }
            
               
    }
    
}
