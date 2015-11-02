/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import factorizer.Factorizer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Christian Choi
 */
public class FactorizerTest {
    
    Factorizer f;
    Factorizer f2;
    
    public FactorizerTest() {
    }
    
    @Before
    public void setUp() {
        
        f = new Factorizer(6);
        f2 = new Factorizer(11);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        
        int[] expected1 = {1,2,3};
        
        Assert.assertArrayEquals(expected1, f.getFactorArray());
        Assert.assertEquals(6, f.getNumber());
        Assert.assertEquals(6, f.getFactorSum());
        
        int[] expected2 = {1};
        
        Assert.assertArrayEquals(expected2, f2.getFactorArray());
        Assert.assertEquals(11, f2.getNumber());
        Assert.assertEquals(1, f2.getFactorSum());
        
    }
    
    @Test
    public void testGetFactorArrayLength() {
        
        int length = f.getFactorArrayLength(3);
        
        Assert.assertEquals(1, length);
        
        int length2 = f.getFactorArrayLength(6);
        
        Assert.assertEquals(3, length2);
        
        int length3 = f.getFactorArrayLength(12);
        
        Assert.assertEquals(5, length3);
    }
    
    @Test
    public void testCreateFactorArray() {
        
        int[] actual = f.createFactorArray(f.getNumber(), f.getFactorArrayLength(f.getNumber()));
        int[] expected = {1,2,3};
        Assert.assertArrayEquals(expected, actual);
        
        f.setNumber(15);
        actual = f.createFactorArray(f.getNumber(), f.getFactorArrayLength(f.getNumber()));
        int[] newExpected = {1,3,5};
        Assert.assertArrayEquals(newExpected, actual);
        
    }
    
    @Test
    public void testGenerateFactorSum() {
        
        int expected1 = f.generateFactorSum(f.getNumber());
        f.setNumber(24);
        int expected2 = f.generateFactorSum(f.getNumber());
        
        Assert.assertEquals(6, expected1);
        Assert.assertEquals(36,expected2);
    }
    
    @Test
    public void testIsPerfect() {
        
        boolean result1 = f.isPerfect(f.getNumber(), f.getFactorSum());
        
        Assert.assertTrue(result1);
        
        f.setNumber(12);
        boolean result2 = f.isPerfect(f.getNumber(), f.getFactorSum());
        
        Assert.assertFalse(result2);
        
    }
    
    @Test
    public void testIsPrime() {
        
        boolean result1 = f.isPrime(f.getNumber(), f.getFactorSum());
        
        Assert.assertFalse(result1);
        
        boolean result2 = f2.isPrime(f2.getNumber(), f2.getFactorSum());
        
        Assert.assertTrue(result2);
    }
    
}
