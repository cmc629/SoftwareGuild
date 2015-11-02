/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.daos;

import com.thesoftwareguild.mavenflooringmastery.dtos.Order;
import com.thesoftwareguild.mavenflooringmastery.dtos.Product;
import com.thesoftwareguild.mavenflooringmastery.dtos.State;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Christian Choi
 */
public class OrderDaoLambdaImpl implements OrderDao {
    private Map<Integer, Order> orders = new HashMap<>();
    private Integer lastId = 1;
    private boolean testMode = false;
    
    public OrderDaoLambdaImpl() {
    }
    
    //Getters and Setters
    @Override
    public Map<Integer, Order> getOrders() {
        return orders;
    }
    
    //Load and Save files
    @Override
    public void load() {
        
        String dirPath = System.getProperty("user.dir") + "/orders/";
        File dir = new File(dirPath);
        int highestNumber = 0;
        for (File file : dir.listFiles()) {
            try {
                String filePath = file.getAbsolutePath();
                String fileName = file.getName();
                String[] fileArray = file.getName().split("_");
                String dateString = fileArray[1].substring(0, 8);
                Date date = new SimpleDateFormat("MMddyyyy").parse(dateString);
                
                
                Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));
                sc.nextLine();
                
                while (sc.hasNext()) {
                    String[] properties;
                    properties = sc.nextLine().split("(?<!\\\\),");
                    Order order = new Order();
                    order.setOrderNumber(Integer.parseInt(properties[0]));
                    
                    String name = properties[1].substring(1, properties[1].length()-1); //remove quotes surrounding name
                    name = name.replace("\\,", ","); //replace escape character and comma
                    order.setCustomerName(name);
                    
                    order.setDate(date);
                    
                    State state = new State();
                    state.setStateName(properties[2]);
                    state.setTaxRate(Double.parseDouble(properties[3]));
                    order.setState(state);
                    
                    Product product = new Product();
                    product.setProductName(properties[4]);
                    product.setCostPer(Double.parseDouble(properties[6]));
                    product.setLaborCostPer(Double.parseDouble(properties[7]));
                    order.setProduct(product);
                    
                    order.setArea(Double.parseDouble(properties[5]));
                    
                    if (order.getOrderNumber() > highestNumber) {
                        highestNumber = order.getOrderNumber();
                    }
                    
                    orders.put(order.getOrderNumber(), order);
                    
                }
            } catch (FileNotFoundException | ParseException ex) {
                Logger.getLogger(OrderDaoLambdaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.lastId = highestNumber + 1; 
    }
    
    @Override
    public void save() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        try {
            List<Date> dateList = listDates();
            String ordersPath = String.format("%s/orders/", System.getProperty("user.dir"));
            File orderDir = new File(ordersPath);
            for(File file: orderDir.listFiles()) file.delete();
            for (Date date : dateList) {
                String dateText = sdf.format(date);
                String filePath = (String.format("%sOrders_%s.txt", ordersPath, dateText));
                
                List<Order> orderList = displayOrderByDate(date);
                PrintWriter out = new PrintWriter(new FileWriter(filePath));
                out.print("OrderNumber,CustomerName,State,TaxRate,ProductType,"
                    + "Area,CostPerSquareFoot,LaborCostPerSquareFoot,"
                    + "MaterialCost,LaborCost,Tax,Total\n");
                orderList.stream().forEach((order) -> {
                    String customerName = order.getCustomerName().replace(",", "\\,");
                    customerName = "\"" + customerName + "\"";
                    
                    out.printf("%d,%s,%s,%.2f,%s,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f\n",
                            order.getOrderNumber(), customerName,
                            order.getState().getStateName(), order.getState().getTaxRate(),
                            order.getProduct().getProductName(), order.getArea(),
                            order.getProduct().getCostPer(), order.getProduct().getLaborCostPer(),
                            order.getOrderMaterialCost(), order.getOrderLaborCost(),
                            order.getOrderTax(), order.getOrderTotal());
                });
                
                out.flush();
                out.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Order create(Order order) {
        order.setOrderNumber(lastId++);
        orders.put(order.getOrderNumber(), order);
        return order;
    }

    @Override
    public void update(Order order) {
        orders.replace(order.getOrderNumber(), order);
    }

    @Override
    public Order get(Integer orderNumber) {
        return orders.values().stream()
                .filter(o -> o.getOrderNumber().equals(orderNumber))
                .findFirst().orElse(null);
    }

    @Override
    public void delete(Integer orderNumber) {
        orders.entrySet()
                .removeIf(e -> e.getValue().getOrderNumber().equals(orderNumber));
    }

    @Override
    public List<Order> displayOrderByDate(Date date) {
        return orders.values().stream()
                .filter(o -> o.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Date> listDates() {
        List<Date> dateList = new ArrayList<>();
        orders.values().stream().filter(o -> !dateList.contains(o.getDate()))
                .forEach(o -> {
                    dateList.add(o.getDate());
                });
        return dateList;
    }

    @Override
    public boolean containsProduct(String productName) {
        return orders.values().stream().anyMatch(o -> o.getProduct().getProductName().equals(productName));
    }

    @Override
    public boolean containsState(String stateName) {
        return orders.values().stream().anyMatch(o -> o.getState().getStateName().equals(stateName));
    }

}
