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
public class Double23Test {
    
    Double23 double23;
    
    public Double23Test() {
    }
    
    @Before
    public void setUp() {
        
        double23 = new Double23();
        
    }
    
    @After
    public void tearDown() {
    }

    //Double23({2, 2, 3}) -> true
    @Test
    public void Double23Test1() {
        
        int[] arr = {2,2,3};
        boolean result = double23.Double23(arr);
        
        Assert.assertTrue(result);
        
    }
    //Double23({3, 4, 5, 3}) -> true
    @Test
    public void Double23Test2() {
        
        int[] arr = {2,2,3};
        boolean result = double23.Double23(arr);
        
        Assert.assertTrue(result);
        
    }    
    //Double23({2, 3, 2, 2}) -> false
    @Test
    public void Double23Test3() {
        
        int[] arr = {2,2,3};
        boolean result = double23.Double23(arr);
        
        Assert.assertTrue(result);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
