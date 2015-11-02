
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
public class WhatIsYourNumber {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please give me an integer: ");
        int number = Integer.parseInt(sc.nextLine());
        
        System.out.println("Here are the numbers from 1 to your number, inclusive:");
        for (int i = 0; i <= number; i++) {
            System.out.println(i);
        }
        
    }
    
}
