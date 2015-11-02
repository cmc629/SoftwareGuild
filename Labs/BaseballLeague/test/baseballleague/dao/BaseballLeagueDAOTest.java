/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague.dao;

import baseballleague.dto.Player;
import baseballleague.dto.Team;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class BaseballLeagueDAOTest {

    private BaseballLeagueDAO dao = new BaseballLeagueDAO();
    private final String backup = "leaguebackup.txt";
    private final String path = "league.txt";

    public BaseballLeagueDAOTest() throws IOException {

    }

    @Before
    public void setUp() throws IOException {
        //This backs up the file we already have so it isn't affected by the test.
        //Needed because the path inside the DAO is currently hardcoded.
        Files.copy(Paths.get(path), Paths.get(backup), StandardCopyOption.REPLACE_EXISTING);

        FileWriter write = new FileWriter(new File(path));
        write.write("");
        write.append("0,Pirates,Chuck!@!Testa#%#Hank!@!Aaron");
        write.flush();
    }

    @After
    public void tearDown() throws IOException {
        Files.copy(Paths.get(backup), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
        Files.delete(Paths.get(backup));
    }

    @Test
    public void testLoadLeague() {
        Collection<Team> loadedTeams = dao.loadLeague();
        Collection<Team> testTeams = new ArrayList<>();
        Team testTeam = new Team("Pirates");
        testTeam.setId(0);
        testTeam.addPlayer(new Player("Chuck", "Testa", testTeam));
        testTeams.add(testTeam);

        Assert.assertTrue(loadedTeams.containsAll(testTeams) && testTeams.containsAll(loadedTeams));
    }

    @Test
    public void testWriteLeague() throws IOException {
        Collection<Team> testTeams = new ArrayList<>();
        Team testTeam = new Team("Pirates");
        testTeam.setId(0);
        testTeam.addPlayer(new Player("Chuck", "Testa", testTeam));
        testTeams.add(testTeam);

        dao.writeLeague(testTeams);

        Collection<Team> loadedTeams = dao.loadLeague();

        Assert.assertTrue(loadedTeams.containsAll(testTeams) && testTeams.containsAll(loadedTeams));
    }
}
