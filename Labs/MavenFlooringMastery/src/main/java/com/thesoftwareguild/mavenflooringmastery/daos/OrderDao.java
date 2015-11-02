/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.daos;

import com.thesoftwareguild.mavenflooringmastery.dtos.Order;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Choi
 */
public interface OrderDao {

    public Order create(Order order);
    public void update(Order order);
    public Order get(Integer orderNumber);
    public void delete(Integer orderNumber);
    
    public List<Order> displayOrderByDate(Date date);
    public List<Date> listDates();
    public boolean containsProduct(String productName);
    public boolean containsState(String stateName);

    public Map<Integer, Order> getOrders();
    
    public void load();
    public void save();
    
}
