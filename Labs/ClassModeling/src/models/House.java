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
public class House {
    
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private int length;
    private int width;

    public House(String address, String city, String state, String zipcode, int length, int width) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.length = length;
        this.width = width;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    
    public int getArea() {
        return this.length * this.width;
    }
    
    public void printAddress() {
        System.out.println(this.address + "\n" + this.city + ", " + this.state 
                + " " + this.zipcode);
    }
    
}
