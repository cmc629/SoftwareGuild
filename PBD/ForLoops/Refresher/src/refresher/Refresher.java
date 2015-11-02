/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refresher;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Refresher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("What is your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        
        if (name.equals("Mitchell")) {
            for (int i = 0; i < 5; i++) {
                System.out.println(name);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                System.out.println(name);
            }
        }
    }
    
}
