/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.dtos;

/**
 *
 * @author Christian Choi
 */
public class Product {
    
    private String productName;
    private double costPer;
    private double laborCostPer;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCostPer() {
        return costPer;
    }

    public void setCostPer(double costPer) {
        this.costPer = costPer;
    }

    public double getLaborCostPer() {
        return laborCostPer;
    }

    public void setLaborCostPer(double laborCostPer) {
        this.laborCostPer = laborCostPer;
    }
    
    
    
}
