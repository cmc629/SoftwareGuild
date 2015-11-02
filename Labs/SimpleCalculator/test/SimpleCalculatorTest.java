/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import simplecalculator.SimpleCalculator;

/**
 *
 * @author Christian Choi
 */
public class SimpleCalculatorTest {
    
    SimpleCalculator sc;
    
    public SimpleCalculatorTest() {
    }
    
    @Before
    public void setUp() {
        
        sc = new SimpleCalculator();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestAddition() {
        
        double sum = sc.addition(15.5, 13.4);
        Assert.assertEquals(28.9, sum, 0.001);
        
        sum = sc.addition(-15, 30);
        Assert.assertEquals(15, sum, 0.001);
        
        sum = sc.addition(34.4, -53.5);
        Assert.assertEquals(-19.1, sum, 0.001);
        
        sum = sc.addition(104.34, 0);
        Assert.assertEquals(104.34, sum, 0.001);
    }
    
    @Test
    public void TestSubtraction() {
        
        double difference = sc.subtraction(30, 15);
        Assert.assertEquals(15, difference, 0.001);
        
        difference = sc.subtraction(-15, 30);
        Assert.assertEquals(-45, difference, 0.001);
        
        difference = sc.subtraction(34.4, -53.5);
        Assert.assertEquals(87.9, difference, 0.001);
        
        difference = sc.subtraction(104.34, 0);
        Assert.assertEquals(104.34, difference, 0.001);
        
        difference = sc.subtraction(0, 104.34);
        Assert.assertEquals(-104.34, difference, 0.001);
        
    }
    
    @Test
    public void TestMultiplication() {
        
        double product = sc.multiplication(2.5, 3);
        Assert.assertEquals(7.5, product, 0.001);
        
        product = sc.multiplication(0, 1);
        Assert.assertEquals(0, product, 0.001);
        
        product = sc.multiplication(100, 0);
        Assert.assertEquals(0, product, 0.001);
        
        product = sc.multiplication(1, 34.5);
        Assert.assertEquals(34.5, product, 0.001);
        
        product = sc.multiplication(543.2, 1);
        Assert.assertEquals(543.2, product, 0.001);
        
        product = sc.multiplication(34.3, -0.5);
        Assert.assertEquals(-17.15, product, 0.001);
        
        product = sc.multiplication(-4, 12.5);
        Assert.assertEquals(-50, product, 0.001);
        
        product = sc.multiplication(-4.5, -3);
        Assert.assertEquals(13.5, product, 0.001);
        
    }
    
    @Test
    public void TestDivision() {
        
        double quotient = sc.division(4.0, 2.0);
        Assert.assertEquals(2.0, quotient, 0.001);
        
        quotient = sc.division(-45, 3);
        Assert.assertEquals(-15, quotient, 0.001);
        
        quotient = sc.division(2, -5);
        Assert.assertEquals(-0.4, quotient, 0.001);
        
        quotient = sc.division(-24, -8);;
        Assert.assertEquals(3, quotient, 0.001);
        
    }
    
    @Test //(expected = ArithmeticException.class)
    public void TestDivisionByZero() {
        
        double quotient = sc.division(4, 0);
        Assert.assertEquals(Double.POSITIVE_INFINITY, quotient, 0.001);
        
        double quotient2 = sc.division(-4, 0);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, quotient2, 0.001);
        
    }
}
