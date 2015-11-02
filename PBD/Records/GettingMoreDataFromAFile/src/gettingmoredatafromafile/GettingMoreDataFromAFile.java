/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gettingmoredatafromafile;

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
class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class GettingMoreDataFromAFile {

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
            
            Person[] array = new Person[5];
            
            int i = 0;
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] prop = line.split(",");
                
                array[i++] = new Person(prop[0], Integer.parseInt(prop[1]));
            }
            
            
            for (int j = 0; j < array.length; j++) {
                System.out.println(String.format("%s is %d", array[j].name, array[j].age));
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GettingMoreDataFromAFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
