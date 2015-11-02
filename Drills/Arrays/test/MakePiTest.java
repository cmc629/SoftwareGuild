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
public class MakePiTest {
    
    MakePi makePi;
    
    public MakePiTest() {
    }
    
    @Before
    public void setUp() {
        
        makePi = new MakePi();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void MakePi314() {
        
        int[] actual = makePi.MakePi(3);
        int[] expected = {3,1,4};
        //System.out.println("Actual is: " + actual);
        Assert.assertArrayEquals(expected, actual);
        
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
