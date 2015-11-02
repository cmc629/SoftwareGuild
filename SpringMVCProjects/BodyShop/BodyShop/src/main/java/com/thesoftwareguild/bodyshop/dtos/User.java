/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Christian Choi
 */
public class User {
    
    private Integer userId;
    
    @NotEmpty
    @Size(min = 1, max = 45)
    private String firstName;
    
    @NotEmpty
    @Size(min = 1, max = 45)
    private String lastName;
    
    @Size(min = 0, max = 1)
    private String gender;
    
    @NotNull
    private Integer age;
    
    @NotEmpty
    @Size(min = 1, max = 45)
    private String email;
    
    @Size(min = 0, max = 12)
    private String phone;
    
    @NotNull
    private Integer streetNumber;
    
    @Size(min = 1, max = 45)
    private String streetName;
    
    @Size(min = 0, max = 45)
    private String city;
    
    @Size(min = 0, max = 45)
    private String state;
    
    @NotNull
    private Integer zip;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
    
    
    
}
