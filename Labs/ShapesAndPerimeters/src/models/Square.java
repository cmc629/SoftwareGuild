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
public class Square extends Shape {
    
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    public double area() {
        return this.length * this.length;
    }
    
    public double perimeter() {
        return this.length * 4;
    }
    
}
