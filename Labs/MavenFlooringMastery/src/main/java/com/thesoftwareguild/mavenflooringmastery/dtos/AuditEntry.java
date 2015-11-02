/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.dtos;

import java.util.Date;

/**
 *
 * @author Christian Choi
 */
public class AuditEntry {
    
    private Date date;
    private Order order;
    private String status; //created, updated, or deleted?
    
    public AuditEntry(Date date, Order order, String status) {
        this.date = date;
        this.order = order;
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
