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
public class Shirt extends Product {
    
    private String fit; //custom, slim, classic?
    private String size; //XS, S, M, L, XL?

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
}
