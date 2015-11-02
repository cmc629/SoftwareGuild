/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticingevennumbers;

/**
 *
 * @author Christian Choi
 */
public class NoticingEvenNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " <");
            }
            else {
                System.out.println(i);
            }
        }
        
    }
    
}
