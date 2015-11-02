/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.GreatParty;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Christian Choi
 */
public class GreatPartyTest {
    
    private GreatParty myParty;
    
    public GreatPartyTest() {
    }
    
    @Before
    public void setUp() {
        
        myParty = new GreatParty();
        
    }
    
    @After
    public void tearDown() {
    }
    

    //greatParty(30, false) - false
    @Test //making a test that's going to run
    public void greatPartyTest() {
        
        boolean result = myParty.greatParty(30, false);
        
        Assert.assertFalse(result);
        
        
    }
    
    //greatParty(50, false) - true    
    @Test
    public void greatParty50AndFalse() {
        
        boolean result = myParty.greatParty(50, false);
        
        Assert.assertTrue(result);
    }

    
    //greatParty(70, true) - true
    @Test
    public void greatParty70AndTrue() {
        
        boolean result = myParty.greatParty(70, true);
        
        Assert.assertTrue(result);
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
