/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rps.RPS;

/**
 *
 * @author Christian Choi
 */
public class RPSTest {
    
    RPS rps;
    
    public RPSTest() {
    }
    
    @Before
    public void setUp() {
        
        rps = new RPS();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIsValidNumber() {
        
        boolean result = rps.getRounds().isValidNumber(1);
        boolean result2 = rps.getRounds().isValidNumber(10);
        boolean result3 = rps.getRounds().isValidNumber(11);
        boolean result4 = rps.getRounds().isValidNumber(0);
        boolean result5 = rps.getRounds().isValidNumber(101);
        
        Assert.assertTrue(result);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
        Assert.assertFalse(result4);
        Assert.assertFalse(result5);
        
    }
    
    @Test
    public void TestCompareChoices() {
        
        String rock = "rock";
        String paper = "paper";
        String scissors = "scissors";
        
        String result = rps.getRounds().compareChoices(rock, rock);
        String result2 = rps.getRounds().compareChoices(paper, paper);
        String result3 = rps.getRounds().compareChoices(scissors, scissors);
        String result4 = rps.getRounds().compareChoices(rock, paper);
        String result5 = rps.getRounds().compareChoices(rock, scissors);
        String result6 = rps.getRounds().compareChoices(paper, scissors);
        String result7 = rps.getRounds().compareChoices(paper, rock);
        String result8 = rps.getRounds().compareChoices(scissors, rock);
        String result9 = rps.getRounds().compareChoices(scissors, paper);
        
        Assert.assertEquals("It's a tie!", result);
        Assert.assertEquals("It's a tie!", result2);
        Assert.assertEquals("It's a tie!", result3);
        Assert.assertEquals("Computer wins!", result4);
        Assert.assertEquals("You win!", result5);
        Assert.assertEquals("Computer wins!", result6);
        Assert.assertEquals("You win!", result7);
        Assert.assertEquals("Computer wins!", result8);
        Assert.assertEquals("You win!", result9);
        
    }
    
    @Test public void TestUpdateResults() {
        
        int wins = rps.getRounds().getPlayerWins();
        int losses = rps.getRounds().getComputerWins();
        int ties = rps.getRounds().getTies();
        
        wins = rps.getRounds().updatePlayerWins("You win!", wins);
        losses = rps.getRounds().updateCompWins("Computer wins!", losses);
        ties = rps.getRounds().updateTies("It's a tie!", ties);
        
        Assert.assertEquals(1, wins);
        Assert.assertEquals(1, losses);
        Assert.assertEquals(1, ties);
        
    }
    
    @Test
    public void TestGameStatus() {
        
        boolean result = rps.playAgain("yes");
        boolean result2 = rps.playAgain("no");
        
        Assert.assertTrue(result);
        Assert.assertFalse(result2);
        
    }
}
