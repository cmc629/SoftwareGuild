/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicarrays3;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class BasicArrays3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] array = new int[1000];
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            array[i] = 10 + r.nextInt(90);
            System.out.println(array[i]);
            
        }
        
    }
    
}
