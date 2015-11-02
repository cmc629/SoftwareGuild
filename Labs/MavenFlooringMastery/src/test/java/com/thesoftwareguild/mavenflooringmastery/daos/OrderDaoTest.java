/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.daos;

import com.thesoftwareguild.mavenflooringmastery.dtos.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Christian Choi
 */
public class OrderDaoTest {
    
    OrderDao dao;
    Order order1, order2, order3;
    SimpleDateFormat sdf;
    
    public OrderDaoTest() {
    }
    
    @Before
    public void setUp() throws ParseException {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("orderDao", OrderDaoLambdaImpl.class);
        
        sdf = new SimpleDateFormat("MMddyyyy");
        
        //Instantiate order objects. No need to set product and state values
        //since the tests don't require/alter those fields
        order1 = new Order();
        order1.setCustomerName("Mary Swanson");
        order1.setDate(sdf.parse("09162015"));
        order1.setArea(100);
        
        order2 = new Order();
        order2.setCustomerName("Jill Jackson");
        order2.setDate(sdf.parse("10012015"));
        order2.setArea(20);
        
        order3 = new Order();
        order3.setCustomerName("Paul Franklin");
        order3.setDate(sdf.parse("09162015"));
        order3.setArea(10.5);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addOrderTest() {
        
        dao.create(order1);
        Integer expected = 1;
        
        Assert.assertEquals(expected, order1.getOrderNumber());
        Assert.assertTrue(dao.getOrders().containsValue(order1));
        
        dao.create(order2);
        Integer expected2 = 2;
        
        Assert.assertEquals(expected2, order2.getOrderNumber());
        Assert.assertTrue(dao.getOrders().containsValue(order2));
    }
    
    @Test
    public void displayOrderTest() throws ParseException {
        
        dao.create(order1);
        dao.create(order3);
        
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order3);
        
        Assert.assertEquals(orderList, dao.displayOrderByDate(sdf.parse("09162015")));
        
        dao.create(order2);
        
        List<Order> orderList2 = new ArrayList<>();
        orderList2.add(order2);
        
        Assert.assertEquals(orderList2, dao.displayOrderByDate(sdf.parse("10012015")));
        
    }
    
    @Test
    public void getOrderFromNumberTest() {
        
        dao.create(order1);
        dao.create(order2);
        dao.create(order3);
        
        Assert.assertEquals(order1, dao.get(1));
        Assert.assertEquals(order2, dao.get(2));
        Assert.assertEquals(order3, dao.get(3));
        
    }
    
    @Test
    public void removeOrderTest() {
        
        dao.create(order1);
        dao.create(order2);
        dao.create(order3);
        
        dao.delete(order2.getOrderNumber());
        
        Assert.assertTrue(dao.getOrders().containsValue(order1));
        Assert.assertFalse(dao.getOrders().containsValue(order2));
        Assert.assertTrue(dao.getOrders().containsValue(order3));
        
        dao.delete(order1.getOrderNumber());
        
        Assert.assertFalse(dao.getOrders().containsValue(order1));
        Assert.assertFalse(dao.getOrders().containsValue(order2));
        Assert.assertTrue(dao.getOrders().containsValue(order3));
        
        dao.delete(order3.getOrderNumber());
        
        Assert.assertFalse(dao.getOrders().containsValue(order1));
        Assert.assertFalse(dao.getOrders().containsValue(order2));
        Assert.assertFalse(dao.getOrders().containsValue(order3));
        
        
    }
}
