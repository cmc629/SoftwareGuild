/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refresherchallenge;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class RefresherChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = sc.nextLine();
        
        int length = 10;
        if (name.equals("Mitchell")) length = 5;
        for (int i = 0; i < length; i++) {
            System.out.println(name);
        
        }
        
    }
    
}
