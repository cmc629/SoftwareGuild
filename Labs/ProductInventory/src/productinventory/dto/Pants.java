/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productinventory.dto;

/**
 *
 * @author Christian Choi
 */
public class Pants extends Product {
    
    private int waistsize;
    private int lengthsize;
    private String fit; //slim, straight, etc

    public int getWaistsize() {
        return waistsize;
    }

    public void setWaistsize(int waistsize) {
        this.waistsize = waistsize;
    }

    public int getLengthsize() {
        return lengthsize;
    }

    public void setLengthsize(int lengthsize) {
        this.lengthsize = lengthsize;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }
    
}
