/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class League {

    private int nextId;
    private final Map<Integer, Team> teams = new HashMap<>();

    public League(Collection<Team> teams) {
        if (teams.size() > 0) {
            this.teams.putAll(teams.stream().collect(Collectors.toMap(e -> e.getId(), e -> e)));
            nextId = this.teams.keySet().stream().mapToInt(Integer::intValue).max().getAsInt() + 1;
        }
    }

    public League() {
        nextId = 0;
    }

    public void addTeam(Team team) {
        if (team.getId() == null) {
            team.setId(nextId++);
        }
        if (team.getId() >= nextId) {
            nextId = team.getId() + 1;
        }
        if (teams.containsKey(team.getId())) {
            throw new IllegalStateException("Tried to add a team with an id already in the system.");
        }
        teams.put(team.getId(), team);
    }

    public List<Team> listAllTeams() {
        List<Team> teamsList = new ArrayList();
        teamsList.addAll(teams.values());
        return teamsList;
    }

    public List<String> listAllTeamNames() {
        List<String> nameList = new ArrayList();
        for (Team team : listAllTeams()) {
            nameList.add(team.getName());
        }
        return nameList;
    }

    public List<Player> listAllPlayers() {
        List<Player> playerList = new ArrayList();
        for (Team team : listAllTeams()) {
            for (Player player : team.getPlayerList()) {
                playerList.add(player);
            }
        }
        return playerList;
    }

    public Team getTeamByName(String name) {
        for (Team team : listAllTeams()) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }
}
