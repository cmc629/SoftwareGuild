/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encodingdecoding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class EncodingDecoding {
    
    private static Map<Integer, Student> students = new HashMap<>();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        decode("students.txt");
        
//        Student student = new Student();
//        student.setId(1);
//        student.setFirstName("Mary");
//        student.setLastName("Swanson");
//        student.setClassName("Java August 2015");
//        
//        students.put(student.getId(), student);
//                
//        Student student2 = new Student();
//        student2.setId(2);
//        student2.setFirstName("Bill");
//        student2.setLastName("Jones");
//        student2.setClassName("Java August 2015");
//        
//        students.put(student2.getId(), student2);
//        
//        Student student3 = new Student();
//        student3.setId(3);
//        student3.setFirstName("James");
//        student3.setLastName("Smith");
//        student3.setClassName("Java August 2015");
//        
//        students.put(student3.getId(), student3);
//        
//        encode("students.txt");;

    }
    
    private static void encode(String fileName) {
        
        try {
            //to write to file we need printwriter
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            
            for (Integer key : students.keySet()) {
                
                Student student = students.get(key);
                //%d means number, %s means string %followed by letter is a placeholder
                writer.printf("%d::%s::%s::%s", 
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getClassName()
                        );
                
                writer.println("");
                
            }
            
            writer.flush();
            writer.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(EncodingDecoding.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //read the file
    private static void decode(String fileName) {
        
        try {
            
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
            
            while(sc.hasNext()) {
                
                String line = sc.nextLine();
                
                String[] properties = line.split("::"); //turn string to array and split by the token ::
                //create a new student object from in-memory
                Student student = new Student();
                student.setId(Integer.parseInt(properties[0]));
                student.setFirstName(properties[1]);
                student.setLastName(properties[2]);
                student.setClassName(properties[3]);
                
                students.put(student.getId(), student);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EncodingDecoding.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
