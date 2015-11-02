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
public class Fix23Test {
    
    Fix23 fix23;
    
    public Fix23Test() {
    }
    
    @Before
    public void setUp() {
        
        fix23 = new Fix23();
        
    }
    
    @After
    public void tearDown() {
    }
    //Fix23({1, 2, 3}) ->{1, 2, 0}
    @Test
    public void Fix23Test1() {
        
        int[] arr = {1,2,3};
        int[] actual = fix23.Fix23(arr);
        int[] expected = {1,2,0};
        
    }
    //Fix23({2, 3, 5}) -> {2, 0, 5}
    @Test
    public void Fix23Test2() {
        
        int[] arr = {2,3,5};
        int[] actual = fix23.Fix23(arr);
        int[] expected = {2,0,5};
        
    }
    //Fix23({1, 2, 1}) -> {1, 2, 1}
    @Test
    public void Fix23Test3() {
        
        int[] arr = {1,2,1};
        int[] actual = fix23.Fix23(arr);
        int[] expected = {1,2,1};
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
