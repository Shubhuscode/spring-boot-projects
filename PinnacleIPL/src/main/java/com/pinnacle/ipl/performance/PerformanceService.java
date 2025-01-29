package com.pinnacle.ipl.performance;

import com.pinnacle.ipl.player.Player;
import com.pinnacle.ipl.team.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerformanceService {

   
    Player player1 = new Player(1L, "Virat Kohli", "India", "Batsman", 1L);
    Player player2 = new Player(2L, "Jasprit Bumrah", "India", "Bowler", 1L);
    Player player3 = new Player(3L, "David Warner", "Australia", "Batsman", 2L);

   
    Team team1 = new Team(1L, "Mumbai Indians", "Mukesh Ambani");
    Team team2 = new Team(2L, "Delhi Capitals", "Parth Jindal");

   
    Performance performance1 = new Performance(1L, 50, 30, 1, 4, 1L, 1L);
    Performance performance2 = new Performance(2L, 80, 45, 0, 5, 2L, 1L);
    Performance performance3 = new Performance(3L, 120, 65, 2, 10, 3L, 2L);

    List<Performance> performances = new ArrayList<>(List.of(performance1, performance2, performance3));
    List<Player> players = new ArrayList<>(List.of(player1, player2, player3));
    List<Team> teams = new ArrayList<>(List.of(team1, team2));

   
    public List<Performance> getAllPerformances() {
        for (Performance performance : performances) {
            Player player = getPlayerByID(performance.getPlayerID());
            performance.setPlayer(player);  

            Team team = getTeamByID(player.getTeamID());
            performance.setTeam(team);  

           
            performance.setMatchID(performance.getMatchID());  
        }
        return performances;
    }

    
    public Performance getPerformance(Long id) {
        Performance performance = performances.stream()
                .filter(p -> id.equals(p.getPerformanceID()))
                .findFirst()
                .orElse(null);
        if (performance != null) {
            Player player = getPlayerByID(performance.getPlayerID());
            performance.setPlayer(player);  

            Team team = getTeamByID(player.getTeamID());
            performance.setTeam(team);  
        }
        return performance;
    }

    
    private Player getPlayerByID(Long playerID) {
        return players.stream()
                .filter(player -> playerID.equals(player.getPlayerID()))
                .findFirst()
                .orElse(null);
    }

   
    private Team getTeamByID(Long teamID) {
        return teams.stream()
                .filter(team -> teamID.equals(team.getTeamID()))
                .findFirst()
                .orElse(null);
    }

    
    public void addPerformance(Performance performance) {
        performances.add(performance);
    }

   
    public void deletePerformance(Long id) {
        performances.removeIf(p -> p.getPerformanceID().equals(id));
    }

  
    public void updatePerformance(Long id, Performance updatedPerformance) {
        for (int i = 0; i < performances.size(); i++) {
            Performance performance = performances.get(i);
            if (performance.getPerformanceID().equals(id)) {
                performances.set(i, updatedPerformance);
            }
        }
    }
}
