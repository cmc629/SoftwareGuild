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
public class Triangle {
    
    private int height;
    private int baseLength;
    private int length2;
    private int length3;
    private String color;

    public Triangle(int height, int baseLength, int length2, int length3, String color) {
        this.height = height;
        this.baseLength = baseLength;
        this.length2 = length2;
        this.length3 = length3;
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBaseLength() {
        return baseLength;
    }

    public void setBaseLength(int baseLength) {
        this.baseLength = baseLength;
    }

    public int getLength2() {
        return length2;
    }

    public void setLength2(int length2) {
        this.length2 = length2;
    }

    public int getLength3() {
        return length3;
    }

    public void setLength3(int length3) {
        this.length3 = length3;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean checkIsosceles() {
        return (this.baseLength == length2 && length2 == length3);
    }
    
    public double getArea() {
        return (this.baseLength * this.height)/2;
    }
    
}
