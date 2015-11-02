/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import flooringmastery.controller.FlooringMasteryController;
import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 *
 * @author Christian Choi
 */
public class FlooringMastery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        FlooringMasteryController fmc = new FlooringMasteryController();
        fmc.run();
    }
    
}
