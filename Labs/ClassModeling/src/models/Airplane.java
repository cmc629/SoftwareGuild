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
public class Airplane {
    
    private int capacity;
    private double altitude = 0;
    private boolean isBathroomVacant = true;
    private double mileage;
    private String name;

    public Airplane(int capacity, double mileage, String name) {
        this.capacity = capacity;
        this.mileage = mileage;
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public boolean isIsBathroomVacant() {
        return isBathroomVacant;
    }

    public void setIsBathroomVacant(boolean isBathroomVacant) {
        this.isBathroomVacant = isBathroomVacant;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void updateCapacity(int number) {
        this.capacity += number;
    }
    
    public void personEnterBathroom() {
        this.isBathroomVacant = true;
    }
}
