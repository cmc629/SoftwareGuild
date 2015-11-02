/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import blackjack.Blackjack;
import blackjack.Dealer;
import blackjack.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Christian Choi
 */
public class BlackjackTest {
    
    Blackjack blackjack;
    Player player;
    Dealer dealer;
    
    public BlackjackTest() {
    }
    
    @Before
    public void setUp() {
        
        player = new Player();
        dealer = new Dealer();
        blackjack = new Blackjack(player, dealer);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestPlayer() {
        
        
        blackjack.getPlayer().setCard1(1);
        blackjack.getPlayer().setCard2(2);
        blackjack.getPlayer().setCardTotal(blackjack.getPlayer().getCard1() + blackjack.getPlayer().getCard2());
        int cardTotal1 = blackjack.getPlayer().getCardTotal();
        
        Assert.assertEquals(3, cardTotal1);
        
        blackjack.getPlayer().checkBust();
        boolean notBust = blackjack.getPlayer().getIsBust();
        
        Assert.assertFalse(notBust);
        
        blackjack.getPlayer().setCardTotal(22);
        blackjack.getPlayer().checkBust();
        boolean isBust = blackjack.getPlayer().getIsBust();
        
        Assert.assertTrue(isBust);
        
    }
    
    @Test
    public void TestDealer() {
        
        blackjack.getDealer().setCard1(1);
        blackjack.getDealer().setCard2(2);
        blackjack.getDealer().setCardTotal(blackjack.getDealer().getCard1() + blackjack.getDealer().getCard2());
        int cardTotal1 = blackjack.getDealer().getCardTotal();
        
        Assert.assertEquals(3, cardTotal1);
        
        blackjack.getDealer().checkBust();
        boolean notBust = blackjack.getDealer().getIsBust();
        
        Assert.assertFalse(notBust);
        
        blackjack.getDealer().setCardTotal(22);
        blackjack.getDealer().checkBust();
        boolean isBust = blackjack.getDealer().getIsBust();
        
        Assert.assertTrue(isBust);
        
    }
    
    @Test
    public void TestCheckPlayerHit() {
        
        boolean result = blackjack.checkPlayerHit("hit");
        boolean result2 = blackjack.checkPlayerHit("stay");
        
        Assert.assertTrue(result);
        Assert.assertFalse(result2);
        
    }
}
