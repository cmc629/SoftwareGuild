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
public class Circle extends Shape {
    
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double area() {
        return Math.pow(this.radius, 2) * Math.PI;
    }
    
    public double perimeter() {
        return this.radius * 2 * Math.PI;
    }
    
}
