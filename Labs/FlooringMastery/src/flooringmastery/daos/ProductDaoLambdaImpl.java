/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.daos;

import flooringmastery.dtos.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class ProductDaoLambdaImpl implements ProductDao {
    private Map<String, Product> products = new HashMap<>();
    private final String fileName = "DataProducts.txt";

    @Override
    public Map<String, Product> getProducts() {
        return products;
    }
    
    public void load() {
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
            sc.nextLine();
            while (sc.hasNext()) {
                
                String[] properties = sc.nextLine().split(",");
                Product product = new Product();
                product.setProductName(properties[0]);
                product.setCostPer(Double.parseDouble(properties[1]));
                product.setLaborCostPer(Double.parseDouble(properties[2]));

                products.put(product.getProductName(), product);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductDaoLambdaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void write() {
        
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            out.print("ProductType,CostPerSquareFoot,LaborCostPerSquareFoot\n");
            for (Product product : products.values()) {
                out.printf(String.format("%s,%.2f,%.2f\n",
                        product.getProductName(),
                        product.getCostPer(),
                        product.getLaborCostPer()));
            }
            out.flush();
            out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ProductDaoLambdaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public List<String> listAllProducts() {
        return products.keySet().stream().collect(Collectors.toList());
    }
    
    
    @Override
    public boolean isValidProduct(String productName) {
        return products.keySet().stream().anyMatch(p -> p.equals(productName));
    }
    
    @Override
    public void create(Product product) {
        products.put(product.getProductName(), product);
    }
    
    @Override
    public Product delete(Product product) {
        return products.remove(product.getProductName());
    }
    
    
}
