/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storingdatainafile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
class Car {
    String make;
    String model;
    int year;
    String number;
    
    public Car(String make, String model, int year, String number) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.number = number;
    }
    
}

public class StoringDataInAFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Car[] array = new Car[5];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Car %s", i + 1);
            System.out.println();
            System.out.print("\tMake: ");
            String make = sc.nextLine();
            System.out.print("\tModel: ");
            String model = sc.nextLine();
            System.out.print("\tYear: ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("\tLicense: ");
            String number = sc.nextLine();
            System.out.println();
            
            array[i] = new Car(make, model, year, number);
        }
        
        write(array);
        
    }
    
    public static void write(Car[] array) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("To which file do you want to save this information? ");
        String fileName = sc.nextLine();
        
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            
            for (Car car : array) {
                out.printf("%s %s %d %s", car.make, car.model, car.year, car.number);
                out.println();
            }
            
            out.flush();
            out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(StoringDataInAFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
