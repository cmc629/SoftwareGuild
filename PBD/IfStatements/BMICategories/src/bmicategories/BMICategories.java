/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmicategories;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class BMICategories {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int feet, inches, pounds;

            Scanner keyboard = new Scanner(System.in);

            System.out.print("Your height (feet only): ");
            feet = keyboard.nextInt();

            System.out.print("Your height (inches): ");
            inches = keyboard.nextInt();

            System.out.print("Your weight in pounds: ");
            pounds = keyboard.nextInt();

            double m = (12 * feet + inches) * 0.0254;
            double kg = pounds * 0.453592;
            double bmi = kg / (m * m);

            System.out.println("\nYour BMI is " + bmi);
            
            String category;
            if (bmi < 18.5) {
                category = "underweight";
            } else if (bmi < 25.0) {
                category = "normal weight";
            } else if (bmi < 30.0) {
                category = "overweight";
            } else {
                category = "obese";
            }
            System.out.println("BMI Category: " + category);
    }

}


