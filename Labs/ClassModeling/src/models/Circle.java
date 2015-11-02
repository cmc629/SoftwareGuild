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
public class Circle {
    
    private int radius;
    private String color;
    private String transparency;
    private String border;
    private int margins;

    public Circle(int radius, String color, String transparency, String border, int margins) {
        this.radius = radius;
        this.color = color;
        this.transparency = transparency;
        this.border = border;
        this.margins = margins;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public int getMargins() {
        return margins;
    }

    public void setMargins(int margins) {
        this.margins = margins;
    }
    
    public double getArea() {
        double area = Math.PI * this.radius * this.radius;
        return area;
    }
    
    public double getCircumference() {
        double circumference = Math.PI * this.radius * 2;
        return circumference;
    }
    
    
    
}
