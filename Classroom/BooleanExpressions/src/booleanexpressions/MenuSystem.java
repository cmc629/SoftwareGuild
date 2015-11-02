/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanexpressions;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MenuSystem {
    
    final static int MIN_MENU_OPTION = 1;
    final static int MAX_MENU_OPTION = 5;
    final static int EXIT_OPTION = 6;
    
    public static void main(String[] args) {
        
        Random rGenerator = new Random();
        int randomNumber = rGenerator.nextInt(10);
        
        
        Scanner sc = new Scanner(System.in);
        
        boolean shouldContinue = true;
        
        while (shouldContinue) {
            
            System.out.println("Please enter a number between 1 and 5. Enter 6 to exit");
            String stringInput = sc.nextLine();
            
            int input = Integer.parseInt(stringInput);
            
            if (input < MIN_MENU_OPTION || input > EXIT_OPTION) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            
            switch (input) {
                
                case 1:
                    System.out.println("You entered: 1");
                    break;
                case 2:
                    System.out.println("You entered: 2");
                    break;
                case 3:
                    System.out.println("You entered: 3");
                    break;
                case 4:
                    System.out.println("You entered: 4");
                    break;
                case 5:
                    System.out.println("You entered: 5");
                    break;
                case 6:
                    shouldContinue = false;
                    break;
            }
            
        }
        
        System.out.println("goodbye");
        
    }
    
}
