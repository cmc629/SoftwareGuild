/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lildatabase;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
class Student {
    String name;
    int grade;
    double average;
    
    public Student(String name, int grade, double average) {
        this.name = name;
        this.grade = grade;
        this.average = average;
    }
}

public class LilDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Student[] array = new Student[3];
        
        System.out.print("Enter the student 1's name: ");
        String name = sc.nextLine();
        System.out.print("Enter the student 1's grade: ");
        int grade = sc.nextInt();
        System.out.print("Enter the student 1's average: ");
        double average = sc.nextDouble();
        sc.nextLine();
        System.out.println();
        array[0] = new Student(name, grade, average);
        
        System.out.print("Enter the student 2's name: ");
        name = sc.nextLine();
        System.out.print("Enter the student 2's grade: ");
        grade = sc.nextInt();
        System.out.print("Enter the student 2's average: ");
        average = sc.nextDouble();
        sc.nextLine();
        System.out.println();
        array[1] = new Student(name, grade, average);
        
        System.out.print("Enter the student 3's name: ");
        name = sc.nextLine();
        System.out.print("Enter the student 3's grade: ");
        grade = sc.nextInt();
        System.out.print("Enter the student 3's average: ");
        average = sc.nextDouble();
        System.out.println();
        array[2] = new Student(name, grade, average);
        
        System.out.println(String.format("The names are: %s %s %s", array[0].name, array[1].name, array[2].name));
        System.out.println(String.format("Teh grades are: %s %s %s", array[0].grade, array[1].grade, array[2].grade));
        System.out.println(String.format("The averages are: %.1f %.1f %.1f", array[0].average, array[1].average, array[2].average));
        
        System.out.println("\nThe average for the three students is: " + (array[0].average + array[1].average + array[2].average)/3);
    }
    
}