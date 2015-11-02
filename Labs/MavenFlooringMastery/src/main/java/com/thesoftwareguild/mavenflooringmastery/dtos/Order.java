/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Christian Choi
 */
public class Order {
    
    private Date date;
    private Integer orderNumber;
    private String customerName;
    private State state;
    private Product product;
    private double area;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getOrderMaterialCost() {
        return this.getArea() * this.getProduct().getCostPer();
    }
    
    public double getOrderLaborCost() {
        return this.getArea() * this.getProduct().getLaborCostPer();
    }
    
    public double getOrderTax() {
        double subtotal = this.getOrderLaborCost() + this.getOrderMaterialCost();
        double tax = subtotal * this.getState().getTaxRate()/100;
        return tax;
    }   
    
    public double getOrderTotal() {
        double subtotal = this.getOrderLaborCost() + this.getOrderMaterialCost();
        double total = subtotal + this.getOrderTax();
        return total;
    }
    
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        return sdf.format(this.date);
    }
    
    
}
