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
public class GetMiddleTest {
    
    GetMiddle getMiddle;
    
    public GetMiddleTest() {
    }
    
    @Before
    public void setUp() {
        
        getMiddle = new GetMiddle();
        
    }
    
    @After
    public void tearDown() {
    }

    
    //GetMiddle({1, 2, 3}, {4, 5, 6}) -> {2, 5}
    @Test
    public void GetMiddle123456() {
        
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        int[] actual = getMiddle.GetMiddle(a,b);
        int[] expected = {2,5};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    //GetMiddle({7, 7, 7}, {3, 8, 0}) -> {7, 8}
    @Test
    public void GetMiddle777380() {
        
        int[] a = {7,7,7};
        int[] b = {3,8,0};
        int[] actual = getMiddle.GetMiddle(a,b);
        int[] expected = {7,8};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    //GetMiddle({5, 2, 9}, {1, 4, 5}) -> {2, 4}
    @Test
    public void GetMiddle529145() {
        
        int[] a = {5,2,9};
        int[] b = {1,4,5};
        int[] actual = getMiddle.GetMiddle(a,b);
        int[] expected = {2,4};
        
        Assert.assertArrayEquals(expected, actual);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
