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
public class KeepLastTest {
    
    KeepLast keepLast;
    
    public KeepLastTest() {
    }
    
    @Before
    public void setUp() {
        
        keepLast = new KeepLast();
        
    }
    
    @After
    public void tearDown() {
    }
    
    //KeepLast({4, 5, 6}) -> {0, 0, 0, 0, 0, 6}
    @Test
    public void KeepLast456() {
        
        int[] arr = {4,5,6};
        int[] actual = keepLast.KeepLast(arr);
        int[] expected = {0,0,0,0,0,6};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    //KeepLast({1, 2}) -> {0, 0, 0, 2}
    @Test
    public void KeepLast12() {
        
        int[] arr = {1,2};
        int[] actual = keepLast.KeepLast(arr);
        int[] expected = {0,0,0,2};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    
    //KeepLast({3}) -> {0, 3}
    @Test
    public void KeepLast3() {
        
        int[] arr = {3};
        int[] actual = keepLast.KeepLast(arr);
        int[] expected = {0,3};
        
        Assert.assertArrayEquals(expected, actual);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
