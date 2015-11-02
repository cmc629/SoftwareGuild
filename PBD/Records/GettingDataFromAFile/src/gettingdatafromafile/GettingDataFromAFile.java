/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gettingdatafromafile;

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
class Dog {
    String breed;
    int age;
    double weight;
    
}

public class GettingDataFromAFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        load();
        
    }
    
    public static void load() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Which file to open: ");
        String fileName = keyboard.nextLine();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
            System.out.println("Reading date from " + fileName);
            System.out.println();
            
            Dog dog1 = new Dog();
            dog1.breed = sc.nextLine();
            dog1.age = Integer.parseInt(sc.nextLine());
            dog1.weight = Double.parseDouble(sc.nextLine());
            
            Dog dog2 = new Dog();
            dog2.breed = sc.nextLine();
            dog2.age = Integer.parseInt(sc.nextLine());
            dog2.weight = Double.parseDouble(sc.nextLine());
            
            System.out.println(String.format("First dog: %s, %d, %.2f", dog1.breed, dog1.age, dog1.weight));
            System.out.println(String.format("Second dog: %s, %d, %.2f", dog2.breed, dog2.age, dog2.weight));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GettingDataFromAFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
