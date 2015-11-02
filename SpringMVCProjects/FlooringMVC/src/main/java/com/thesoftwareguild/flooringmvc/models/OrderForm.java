/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmvc.models;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Christian Choi
 */
public class OrderForm {
    
    @NotEmpty
    private String customerName;
    
    @NotNull
    @DateTimeFormat (pattern = "MM-dd-yyyy")
    @Past
    private Date date;
    private String productName;
    private String stateName;
    @NotNull
    private double area;
    private Integer orderNumber;
    
    public OrderForm() {
        
    }
    
    public OrderForm(String customerName, Date date, String productName, String stateName, double area, Integer orderNumber) {
        this.customerName = customerName;
        this.date = date;
        this.productName = productName;
        this.stateName = stateName;
        this.area = area;
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    
}
