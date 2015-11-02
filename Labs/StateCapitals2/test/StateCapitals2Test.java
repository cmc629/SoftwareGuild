/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import statecapitals2.Capital;
import statecapitals2.StateCapitals2;

/**
 *
 * @author Christian Choi
 */
public class StateCapitals2Test {
    
    StateCapitals2 sc2;
    
    public StateCapitals2Test() {
    }
    
    @Before
    public void setUp() {
    
        sc2 = new StateCapitals2();
    
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void TestCapital() {
        Capital capital = new Capital("Montgomery", 205764, 156);
        sc2.getMap().put("Alabama", capital);
        
        String name = sc2.getMap().get("Alabama").getName();
        int pop = sc2.getMap().get("Alabama").getPopulation();
        int area = sc2.getMap().get("Alabama").getArea();
        
        Assert.assertEquals("Montgomery", name);
        Assert.assertEquals(205764, pop);
        Assert.assertEquals(156, area);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
