/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Choi
 */
public class Unlucky1Test {
    
    Unlucky1 unlucky1;
    
    public Unlucky1Test() {
    }
    
    @Before
    public void setUp() {
        
        unlucky1 = new Unlucky1();
        
    }
    
    @After
    public void tearDown() {
    }
    
    //Unlucky1({1, 3, 4, 5}) -> true
    @Test
    public void Unlucky1Test1() {
        
        int[] arr = {1,3,4,5};
        boolean result = unlucky1.Unlucky1(arr);
        
        Assert.assertTrue(result);
        
    }
    //Unlucky1({2, 1, 3, 4, 5}) -> true
    @Test
    public void Unlucky1Test2() {
        
        int[] arr = {2,1,3,4,5};
        boolean result = unlucky1.Unlucky1(arr);
        
        Assert.assertTrue(result);
        
    }
    
    //Unlucky1({1, 1, 1}) -> false
    @Test
    public void Unlucky1Test3() {
        
        int[] arr = {1,1,1};
        boolean result = unlucky1.Unlucky1(arr);
        
        Assert.assertFalse(result);
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
