/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productinventory.controllers;

import productinventory.dao.ProductInventoryDao;
import productinventory.dto.Pants;
import productinventory.dto.Product;
import productinventory.dto.Shirt;
import productinventory.dto.Shoes;
import productinventory.ui.ConsoleIO;

/**
 *
 * @author Christian Choi
 */
public class ProductInventoryController {
    
    ProductInventoryDao dao = new ProductInventoryDao();
    ConsoleIO io = new ConsoleIO();

    public void run() {
        
        dao.loadInventory();
        dao.setLastId(dao.getInventory().size());
        
        boolean isRunning = true;
        while (isRunning) {
            listItems();
            printMenu();
            int menuSelection = io.promptInt("\nPlease choose from the choices above: ", 1, 6);
            
            switch (menuSelection) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    addStock();
                    break;
                case 3:
                    removeStock();
                    break;
                case 4:
                    calculateValue();
                    break;
                case 5:
                    calculateInventoryValue();
                    break;
                case 6:
                    io.println("\nThank you. Goodbye!");
                    isRunning = false;
                    break;
            }
        }
        
        dao.writeInventory();
        
    }
    
    public void printMenu() {
        io.println("\nPlease choose an option:\n1) Add new product" +
                "\n2) Add stock to product\n3) Remove stock from product" +
                "\n4) Calculate total value of product" +
                "\n5) Calculate total value of inventory\n6) Exit");
    }
    
    public void addProduct() {
        io.println("\nHere is a list of items you can add:\n1) Shirt\n2) Pants\n3) Shoes");
        int selection = io.promptInt("\nPlease choose from the choices above. Hit '0' to exit: ", 0, 3);
        if (selection == 1) {
            Product shirt = new Shirt();
            shirt.setStock(io.promptInt("\nPlease enter how many stocks: "));
            shirt.setCost(io.promptDouble("Please enter the cost of this product: "));
            shirt.setColor(io.promptString("Please enter the color (Blue, Yellow, White, Black, etc): "));
            ((Shirt) shirt).setFit(io.promptString("Please enter the fit (Slim, Custom, Classic, etc): "));
            ((Shirt) shirt).setSize(io.promptString("Please enter the size (S, M, L, etc): "));
            dao.addProduct(shirt);
        }
        if (selection == 2) {
            Product pants = new Pants();
            pants.setStock(io.promptInt("\nPlease enter how many stocks: "));
            pants.setCost(io.promptDouble("Please enter the cost of this product: "));
            pants.setColor(io.promptString("Please enter the color: "));
            ((Pants) pants).setWaistsize(io.promptInt("Please enter the waist size: "));
            ((Pants) pants).setLengthsize(io.promptInt("Please enter the length size: "));
            ((Pants) pants).setFit(io.promptString("Please enter the fit (Slim, Regular, etc): "));
            dao.addProduct(pants);
        }
        if (selection == 3) {
            Product shoes = new Shoes();
            shoes.setStock(io.promptInt("\nPlease enter how many stocks: "));
            shoes.setCost(io.promptDouble("Please enter the cost of this product: "));
            shoes.setColor(io.promptString("Please enter the color: "));
            ((Shoes) shoes).setSize(io.promptDouble("Please enter the shoe size: "));
            dao.addProduct(shoes);
        }
    }
    
    public void listItems() {
        io.println("\nHere is a list of the current products in the inventory: ");
        for (Integer id : dao.getInventory().keySet()) {
            Product item = dao.getInventory().get(id);
            if (item instanceof Shirt) {
                io.println(String.format("Product ID: %d | %s, %s-fit Shirt | Size %s | Cost: %.02f | Quantity: %d",
                        item.getId(), item.getColor(), ((Shirt) item).getFit(), 
                        ((Shirt) item).getSize(), item.getCost(), item.getStock()));
            }
            if (item instanceof Pants) {
                io.println(String.format("Product ID: %d | %s, %s-fit Pants | Waist Size: %d, Length Size: %d | Cost: %.02f | Quantity: %d",
                        item.getId(), item.getColor(), ((Pants) item).getFit(), 
                        ((Pants) item).getWaistsize(), ((Pants) item).getLengthsize(),
                        item.getCost(), item.getStock()));
            }
            if (item instanceof Shoes) {
                io.println(String.format("Product ID: %d | %s Shoes | Size: %.01f | Cost: %.02f | Quantity: %d",
                        item.getId(), item.getColor(), ((Shoes) item).getSize(),
                        item.getCost(), item.getStock()));
            }
        }
    }
    
    public void addStock() {
        listItems();
        int productID = io.promptInt("\nPlease choose a product ID: ", 0, dao.getInventory().size()-1);
        int quantity = io.promptInt("\nPlease enter how much to add onto the stock: ");
        dao.addStock(quantity, productID);
        io.println(String.format("The product's stock is now %d", dao.getInventory().get(productID).getStock()));
    }
    
    public void removeStock() {
        listItems();
        int productID = io.promptInt("\nPlease choose a product ID: ", 0, dao.getInventory().size()-1);
        int quantity = io.promptInt("\nPlease enter how much to remove from the stock: ");
        dao.removeStock(quantity, productID);
        checkStock(productID);
        io.println(String.format("The product's stock is now %d", dao.getInventory().get(productID).getStock()));
    }
    
    public void checkStock(Integer id) {
        if (dao.getInventory().get(id).getStock() < Product.stockWarning) {
            System.out.println("Stock running low! Please add more!");
        }
    }
    
    public void calculateValue() {
        listItems();
        int productID = io.promptInt("\nPlease choose a product ID to calculate total value: ", 0, dao.getInventory().size()-1);
        io.println(String.format("The total value of this product is $%.02f", dao.calculateValue(productID)));
    }
    
    public void calculateInventoryValue() {
        io.println(String.format("The total value of the inventory is $%.02f", dao.calculateInventoryValue()));
    }
}
