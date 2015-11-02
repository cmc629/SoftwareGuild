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
public class Manager {
    
    private String first;
    private String last;
    private int age;
    private int numberOfEmployees;
    private double salary;

    public Manager(String first, String last, int age, int numberOfEmployees, double salary) {
        this.first = first;
        this.last = last;
        this.age = age;
        this.numberOfEmployees = numberOfEmployees;
        this.salary = salary;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void printFullName() {
        System.out.println("Manager Name: " + this.first + " " + this.last);
    }
    
    public void fireEmployee() {
        this.numberOfEmployees--;
    }
    
    
}
