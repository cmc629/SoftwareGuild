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
public class Employee {
    
    private String first;
    private String last;
    private int age;
    private double wagePerHour;
    private double dailyHoursWorked;

    public Employee(String first, String last, int age, double wagePerHour, double dailyHoursWorked) {
        this.first = first;
        this.last = last;
        this.age = age;
        this.wagePerHour = wagePerHour;
        this.dailyHoursWorked = dailyHoursWorked;
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

    public double getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(double wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    public double getDailyHoursWorked() {
        return dailyHoursWorked;
    }

    public void setDailyHoursWorked(double dailyHoursWorked) {
        this.dailyHoursWorked = dailyHoursWorked;
    }

    
    public void printFullName() {
        System.out.println("Employee's Name: " + this.first + " " + this.last);
    }
    
    public double getWeeklyEarnings() {
        return this.dailyHoursWorked * this.wagePerHour * 5.0;
    }
    
}
