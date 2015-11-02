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
public class Car {
    
    private String model;
    private String make;
    private int year;
    private String licensePlate;
    private String color;
    private int oilLife = 100;
    private boolean isInflated = true;

    public Car(String model, String make, int year, String licensePlate, String color) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.licensePlate = licensePlate;
        this.color = color;
    }

    public int getOilLife() {
        return oilLife;
    }

    public void setOilLife(int oilLife) {
        this.oilLife = oilLife;
    }

    public boolean isIsInflated() {
        return isInflated;
    }

    public void setIsInflated(boolean isInflated) {
        this.isInflated = isInflated;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void printCarDetails() {
        System.out.println("Model: " + this.model + ", Make: " + this.make + ", Year: " + this.year);
    }
    
    public void getMaintenance() {
        this.isInflated = true;
        this.oilLife = 100;
    }
    
}
