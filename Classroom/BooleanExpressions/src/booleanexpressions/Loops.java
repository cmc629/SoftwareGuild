/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanexpressions;

/**
 *
 * @author apprentice
 */
public class Loops {
    
    public static void main(String[] args) {
        
        boolean result = false;
        
//        do {
//            //execute code
//        } while (result); //the checking of the condition happens at the end
//                          //so there is a guarantee that the code will run once
//        
//        while (result) {
//            //execute code
//            
//            result = false;
//            
//        }
        
        for (int counter = 0; counter < 10; counter++) {
            
            System.out.println("Counter: " + counter);
            
        }
        
    }
}
