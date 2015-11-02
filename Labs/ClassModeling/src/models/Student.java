/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Christian Choi
 */
public class Student {
    
    private double gpa;
    private String last;
    private String first;
    private int age;
    private int birthYear;

    public Student(double gpa, String last, String first, int age, int birthYear) {
        this.gpa = gpa;
        this.last = last;
        this.first = first;
        this.age = age;
        this.birthYear = birthYear;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    
    public void printFullName() {
        System.out.println("Student's name: " + this.first + " " + this.last);
    }
    
    public int getYearOfCollegeGraduation() {
        return this.birthYear + 22;
    }
    
}
