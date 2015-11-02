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
public class Make2Test {
    
    Make2 make2;
    
    public Make2Test() {
    }
    
    @Before
    public void setUp() {
        
        make2 = new Make2();
        
    }
    
    @After
    public void tearDown() {
    }

    //Make2({4, 5}, {1, 2, 3}) -> {4, 5}
    @Test
    public void Make2Test1() {
        
        int[] a = {4,5};
        int[] b = {1,2,3};
        int[] actual = make2.Make2(a, b);
        
        int[] expected = {4,5};
        
        Assert.assertArrayEquals(expected, actual);
        
    }

    //Make2({4}, {1, 2, 3}) -> {4, 1}
    @Test
    public void Make2Test2() {
        
        int[] a = {4};
        int[] b = {1,2,3};
        int[] actual = make2.Make2(a, b);
        
        int[] expected = {4,1};
        
        Assert.assertArrayEquals(expected, actual);
        
    }

    //Make2({}, {1, 2}) -> {1, 2}
    @Test
    public void Make2Test3() {
        
        int[] a = {};
        int[] b = {1,2};
        int[] actual = make2.Make2(a, b);
        
        int[] expected = {1,2};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
