/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowmaster;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WindowMaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float height;
        float width;
        
        String stringHeight;
        String stringWidth;
        
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        
        Scanner sc = new Scanner(System.in);
        
        //Get input from user
        System.out.println("Please enter window height: ");
        stringHeight = sc.nextLine();
        
        System.out.println("Please enter window width: ");
        stringWidth = sc.nextLine();
        
        //Convert STring values of height and width to floats
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);
        
        //Calculate the area of window
        areaOfWindow = height * width;
        
        //Calculate the perimeter of window
        perimeterOfWindow = 2 * (height + width);
        
        //Calculate total cost- use hard coded values for material cost
        //hard coded means you put the values directly in code
        cost = (3.50f * areaOfWindow) + (2.25f * perimeterOfWindow);
        
        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        
        String formattedCost = String.format("%.2f", cost);
        
        System.out.println("Total cost = " + formattedCost);
        
    }
    
}
