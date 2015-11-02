/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingwhatyouwrote;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class ReadingWhatYouWrote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        load();
        
    }
    
    public static void load() {
        
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("From which file do you want to load this information? ");
        String fileName = keyboard.nextLine();
        
        try {
            
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
            System.out.println("Data loaded.\n");
            
            int num = 1;
            while (sc.hasNext()) {
                
                String line = sc.nextLine();
                String[] prop = line.split(" ");
                
                System.out.printf("Car %s\n", num++);
                System.out.printf("\tMake: %s\n", prop[0]);
                System.out.printf("\tModel: %s\n", prop[1]);
                System.out.printf("\tYear: %s\n", prop[2]);
                System.out.printf("\tLicense: %s\n", prop[3]);
            
        }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadingWhatYouWrote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
