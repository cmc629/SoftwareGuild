/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.daos;

import flooringmastery.dtos.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Choi
 */
public interface ProductDao {

    public void create(Product product);

    public Map<String, Product> getProducts();

    public boolean isValidProduct(String productName);

    public List<String> listAllProducts();

    public Product delete(Product product);
    
}
