/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.daos;

import flooringmastery.dtos.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Christian Choi
 */
public class StateDaoTest {
    
    //StateDaoImpl dao = new StateDaoImpl();
    StateDaoLambdaImpl dao = new StateDaoLambdaImpl();
    
    public StateDaoTest() {
    }
    
    @Before
    public void setUp() {
        
        dao.load();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void listStatesTest() {
        
        Assert.assertTrue(dao.listCurrentStates().contains("PA"));
        Assert.assertTrue(dao.listCurrentStates().contains("OH"));
        Assert.assertTrue(dao.listCurrentStates().contains("IN"));
        Assert.assertTrue(dao.listCurrentStates().contains("MI"));

    }
    
    @Test
    public void stateTaxRateTest() {
        
        Map<String, State> stateMap = dao.getStates();
        State ohio = stateMap.get("OH");
        double ohioTR = ohio.getTaxRate();
        
        Assert.assertEquals(6.25, ohioTR);
        
        State penn = stateMap.get("PA");
        double pennTR = penn.getTaxRate();
        
        Assert.assertEquals(6.75, pennTR);
        
        State mich = stateMap.get("MI");
        double michTR = mich.getTaxRate();
        
        Assert.assertEquals(5.75, michTR);
        
        State indiana = stateMap.get("IN");
        double indianaTR = indiana.getTaxRate();
        
        Assert.assertEquals(6.00, indianaTR);
        
    }
    
    @Test
    public void isValidStateTest() {
        
        boolean containsOH = dao.isValidState("OH");
        boolean containsMI = dao.isValidState("MI");
        boolean containsIN = dao.isValidState("IN");
        boolean containsPA = dao.isValidState("PA");
        
        Assert.assertTrue(containsOH);
        Assert.assertTrue(containsMI);
        Assert.assertTrue(containsIN);
        Assert.assertTrue(containsPA);
        
        
    }
    
}
