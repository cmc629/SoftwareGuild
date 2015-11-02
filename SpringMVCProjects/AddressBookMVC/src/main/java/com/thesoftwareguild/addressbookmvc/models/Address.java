package com.thesoftwareguild.addressbookmvc.models;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Address {

    private Integer id;

    @NotEmpty
    @Size(min = 1, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 1, max = 100)
    private String lastName;

    @NotEmpty
    @Size(min = 1, max = 10)
    private String streetNumber;
    
    @NotEmpty
    @Size(min = 1, max = 50)
    private String streetName;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String city;
    
    @NotEmpty
    @Size(min = 1, max = 20)
    private String state;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String zip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
