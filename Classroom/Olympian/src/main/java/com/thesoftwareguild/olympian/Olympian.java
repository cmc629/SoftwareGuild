/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.olympian;

/**
 *
 * @author Christian Choi
 */
public class Olympian {

    private Event event;
    private String country = "USA";
    
    public Olympian(Event event) {
        this.event = event;
    }
    
    public String competeInEvent() {
        System.out.println("Now competing for " + country + ":");
        return event.compete();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
    
}
