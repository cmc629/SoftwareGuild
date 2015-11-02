/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowmasterv2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WindowMasterV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Get values of height, width, glassCost, and trimCost
        float height = askDimensions("height");
        float width = askDimensions("width");
        float glassCost = askCost("glass");
        float trimCost = askCost("trim");
        
        //Calculate the area of window
        float areaOfWindow = height * width;
        
        //Calculate the perimeter of window
        float perimeterOfWindow = 2 * (height + width);
                
        //Calculate total cost
        float totalCost = (glassCost * areaOfWindow) + (trimCost * perimeterOfWindow);
        
        //Print out window height, width, area, and perimeter
        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        
        //Format so cost show up in two decimals
        printTwoDecimals("Glass", glassCost);
        printTwoDecimals("Trim", trimCost);
        printTwoDecimals("Total", totalCost);
        
    }

    public static float askDimensions(String stringDimension) throws NumberFormatException {
        String stringDimensionInput;
        Scanner sc = new Scanner(System.in);
        float dimension = 0.0f;
        
        boolean notValid = true;
        while (notValid) {
            
            System.out.println("Please enter window " + stringDimension + " between 1-100");
            stringDimensionInput = sc.nextLine();
            //converts string to float
            dimension = Float.parseFloat(stringDimensionInput);
            //checks to see if dimension falls between 1-100
            if (dimension < 1 || dimension > 100) {
                System.out.println("Please enter a valid " + stringDimension + "!");
            }
            else {
                notValid = false; //set to false to get out of loop
            }
        }
        return dimension;
    }
    
    public static float askCost(String materials) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("How much does the " + materials + " cost? ");
        String materialsInput = sc.nextLine();
        float price = Float.parseFloat(materialsInput);
        String formattedCost = String.format("%.2f", price);
        
        System.out.println("The cost of " + materials + " is $" + formattedCost + ".");
        
        return price;
    }
    
    public static void printTwoDecimals(String material, float cost) {
        String formattedCost = String.format("%.2f", cost);
        System.out.println(material + " cost = $" + formattedCost);
    }
    
}

