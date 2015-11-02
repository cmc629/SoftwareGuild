/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmvc.daos;

import com.thesoftwareguild.flooringmvc.models.Order;
import com.thesoftwareguild.flooringmvc.models.Product;
import com.thesoftwareguild.flooringmvc.models.State;
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

/**
 *
 * @author Christian Choi
 */
public class OrderDaoImpl implements OrderDao {

    private Map<Integer, Order> orders = new HashMap<>();
    private Integer lastId = 1;

    public OrderDaoImpl() {
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

                    String name = properties[1].substring(1, properties[1].length() - 1); //remove quotes surrounding name
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
                Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.lastId = highestNumber + 1;
    }

    @Override
    public void save() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        try {
            //Map<Date, List<Order>> mapDO = convertMap();
            List<Date> dateList = listDates();
            String ordersPath = String.format("%s/orders/", System.getProperty("user.dir"));
            File orderDir = new File(ordersPath);
            for (File file : orderDir.listFiles()) {
                file.delete();
            }
            for (Date date : dateList) {
                String dateText = sdf.format(date);
                String filePath = (String.format("%sOrders_%s.txt", ordersPath, dateText));

                List<Order> orderList = displayOrderByDate(date);
                PrintWriter out = new PrintWriter(new FileWriter(filePath));
                out.print("OrderNumber,CustomerName,State,TaxRate,ProductType,"
                        + "Area,CostPerSquareFoot,LaborCostPerSquareFoot,"
                        + "MaterialCost,LaborCost,Tax,Total\n");
                for (Order order : orderList) {

                    String customerName = order.getCustomerName().replace(",", "\\,");
                    customerName = "\"" + customerName + "\"";

                    out.printf("%d,%s,%s,%.2f,%s,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f\n",
                            order.getOrderNumber(), customerName,
                            order.getState().getStateName(), order.getState().getTaxRate(),
                            order.getProduct().getProductName(), order.getArea(),
                            order.getProduct().getCostPer(), order.getProduct().getLaborCostPer(),
                            order.getOrderMaterialCost(), order.getOrderLaborCost(),
                            order.getOrderTax(), order.getOrderTotal());

                }

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
        for (Order order : orders.values()) {
            if (order.getOrderNumber().equals(orderNumber)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer orderNumber) {
        Order orderToRemove = new Order();
        for (Order order : orders.values()) {
            if (order.getOrderNumber().equals(orderNumber)) {
                orderToRemove = order;
            }
        }
        if (orderToRemove.getOrderNumber() != null) {
            orders.remove(orderToRemove.getOrderNumber());
        }
    }

    @Override
    public List<Order> displayOrderByDate(Date date) {
        List<Order> orderList = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getDate().equals(date)) {
                orderList.add(order);
            }
        }
        return orderList;
    }

    @Override
    public List<Date> listDates() {
        List<Date> dateList = new ArrayList<>();
        for (Order order : orders.values()) {
            if (!dateList.contains(order.getDate())) {
                dateList.add(order.getDate());
            }
        }
        return dateList;
    }

    @Override
    public boolean containsProduct(String productName) {
        boolean doesContain = false;
        for (Order order : orders.values()) {
            if (order.getProduct().getProductName().equals(productName)) {
                doesContain = true;
            }
        }
        return doesContain;
    }

    @Override
    public boolean containsState(String stateName) {
        boolean doesContain = false;
        for (Order order : orders.values()) {
            if (order.getState().getStateName().equals(stateName)) {
                doesContain = true;
            }
        }
        return doesContain;
    }

    @Override
    public Map<Date, List<Order>> orderMapByDate() {
        Map<Date, List<Order>> orderMap = new HashMap<>();
        List<Date> dateList = this.listDates();
        for (Date date : dateList) {
            orderMap.put(date, this.displayOrderByDate(date));
        }

        return orderMap;
    }

}
