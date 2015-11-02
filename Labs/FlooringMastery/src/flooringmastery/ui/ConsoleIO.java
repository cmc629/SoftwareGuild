/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.ui;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class ConsoleIO {
    
    Scanner sc = new Scanner(System.in);

    public int promptInt(String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            String stringInput = sc.nextLine();
            try {
                value = Integer.parseInt(stringInput);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input. Try again");
            }
        }
        return value;
    }
    
    public int promptInt(String prompt, int min, int max) {
        int value = 0;
        while (true) {
            try {
                boolean isRunning = true;
                while (isRunning) {
                    System.out.print(prompt);
                    value = Integer.parseInt(sc.nextLine());
                    if (value > max || value < min) {
                        System.out.println("Invalid input. Try again.");
                    }
                    else {
                        isRunning = false;
                    }
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Try again.");
            }
        }
        return value;
    }
    
    public String promptString(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String value = sc.nextLine();
        return value;
    }
     
    public float promptFloat(String prompt) {
        float value = 0.0f;
        while (true) {
            System.out.print(prompt);
            String stringInput = sc.nextLine();
            try {
                value = Float.parseFloat(stringInput);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input. Try again");
            }
        }
        return value;
    }
    
    public float promptFloat(String prompt, float min, float max) {
        float value = 0.0f;
        while (true) {
            try {
                boolean isRunning = true;
                while (isRunning) {
                    System.out.print(prompt);
                    value = Float.parseFloat(sc.nextLine());
                    if (value > max || value < min) {
                        System.out.println("Invalid input. Try again.");
                    }
                    else {
                        isRunning = false;
                    }
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Try again.");
            }
        }
        return value;
    }
        
    public double promptDouble(String prompt) {
        double value = 0.0;
        while (true) {
            System.out.print(prompt);
            String stringInput = sc.nextLine();
            try {
                value = Double.parseDouble(stringInput);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input. Try again");
            }
        }
        return value;
    }
    
    public double promptDouble(String prompt, double min, double max) {
        double value = 0.0;
        while (true) {
            try {
                boolean isRunning = true;
                while (isRunning) {
                    System.out.print(prompt);
                    String input = sc.nextLine();
                    if (input.equals("")) {
                        return Double.NaN;
                    }
                    value = Double.parseDouble(input);
                    if (value > max || value < min) {
                        System.out.println("Invalid input. Try again.");
                    }
                    else {
                        isRunning = false;
                    }
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Try again.");
            }
        }
        return value;
    }
    
    public void println(String prompt) {
        System.out.println(prompt);
    }
    
    public void print(String prompt) {
        System.out.print(prompt);
    }
}

