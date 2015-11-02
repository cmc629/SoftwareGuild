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
public class Chair {
    
    private String type; //rocking? rolling?
    private String material; //metal? plastic?
    private int timesSat = 0;
    private int numLegs;
    private String color;

    public Chair(String type, String material, int numLegs, String color) {
        this.type = type;
        this.material = material;
        this.numLegs = numLegs;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getTimesSat() {
        return timesSat;
    }

    public void setTimesSat(int timesSat) {
        this.timesSat = timesSat;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void sitDownUpdate(int number) {
        this.timesSat += number;
    }
    
    public void smashChair() {
        this.numLegs--;
    }
    
    
}
