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
public class Couch {
    
    private String color;
    private int timesSat;
    private int numberCushions;
    private int numberPillows = 2;
    private boolean hasPillow = true;
    private String material; //leather? vinyl? cotton polyester?

    public Couch(String color, int timesSat, int numberCushions, String material) {
        this.color = color;
        this.timesSat = timesSat;
        this.numberCushions = numberCushions;
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTimesSat() {
        return timesSat;
    }

    public void setTimesSat(int timesSat) {
        this.timesSat = timesSat;
    }

    public int getNumberCushions() {
        return numberCushions;
    }

    public void setNumberCushions(int numberCushions) {
        this.numberCushions = numberCushions;
    }

    public boolean isHasPillow() {
        return hasPillow;
    }

    public void setHasPillow(boolean hasPillow) {
        this.hasPillow = hasPillow;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNumberPillows() {
        return numberPillows;
    }

    public void setNumberPillows(int numberPillows) {
        this.numberPillows = numberPillows;
    }
    
    public void sitDownUpdate(int number) {
        this.timesSat -= number;
    }
        
    public void ripPillow() {
        this.numberPillows--;
        if (this.numberPillows == 0) {
            this.hasPillow = false;
        }
    }
    
}
