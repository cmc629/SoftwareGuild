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
public class RotateLeftTest {
    
    RotateLeft rotateLeft;
    
    public RotateLeftTest() {
    }
    
    @Before
    public void setUp() {
        
        rotateLeft = new RotateLeft();
        
    }
    
    @After
    public void tearDown() {
    }

    //RotateLeft({1, 2, 3}) -> {2, 3, 1}
    @Test
    public void rotateLeft123() {
        
        int[] arr = {1,2,3};
        int[] actual = rotateLeft.RotateLeft(arr);
        int[] expected = {2,3,1};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    //RotateLeft({5, 11, 9}) -> {11, 9, 5}
    @Test
    public void rotateLeft5119() {
        
        int[] arr = {5,11,9};
        int[] actual = rotateLeft.RotateLeft(arr);
        int[] expected = {11,9,5};
        
        Assert.assertArrayEquals(expected, actual);
                
    }
    //RotateLeft({7, 0, 0}) -> {0, 0, 7}
    @Test
    public void rotateLeft700() {
        
        int[] arr = {7,0,0};
        int[] actual = rotateLeft.RotateLeft(arr);
        int[] expected = {0,0,7};
        
        Assert.assertArrayEquals(expected, actual);
                
    }
    
    @Test
    public void rotateLeft79() {
        
        int[] arr = {7,9};
        int[] actual = rotateLeft.RotateLeft(arr);
        int[] expected = {9,7};
        
        Assert.assertArrayEquals(expected, actual);
    }
    
    @Test
    public void rotateLeft8() {
        
        int[] arr = {8};
        int[] actual = rotateLeft.RotateLeft(arr);
        int[] expected = {8};
        
        Assert.assertArrayEquals(expected, actual);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
