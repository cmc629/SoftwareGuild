/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import interestcalculator.InterestCalculator;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Choi
 */
public class InterestCalculatorTest {
    
    InterestCalculator ic;
    
    public InterestCalculatorTest() {
    }
    
    @Before
    public void setUp() {
        
        ic = new InterestCalculator(10.0f, 5.0f, 3, 4);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        
        float initial = ic.getInitialPrincipal();
        float aIR = ic.getAnnualInterestRate();
        int year = ic.getYear();
        int compound = ic.getCompound();
        
        Assert.assertEquals(10.0f, initial);
        Assert.assertEquals(5.0f, aIR);
        Assert.assertEquals(3, year);
        Assert.assertEquals(4, compound);
        
    }
    
    @Test
    public void testCompoundStrToInt() {
        
        int compound = ic.compoundStringToInt("quarterly");
        
        Assert.assertEquals(4, compound);
        
        compound = ic.compoundStringToInt("monthly");
        
        Assert.assertEquals(12, compound);
        
        compound = ic.compoundStringToInt("daily");
        
        Assert.assertEquals(365, compound);
        
    }
    
    @Test
    public void testGetBalance() {
        
        float newBalance = ic.getCurrentBalance(1, ic.getCompound(), ic.getInitialPrincipal(), ic.getAnnualInterestRate());
        
        Assert.assertEquals(10.509453f, newBalance);
        
        ic.setInitialPrincipal(newBalance);
        
        newBalance = ic.getCurrentBalance(1, ic.getCompound(), ic.getInitialPrincipal(), ic.getAnnualInterestRate());
        
        Assert.assertEquals(11.044861f, newBalance);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
