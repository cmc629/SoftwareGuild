/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Christian Choi
 */
public class TestBrokenMethod {
    
    public int divide(int x, int y) throws IllegalArgumentException, IOException {
        
        if (y == 0) {
            throw new IllegalArgumentException();
        }
        
        if (x > 4) {
            throw new IOException();
        }
        
        return 0;
    }
    
}
