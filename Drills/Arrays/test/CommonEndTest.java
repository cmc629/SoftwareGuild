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
public class CommonEndTest {
    
    CommonEnd commonEnd;
    
    public CommonEndTest() {
    }
    
    @Before
    public void setUp() {
        
        commonEnd = new CommonEnd();
        
    }
    
    @After
    public void tearDown() {
    }

    //CommonEnd({1, 2, 3}, {7, 3}) -> true
    @Test
    public void CommonEndTest1() {
        
        int[] arr1 = {1,2,3};
        int[] arr2 = {7,3};
        
        boolean result = commonEnd.commonEnd(arr1, arr2);
        
        Assert.assertTrue(result);
        
    }
    
    //CommonEnd({1, 2, 3}, {7, 3, 2}) -> false
    @Test
    public void CommonEndTest2() {
        
        int[] arr1 = {1,2,3};
        int[] arr2 = {7,3,2};
        
        boolean result = commonEnd.commonEnd(arr1, arr2);
        
        Assert.assertFalse(result);
        
    }
    
    //CommonEnd({1, 2, 3}, {1, 3}) -> true
    @Test
    public void CommonEndTest3() {
        
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,3};
        
        boolean result = commonEnd.commonEnd(arr1, arr2);
        
        Assert.assertTrue(result);  
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
