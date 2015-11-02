/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import luckysevens.Dice;
import luckysevens.LuckySevens;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Choi
 */
public class LuckySevensTest {
    
    LuckySevens game;
    
    public LuckySevensTest() {
    }
    
    @Before
    public void setUp() {
        
        game = new LuckySevens();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConstructor() {
        
        int counter = game.getRound().getCounter();
        int counterMax = game.getRound().getCounterAtMaxMoney();
        int current = game.getPlayer().getCurrentMoney();
        int max = game.getPlayer().getMaxMoney();
        
        Assert.assertEquals(0, counter);
        Assert.assertEquals(0, counterMax);
        Assert.assertEquals(0, current);
        Assert.assertEquals(0, max);
        
    }
    
    @Test
    public void testDiceSum() {
        
        boolean result = false;
        if (game.getRound().getDiceSum() >= 2 && 
                game.getRound().getDiceSum() <= 12) {
            result = true;
        }
        
        Assert.assertEquals(true, result);
    }
    
//    @Test
//    public void testAskMoneyToBet() {
//        
//        int moneypool = game.getRound().askMoneyToBet();
//        
//        Assert.assertEquals(100, moneypool);
//        
//    }
    
    @Test
    public void testUpdate() {
        
        game.getRound().update(7);
        int counter = game.getRound().getCounter();
        int counterMax = game.getRound().getCounterAtMaxMoney();
        int current = game.getPlayer().getCurrentMoney();
        int max = game.getPlayer().getMaxMoney();
        
        Assert.assertEquals(1, counter);
        Assert.assertEquals(1, counterMax);
        Assert.assertEquals(4, current);
        Assert.assertEquals(4, max);
        
        game.getRound().update(7);
        counter = game.getRound().getCounter();
        counterMax = game.getRound().getCounterAtMaxMoney();
        current = game.getPlayer().getCurrentMoney();
        max = game.getPlayer().getMaxMoney();
        
        Assert.assertEquals(2, counter);
        Assert.assertEquals(2, counterMax);
        Assert.assertEquals(8, current);
        Assert.assertEquals(8, max);
        
        game.getRound().update(9);
        counter = game.getRound().getCounter();
        counterMax = game.getRound().getCounterAtMaxMoney();
        current = game.getPlayer().getCurrentMoney();
        max = game.getPlayer().getMaxMoney();
        
        Assert.assertEquals(3, counter);
        Assert.assertEquals(2, counterMax);
        Assert.assertEquals(7, current);
        Assert.assertEquals(8, max);
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
