/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.contactlistmvc.models;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Christian Choi
 */
public class Contact {
    
    private Integer id;
    
    @NotEmpty
    @Size(min = 1, max = 100)
    private String firstName;
    
    @NotEmpty
    @Size(min = 1, max = 100)
    private String lastName;
    
    @Size(min = 0, max = 100)
    private String company;
    
    @Size(min = 0, max = 50)
    private String email;
    
    @Size(min = 0, max = 15)
    private String phone;

    
    //private Integer level;
    
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    
    
}
