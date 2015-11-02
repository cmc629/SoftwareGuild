/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Choi
 */
public class HasEvenTest {
    
    HasEven hasEven;
    
    public HasEvenTest() {
    }
    
    @Before
    public void setUp() {
        
        hasEven = new HasEven();
        
    }
    
    @After
    public void tearDown() {
    }

    
    //HasEven({2, 5}) -> true
    @Test
    public void HasEven25() {
        
        int[] arr = {2,5};
        boolean result = hasEven.HasEven(arr);
        
        Assert.assertTrue(result);
        
    }
    
//HasEven({4, 3}) -> true
    @Test
    public void HasEven43() {
        
        int[] arr = {2,5};
        boolean result = hasEven.HasEven(arr);
        
        Assert.assertTrue(result);
        
    }
    
//HasEven({7, 5}) -> false
    @Test
    public void HasEven75() {
        
        int[] arr = {7,5};
        boolean result = hasEven.HasEven(arr);
        
        Assert.assertFalse(result);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
