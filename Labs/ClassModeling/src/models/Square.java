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
public class Square {
    
    private int length;
    private String color;
    private String transparency;
    private int margins;
    private int border;

    public Square(int length, String color, String transparency, int margins, int border) {
        this.length = length;
        this.color = color;
        this.transparency = transparency;
        this.margins = margins;
        this.border = border;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public int getMargins() {
        return margins;
    }

    public void setMargins(int margins) {
        this.margins = margins;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }
    
    public int getArea() {
        int area = this.length * this.length;
        return area;
    }
    
    public int getPerimeter() {
        int perimeter = this.length * 4;
        return perimeter;
    }
    
}
