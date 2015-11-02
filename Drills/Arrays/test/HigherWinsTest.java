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
public class HigherWinsTest {
    
    HigherWins higherWins;
    
    public HigherWinsTest() {
    }
    
    @Before
    public void setUp() {
        
        higherWins = new HigherWins();
        
    }
    
    @After
    public void tearDown() {
    }

    //HigherWins({1, 2, 3}) -> {3, 3, 3}
    @Test
    public void HigherWins123() {
        
        int[] arr = {1,2,3};
        int[] actual = higherWins.HigherWins(arr);
        int[] expected = {3,3,3};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    //HigherWins({11, 5, 9}) -> {11, 11, 11}
    @Test
    public void HigherWins1159() {
        
        int[] arr = {11,5,9};
        int[] actual = higherWins.HigherWins(arr);
        int[] expected = {11,11,11};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    //HigherWins({2, 11, 3}) -> {3, 3, 3}
    @Test
    public void HigherWins2113() {
        
        int[] arr = {2,11,3};
        int[] actual = higherWins.HigherWins(arr);
        int[] expected = {3,3,3};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
