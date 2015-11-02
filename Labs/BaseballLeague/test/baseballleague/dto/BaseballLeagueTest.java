package baseballleague.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import baseballleague.dto.League;
import baseballleague.dto.Player;
import baseballleague.dto.Team;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Christian Choi
 */
//More test cases (this one includes remove and move player)
public class BaseballLeagueTest {
    
    League league;
    Team lakers, bulls;
    Player kobe, derrick, pau;
    
    
    public BaseballLeagueTest() {
    }
    
    @Before
    public void setUp() {
        league = new League();
        lakers = new Team("Lakers");
        bulls = new Team("Bulls");
        kobe = new Player("Kobe", "Bryant", lakers);
        pau = new Player("Pau", "Gasol", lakers);
        derrick = new Player("Derrick", "Rose", bulls);
    }
    
    @After
    public void tearDown() {
    }
    //Using basketball teams and players since I don't follow baseball
    @Test
    public void addTeamTest() {
        
        league.addTeam(bulls);
        Integer expected = 0;
        
        Assert.assertTrue(bulls.getPlayerList().isEmpty());
        Assert.assertEquals(expected, bulls.getId());
        
        
        league.addTeam(lakers);
        Integer expected2 = 1;
        
        Assert.assertEquals(expected2, lakers.getId());
    
    }
    
    @Test
    public void getTeamListTest() {
        
        league.addTeam(bulls);
        league.addTeam(lakers);

        List<Team> expected = new ArrayList<>();
        expected.add(bulls);
        expected.add(lakers);
        
        Assert.assertEquals(expected, league.listAllTeams());
        
    }
    
    @Test
    public void addPlayerTest() {
        
        bulls.addPlayer(derrick);
        List<Player> expected = new ArrayList<>();
        expected.add(derrick);
        
        Assert.assertEquals(expected, bulls.getPlayerList());
        
        lakers.addPlayer(kobe);
        lakers.addPlayer(pau);
        List<Player> expected2 = new ArrayList<>();
        expected2.add(kobe);
        expected2.add(pau);
        
        Assert.assertEquals(expected2, lakers.getPlayerList());
        
    }
    
    @Test
    public void removePlayerTest() {
        
        lakers.addPlayer(kobe);
        lakers.addPlayer(pau);
        lakers.removePlayer(pau);
        List<Player> expected = new ArrayList<>();
        expected.add(kobe);
        
        Assert.assertEquals(expected, lakers.getPlayerList());
        
        
    }
    
    @Test
    public void movePlayerTest() {
        
        lakers.addPlayer(kobe);
        lakers.addPlayer(pau);
        bulls.addPlayer(derrick);
        lakers.movePlayer(pau, bulls);
        
        List<Player> expected = new ArrayList<>();
        expected.add(kobe);
        List<Player> expected2 = new ArrayList<>();
        expected2.add(derrick);
        expected2.add(pau);
        
        Assert.assertEquals(expected, lakers.getPlayerList());
        Assert.assertEquals(expected2, bulls.getPlayerList());
    }

    
}
