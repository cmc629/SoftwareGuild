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
public class Table {
    
    private int length;
    private int width;
    private int thickness;
    private String color;
    private int heightOfTable;

    public Table(int length, int width, int thickness, String color, int heightOfTable) {
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.color = color;
        this.heightOfTable = heightOfTable;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeightOfTable() {
        return heightOfTable;
    }

    public void setHeightOfTable(int heightOfTable) {
        this.heightOfTable = heightOfTable;
    }
    
    public int getTableTopVolume() {
        int volume = this.thickness * this.length * this.width;
        return volume;
    }
    
    public int getWorkingSurfaceArea() {
        return this.length * this.width;
    }
    
}
