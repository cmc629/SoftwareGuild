
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
public class FirstAndLastTest {
    
    FirstLast6 firstLast6;

    
    public FirstAndLastTest() {
    }
    
    @Before
    public void setUp() {
        
        firstLast6 = new FirstLast6();

    }
    
    @After
    public void tearDown() {
    }

    
//FirstLast6({1, 2, 6}) -> true
//FirstLast6({6, 1, 2, 3}) -> true
//FirstLast6({13, 6, 1, 2, 3}) -> false

    @Test
    public void firstLast126() {
        
        int[] arr = {1,2,6};
        
        boolean result = firstLast6.firstLast6(arr);
        
        Assert.assertTrue(result);

    }


    @Test
    public void firstLast6123() {
        
        int[] arr = {6,1,2,3};
        
        boolean result = firstLast6.firstLast6(arr);

        Assert.assertTrue(result);

    }


    @Test
    public void firstLast136123() {
        
        int[] arr = {13,6,1,2,3};
        
        boolean result = firstLast6.firstLast6(arr);
        
        Assert.assertFalse(result);

    }
        
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
