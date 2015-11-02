/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague.controllers;

import baseballleague.dao.BaseballLeagueDAO;
import baseballleague.dto.League;
import baseballleague.dto.Player;
import baseballleague.dto.Team;
import baseballleague.ui.ConsoleIO;
import java.util.Collection;
import java.util.List;

public class BaseballLeagueController {

    private final BaseballLeagueDAO dao = new BaseballLeagueDAO();
    private final ConsoleIO io = new ConsoleIO();
    private League league;

    public void run() {
        league = new League(dao.loadLeague());
        boolean isRunning = true;
        while (isRunning) {
            printMenu();

            int menuSelection = io.promptForIntInRange("", 1, 7);
            switch (menuSelection) {
                case 1:
                    createTeam();
                    break;
                case 2:
                    createPlayer();
                    break;
                case 3:
                    listAllTeams();
                    break;
                case 4:
                    listAllPlayersOnTeam();
                    break;
                case 5:
                    movePlayer();
                    break;
                case 6:
                    removePlayer();
                    break;
                case 7:
                    isRunning = false;
                    io.println("\nGoodbye. Closing program...");
                    break;
            }
        }
        dao.writeLeague(league.listAllTeams());

    }

    public void printMenu() {
        io.println("\nChoose an option:\n1- Add new team\n2- Create new player"
                + "\n3- List all teams\n4- Pick a team to list all players"
                + "\n5- Trade a player\n6- Remove a player\n7- Exit");
    }

    public void createTeam() {
        String name = io.promptForString("Please enter a team name ");
        Team team = new Team(name);
        league.addTeam(team);
    }

    public void createPlayer() {
        Collection<Team> teams = league.listAllTeams();
        if (league.listAllTeams().isEmpty()) {
            io.println("\nYou cannot add a player when there are no teams! Please add a team first!");
        } else {
            String firstName = io.promptForString("\nPlease enter a first name ");
            String lastName = io.promptForString("Please enter a last name ");
            String teamName = "";
            while (!league.listAllTeamNames().contains(teamName)) {
                teamName = io.promptForString("Please enter a valid team name ");
                if (!league.listAllTeamNames().contains(teamName)) {
                    io.println("\n" + teamName + " does not exist!");
                }
            }
            Team selectedTeam = league.getTeamByName(teamName);
            Player player = new Player(firstName, lastName, selectedTeam);
            selectedTeam.addPlayer(player);
            io.println("\n" + firstName + " " + lastName + " was added to " + teamName + "!");
        }
    }

    public void listAllTeams() {
        if (league.listAllTeams().isEmpty()) {
            io.println("\nThere are no teams!");
        } else {
            io.println("\nHere is a list of all the teams:");
            for (String teamName : league.listAllTeamNames()) {
                io.println(teamName);
            }
        }
    }

    public void listAllPlayersOnTeam() {
        listAllTeams();
        if (!league.listAllTeams().isEmpty()) {
            boolean validName = false;
            while (!validName) {
                String teamName = io.promptForString("\nPick a team from above");
                if (!league.listAllTeamNames().contains(teamName)) {
                    io.println(teamName + " does not exist!");
                } else {
                    Team team = league.getTeamByName(teamName);
                    if (team.getPlayerList().isEmpty()) {
                        io.println("\nNo players on this team.");
                    } else {
                        io.println("\nThe players on the " + team.getName() + " are:");
                        for (Player player : team.getPlayerList()) {
                            io.println(player.getFirstName() + " " + player.getLastName());
                        }
                    }
                    validName = true;
                }
            }
        }
    }

    public void movePlayer() {
        if (league.listAllTeams().isEmpty()) {
            io.println("\nYou cannot move a player when there are no teams! Please add a team first!");
            return;
        }
        io.println("\nChoose a team to move the player from: ");
        List<Team> teams = league.listAllTeams();
        for (int i = 0; i <= teams.size(); i++) {
            if (i == teams.size()) {
                io.println(String.format("%d- Exit", i + 1));
            } else {
                io.println(String.format("%d- %s", i + 1, teams.get(i).getName()));
            }
        }
        int selection = io.promptForIntInRange("Enter number:", 1, teams.size() + 1) - 1;
        if (selection == teams.size()) {
            return;
        }
        Team fromTeam = teams.get(selection);
        io.println("\nSelect player to move: ");
        List<Player> players = fromTeam.getPlayerList();
        for (int i = 0; i <= players.size(); i++) {
            if (i == players.size()) {
                io.println(String.format("%d- Exit", i + 1));
            } else {
                io.println(String.format("%d- %s %s", i + 1, players.get(i).getFirstName(), players.get(i).getLastName()));
            }
        }
        int playerSelection = io.promptForIntInRange("Enter number:", 1, players.size() + 1) - 1;
        if (playerSelection == players.size()) {
            return;
        }
        Player selectedPlayer = players.get(playerSelection);
        io.println("\nChoose a team to move the player to: ");
        for (int i = 0; i <= teams.size(); i++) {
            if (i == teams.size()) {
                io.println(String.format("%d- Exit", i + 1));
            } else {
                io.println(String.format("%d- %s", i + 1, teams.get(i).getName()));
            }
        }
        selection = io.promptForIntInRange("Enter number:", 1, teams.size() + 1) - 1;
        if (selection == teams.size()) {
            return;
        }
        Team toTeam = teams.get(selection);
        String playerName = players.get(playerSelection).getFirstName() + " " + players.get(playerSelection).getLastName();
        fromTeam.movePlayer(selectedPlayer, toTeam);
        io.println(String.format("\nPlayer %s was moved from team %s to team %s", playerName, fromTeam.getName(), toTeam.getName()));
    }

    public void removePlayer() {
        if (league.listAllTeams().isEmpty()) {
            io.println("\nYou cannot remove a player when there are no teams! Please add a team first!");
            return;
        }
        io.println("\nChoose a team: ");
        List<Team> teams = league.listAllTeams();
        for (int i = 0; i <= teams.size(); i++) {
            if (i == teams.size()) {
                io.println(String.format("%d- Exit", i + 1));
            } else {
                io.println(String.format("%d- %s", i + 1, teams.get(i).getName()));
            }
        }
        int selection = io.promptForIntInRange("Enter number:", 1, teams.size() + 1) - 1;
        if (selection == teams.size()) {
            return;
        }
        Team selectedTeam = teams.get(selection);
        io.println("Select player to remove: ");
        List<Player> players = selectedTeam.getPlayerList();
        for (int i = 0; i <= players.size(); i++) {
            if (i == players.size()) {
                io.println(String.format("%d- Exit", i + 1));
            } else {
                io.println(String.format("%d- %s %s", i + 1, players.get(i).getFirstName(), players.get(i).getLastName()));
            }
        }
        selection = io.promptForIntInRange("Enter number:", 1, players.size() + 1) - 1;
        if (selection == players.size()) {
            return;
        }
        String playerName = players.get(selection).getFirstName() + " " + players.get(selection).getLastName();
        selectedTeam.removePlayer(players.get(selection));
        io.println(String.format("\nPlayer %s was removed from %s", playerName, selectedTeam.getName()));
    }
}
