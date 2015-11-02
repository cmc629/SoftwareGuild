/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrecords;

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

public class BasicRecords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first student's name: ");
        String name = sc.nextLine();
        System.out.print("Enter the first student's grade: ");
        int grade = sc.nextInt();
        System.out.print("Enter the first student's average: ");
        double average = sc.nextDouble();
        sc.nextLine();
        System.out.println();
        Student first = new Student(name, grade, average);
        
        System.out.print("Enter the second student's name: ");
        name = sc.nextLine();
        System.out.print("Enter the second student's grade: ");
        grade = sc.nextInt();
        System.out.print("Enter the second student's average: ");
        average = sc.nextDouble();
        sc.nextLine();
        System.out.println();
        Student second = new Student(name, grade, average);
        
        System.out.print("Enter the third student's name: ");
        name = sc.nextLine();
        System.out.print("Enter the third student's grade: ");
        grade = sc.nextInt();
        System.out.print("Enter the third student's average: ");
        average = sc.nextDouble();

        System.out.println();
        Student third = new Student(name, grade, average);
        
        System.out.println(String.format("The names are: %s %s %s", first.name, second.name, third.name));
        System.out.println(String.format("Teh grades are: %s %s %s", first.grade, second.grade, third.grade));
        System.out.println(String.format("The averages are: %.1f %.1f %.1f", first.average, second.average, third.average));
        
        System.out.println("\nThe average for the three students is: " + (first.average + second.average + third.average)/3);
    }
    
}
