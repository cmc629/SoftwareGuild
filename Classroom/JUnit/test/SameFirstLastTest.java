/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Choi
 */
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
public class SameFirstLastTest {
    
    SameFirstLast SameFirstLast;
    
    public SameFirstLastTest() {
    }
    
    @Before
    public void setUp() {
        SameFirstLast = new SameFirstLast();
    }
    
    @After
    public void tearDown() {
    }
    
    //SameFirstLast({1, 2, 3}) -> false
    @Test
    public void SameFirstLast123() {
        
        int[] arr = {1,2,3};
        
        boolean result = SameFirstLast.SameFirstLast(arr);
        
        Assert.assertFalse(result);
    }

    //SameFirstLast({1, 2, 3, 1}) -> true
    @Test
    public void SameFirstLast1231() {
        
        int[] arr = {1,2,3,1};
        
        boolean result = SameFirstLast.SameFirstLast(arr);
        
        Assert.assertTrue(result);
    }

    //SameFirstLast({1, 2, 1}) -> true
    @Test
    public void SameFirstLast121() {
        
        int[] arr = {1,2,1};
        
        boolean result = SameFirstLast.SameFirstLast(arr);
        
        Assert.assertTrue(result);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}
