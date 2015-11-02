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
public class City {
    
    private int population;
    private String state;
    private String zipcode;
    private String name;
    private double taxRevenue;

    public City(int population, String state, String zipcode, String name, double taxRevenue) {
        this.population = population;
        this.state = state;
        this.zipcode = zipcode;
        this.name = name;
        this.taxRevenue = taxRevenue;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTaxRevenue() {
        return taxRevenue;
    }

    public void setTaxRevenue(double taxRevenue) {
        this.taxRevenue = taxRevenue;
    }
    
    public void setEpidemic(int factor) {
        this.population = this.population/factor;
    }
    
    public void printAddress() {
        System.out.println(this.name + ", " + this.state + " " + this.zipcode);
    }
    
}
