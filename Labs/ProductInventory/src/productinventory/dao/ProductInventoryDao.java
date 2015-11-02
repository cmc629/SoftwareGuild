/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productinventory.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import productinventory.dto.Pants;
import productinventory.dto.Product;
import productinventory.dto.Shirt;
import productinventory.dto.Shoes;

/**
 *
 * @author Christian Choi
 */
public class ProductInventoryDao {
    
    private Map<Integer, Product> inventory = new HashMap<>();
    private Integer lastId = 0;
    private final String fileName = "inventory.txt";


    public Map<Integer, Product> getInventory() {
        return inventory;
    }

    public Integer getLastId() {
        return lastId;
    }

    public void setLastId(Integer lastId) {
        this.lastId = lastId;
    }
    
    public void loadInventory() {
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
            
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] properties = line.split(",");
                if (properties[0].equals("shirt")) {
                    Product shirt = new Shirt();
                    shirt.setId(Integer.parseInt(properties[1]));
                    shirt.setStock(Integer.parseInt(properties[2]));
                    shirt.setCost(Double.parseDouble(properties[3]));
                    shirt.setColor(properties[4]);
                    ((Shirt) shirt).setFit(properties[5]);
                    ((Shirt) shirt).setSize(properties[6]);
                    
                    inventory.put(shirt.getId(), shirt);
                }
                if (properties[0].equals("pants")) {
                    Product pants = new Pants();
                    pants.setId(Integer.parseInt(properties[1]));
                    pants.setStock(Integer.parseInt(properties[2]));
                    pants.setCost(Double.parseDouble(properties[3]));
                    pants.setColor(properties[4]);
                    ((Pants) pants).setWaistsize(Integer.parseInt(properties[5]));
                    ((Pants) pants).setLengthsize(Integer.parseInt(properties[6]));
                    ((Pants) pants).setFit(properties[7]);
                    
                    inventory.put(pants.getId(), pants);
                }
                if (properties[0].equals("shoes")){
                    Product shoes = new Shoes();
                    shoes.setId(Integer.parseInt(properties[1]));
                    shoes.setStock(Integer.parseInt(properties[2]));
                    shoes.setCost(Double.parseDouble(properties[3]));
                    shoes.setColor(properties[4]);
                    ((Shoes) shoes).setSize(Double.parseDouble(properties[5]));
                    
                    inventory.put(shoes.getId(), shoes);
                }
            }
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductInventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeInventory() {
        
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            
            for (Integer id : inventory.keySet()) {
                Product item = inventory.get(id);
                
                if (item instanceof Shirt) {
                    out.printf("%s,%d,%d,%f,%s,%s,%s\n", "shirt", item.getId(), 
                            item.getStock(), item.getCost(), item.getColor(), 
                            ((Shirt) item).getFit(), ((Shirt) item).getSize());
                }
                if (item instanceof Pants) {
                    out.printf("%s,%d,%d,%f,%s,%d,%d,%s\n", "pants", item.getId(),
                            item.getStock(), item.getCost(), item.getColor(),
                            ((Pants) item).getWaistsize(), ((Pants) item).getLengthsize(),
                            ((Pants) item).getFit());
                }
                if (item instanceof Shoes) {
                    out.printf("%s,%d,%d,%f,%s,%f\n", "shoes", item.getId(), 
                            item.getStock(), item.getCost(), item.getColor(),
                            ((Shoes) item).getSize());
                }
            
                
            }
            
            out.flush();
            out.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(ProductInventoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
    public void addProduct(Product product) {
        product.setId(lastId++);
        inventory.put(product.getId(), product);
    }
    
    public void addStock(int quantity, Integer id) {
        int currentStock = inventory.get(id).getStock();
        currentStock += quantity;
        inventory.get(id).setStock(currentStock);
    }
    
    public void removeStock(int quantity, Integer id) {
        int currentStock = inventory.get(id).getStock();
        currentStock -= quantity;
        inventory.get(id).setStock(currentStock);
    }
    
    public double calculateValue(Integer id) {
        return inventory.get(id).getCost() * inventory.get(id).getStock();
    }
    
    public double calculateInventoryValue() {
        double total = 0;
        for (Integer id : inventory.keySet()) {
            total += calculateValue(id);
        }
        return total;
    }
    
}
