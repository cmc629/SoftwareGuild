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
public class SumTest {
    
    Sum sum;
    
    public SumTest() {
    }
    
    @Before
    public void setUp() {
        
        sum = new Sum();
        
    }
    
    @After
    public void tearDown() {
    }
    
    //Sum({1, 2, 3}) -> 6
    @Test
    public void Sum123() {
        
        int[] arr = {1,2,3};
        int total = sum.Sum(arr);
        
        Assert.assertEquals(6, total);
        
    }
    
    //Sum({5, 11, 2}) -> 18
    @Test
    public void Sum5112() {
        int[] arr = {5,11,2};
        int total = sum.Sum(arr);
        
        Assert.assertEquals(18, total);
    }
    
    //Sum({7, 0, 0}) -> 7
    @Test
    public void Sum700() {
        int[] arr = {7,0,0};
        int total = sum.Sum(arr);
        
        Assert.assertEquals(7, total);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
