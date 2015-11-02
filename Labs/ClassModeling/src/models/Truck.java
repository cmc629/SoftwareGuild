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
public class Truck {
    
    private String licensePlate;
    private boolean hasPackage;
    private int mileage = 0;
    private int oilLife = 100;
    private boolean isInflated = true;

    public Truck(String licensePlate, boolean hasPackage) {
        this.licensePlate = licensePlate;
        this.hasPackage = hasPackage;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isHasPackage() {
        return hasPackage;
    }

    public void setHasPackage(boolean hasPackage) {
        this.hasPackage = hasPackage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
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
    
    public void getMaintenence() {
        this.isInflated = true;
        this.oilLife = 100;
    }
    
    public void deliveredPackage() {
        this.hasPackage = false;
    }
    
}
