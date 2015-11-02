/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.daos;

import flooringmastery.dtos.Product;
import java.util.Map;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Christian Choi
 */
public class ProductDaoTest {
    
    ProductDaoLambdaImpl dao = new ProductDaoLambdaImpl();
    //ProductDaoImpl dao = new ProductDaoImpl();
    
    public ProductDaoTest() {
    }
    
    @Before
    public void setUp() {
        
        dao.load();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void listProductsTest() {
        
        Assert.assertTrue(dao.listAllProducts().contains("Wood"));
        Assert.assertTrue(dao.listAllProducts().contains("Laminate"));
        Assert.assertTrue(dao.listAllProducts().contains("Tile"));
        Assert.assertTrue(dao.listAllProducts().contains("Carpet"));
        
    }
    
    @Test
    public void productCostPerTest() {
        
        Map<String, Product> productMap = dao.getProducts();
        
        Product wood = productMap.get("Wood");
        double woodCostPer = wood.getCostPer();
        Assert.assertEquals(5.15, woodCostPer);
        
        Product laminate = productMap.get("Laminate");
        double laminateCostPer = laminate.getCostPer();
        Assert.assertEquals(1.75, laminateCostPer);
        
        Product carpet = productMap.get("Carpet");
        double carpetCostPer = carpet.getCostPer();
        Assert.assertEquals(2.25, carpetCostPer);
        
        Product tile = productMap.get("Tile");
        double tileCostPer = tile.getCostPer();
        Assert.assertEquals(3.50, tileCostPer);
        
    }
    
    @Test
    public void productLaborCostPerTest() {
        
        Map<String, Product> productMap = dao.getProducts();
        
        Product wood = productMap.get("Wood");
        double woodLCP = wood.getLaborCostPer();
        Assert.assertEquals(4.75, woodLCP);
        
        Product laminate = productMap.get("Laminate");
        double laminateLCP = laminate.getLaborCostPer();
        Assert.assertEquals(2.10, laminateLCP);
        
        Product carpet = productMap.get("Carpet");
        double carpetLCP = carpet.getLaborCostPer();
        Assert.assertEquals(2.10, carpetLCP);
        
        Product tile = productMap.get("Tile");
        double tileLCP = tile.getLaborCostPer();
        Assert.assertEquals(4.15, tileLCP);
        
    }
    
    @Test
    public void isValidProductTest() {
        
        boolean containsWood = dao.isValidProduct("Wood");
        boolean containsLaminate = dao.isValidProduct("Laminate");
        boolean containsTile = dao.isValidProduct("Tile");
        boolean containsCarpet = dao.isValidProduct("Carpet");
        
        Assert.assertTrue(containsWood);
        Assert.assertTrue(containsLaminate);
        Assert.assertTrue(containsTile);
        Assert.assertTrue(containsCarpet);
        
        
    }
}
