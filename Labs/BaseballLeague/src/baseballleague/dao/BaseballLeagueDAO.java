/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague.dao;

import baseballleague.dto.Player;
import baseballleague.dto.Team;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class BaseballLeagueDAO {

    private static final String fileName = "league.txt";
    private static final String listElementDelimiter = "#%#";
    private static final String playerPropertyDelimiter = "!@!";

    public Collection<Team> loadLeague() {
        Collection<Team> teams = new HashSet<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));

            while (sc.hasNext()) {
                String line = sc.nextLine();

                String[] properties = line.split(",");
                Team team = new Team(properties[1]);
                team.setId(Integer.parseInt(properties[0]));
                if (properties.length > 2) {
                    String[] playerArray = properties[2].split(listElementDelimiter);
                    for (String player : playerArray) {
                        String[] playerProperties = player.split(playerPropertyDelimiter);
                        Player newPlayer = new Player(playerProperties[0], playerProperties[1], team);
                        team.getPlayerList().add(newPlayer);
                    }
                }
                teams.add(team);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File with league data couldn't be found.");
        }
        return teams;
    }

    public void writeLeague(Collection<Team> teams) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.fileName))) {
            for (Team team : teams) {
                String playerListString = "";
                for (Player player : team.getPlayerList()) {
                    String playerString = String.format("%s" + playerPropertyDelimiter + "%s",
                            player.getFirstName(),
                            player.getLastName());
                    playerListString += (playerString + listElementDelimiter);
                }

                writer.printf("%d,%s,%s", team.getId(),
                        team.getName(),
                        playerListString);
                writer.println();
            }
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(BaseballLeagueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
