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
public class ReverseTest {
    
    Reverse reverse;
    
    public ReverseTest() {
    }
    
    @Before
    public void setUp() {
        
        reverse = new Reverse();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ReverseTest1() {
        
        int[] arr = {1,2,3};
        int[] actual = reverse.Reverse(arr);
        int[] expected = {3,2,1};
        
        Assert.assertArrayEquals(expected, actual);
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
