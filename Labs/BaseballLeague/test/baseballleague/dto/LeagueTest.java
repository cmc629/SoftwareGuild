/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class LeagueTest {

    League league;

    public LeagueTest() {
        league = new League();
    }

    @Test
    public void testAddTeam() {
        Team pirates = new Team("Pirates");
        pirates.setId(1);
        league.addTeam(pirates);
        assertTrue(league.getTeamByName("Pirates").equals(pirates));
    }

    @Test
    public void testAddTeamsWithoutIds() {
        Team pirates = new Team("Pirates");
        Team dodgers = new Team("Dodgers");
        league.addTeam(pirates);
        league.addTeam(dodgers);
        assertTrue(league.getTeamByName("Pirates").getId() == 0);
        assertTrue(league.getTeamByName("Dodgers").getId() == 1);
    }

    @Test
    public void testAddTeamsWithNoncontiguousIds() {
        Team pirates = new Team("Pirates");
        pirates.setId(5);
        Team dodgers = new Team("Dodgers");

        league.addTeam(pirates);
        league.addTeam(dodgers);
        assertTrue(league.getTeamByName("Pirates").getId() == 5);
        assertTrue(league.getTeamByName("Dodgers").getId() == 6);
    }

    @Test
    public void testListAllTeams() {
        Team pirates = new Team("Pirates");
        pirates.setId(1);
        Team dodgers = new Team("Dodgers");

        league.addTeam(pirates);
        league.addTeam(dodgers);
        assertTrue(league.listAllTeams().contains(pirates));
        assertTrue(league.listAllTeams().contains(dodgers));
    }

    @Test
    public void testListAllTeamNames() {
        Team pirates = new Team("Pirates");
        pirates.setId(1);
        Team dodgers = new Team("Dodgers");

        league.addTeam(pirates);
        league.addTeam(dodgers);
        assertTrue(league.listAllTeamNames().contains(pirates.getName()));
        assertTrue(league.listAllTeamNames().contains(dodgers.getName()));
    }

    @Test
    public void testListAllPlayers() {
        Team pirates = new Team("Pirates");
        Player jeffLocke = new Player("Jeff", "Locke", pirates);
        pirates.addPlayer(jeffLocke);
        Team dodgers = new Team("Dodgers");
        Player zackGrenike = new Player("Zack", "Grenike", dodgers);
        dodgers.addPlayer(zackGrenike);
        league.addTeam(dodgers);
        league.addTeam(pirates);
        assertTrue(league.listAllPlayers().contains(zackGrenike));
        assertTrue(league.listAllPlayers().contains(jeffLocke));
    }
}
