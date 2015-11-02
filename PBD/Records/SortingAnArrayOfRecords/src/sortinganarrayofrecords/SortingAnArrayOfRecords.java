/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortinganarrayofrecords;

/**
 *
 * @author Christian Choi
 */
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

public class SortingAnArrayOfRecords {

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
            
            Car[] array = new Car[5];
            
            //Create each car object and put them into the array
            int idx = 0;
            while (sc.hasNext()) {
                
                String line = sc.nextLine();
                String[] prop = line.split(" ");
                Car car = new Car(prop[0], prop[1], Integer.parseInt(prop[2]), prop[3]);
                array[idx++] = car;
            
            }
            
            //Used selection sort in ascending year order
            int earliest;
            int earliestIdx;
            for (int i = 0; i < array.length - 1; i++) {
                earliest = array[i].year;
                earliestIdx = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j].year < earliest) {
                        earliestIdx = j;
                    }
                }
                if (i != earliestIdx) {
                    Car temp = array[i];
                    array[i] = array[earliestIdx];
                    array[earliestIdx] = temp;
                }
            }
            System.out.println("Data sorted.\n");
            
            for (int x = 0; x < array.length; x++) {
                
                System.out.printf("Car %s\n", x+1);
                System.out.printf("\tMake: %s\n", array[x].make);
                System.out.printf("\tModel: %s\n", array[x].model);
                System.out.printf("\tYear: %d\n", array[x].year);
                System.out.printf("\tLicense: %s\n", array[x].number);
            
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SortingAnArrayOfRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
