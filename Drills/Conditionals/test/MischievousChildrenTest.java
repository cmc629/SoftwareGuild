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
public class MischievousChildrenTest {
    
    MischievousChildren mc;
    
    public MischievousChildrenTest() {
    }
    
    @Before
    public void setUp() {
        
        mc = new MischievousChildren();
        
    }
    
    @After
    public void tearDown() {
    }

    //AreWeInTrouble(true, true) -> true
    @Test
    public void AWT1() {
        
        boolean aSmile = true;
        boolean bSmile = true;
        boolean result = mc.AreWeInTrouble(aSmile,bSmile);
        
        Assert.assertTrue(result);
        
    }
    //AreWeInTrouble(false, false) -> true
    @Test
    public void AWT2() {
        
        boolean aSmile = false;
        boolean bSmile = false;
        boolean result = mc.AreWeInTrouble(aSmile,bSmile);
        
        Assert.assertTrue(result);
        
    }
    //AreWeInTrouble(true, false) -> false
    @Test
    public void AWT3() {
        
        boolean aSmile = true;
        boolean bSmile = false;
        boolean result = mc.AreWeInTrouble(aSmile,bSmile);
        
        Assert.assertFalse(result);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
