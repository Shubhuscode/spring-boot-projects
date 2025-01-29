package com.pinnacle.ipl.player;

import com.pinnacle.ipl.team.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    
    Team team1 = new Team(1L, "Mumbai Indians", "Mukesh Ambani");
    Team team2 = new Team(2L, "Delhi Capitals", "Parth Jindal");

 
    Player player1 = new Player(1L, "Virat Kohli", "India", "Batsman", 1L);
    Player player2 = new Player(2L, "Jasprit Bumrah", "India", "Bowler", 1L);
    Player player3 = new Player(3L, "David Warner", "Australia", "Batsman", 2L);
    Player player4 = new Player(4L, "Rohit Sharma", "India", "Batsman", 1L);
    Player player5 = new Player(5L, "Kane Williamson", "New Zealand", "Batsman", 2L);

   
    List<Player> players = new ArrayList<>(List.of(player1, player2, player3, player4, player5));

   
    List<Team> teams = new ArrayList<>(List.of(team1, team2));

  
    public List<Player> getAllPlayers() {
        for (Player player : players) {
            player.setTeam(getTeamByID(player.getTeamID())); 
        }
        return players;
    }

   
    public Player getPlayer(Long id) {
        Player player = players.stream()
                .filter(p -> id.equals(p.getPlayerID()))
                .findFirst()
                .orElse(null);
        if (player != null) {
            player.setTeam(getTeamByID(player.getTeamID())); 
        }
        return player;
    }

   
    private Team getTeamByID(Long teamID) {
        return teams.stream()
                .filter(team -> teamID.equals(team.getTeamID()))
                .findFirst()
                .orElse(null);
    }

  
    public void addPlayer(Player player) {
        players.add(player);
    }

 
    public void deletePlayer(Long id) {
        players.removeIf(p -> p.getPlayerID().equals(id));
    }

    
    public void updatePlayer(Long id, Player updatedPlayer) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getPlayerID().equals(id)) {
                players.set(i, updatedPlayer);
            }
        }
    }
}
