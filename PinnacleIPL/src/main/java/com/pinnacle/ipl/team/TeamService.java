package com.pinnacle.ipl.team;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TeamService {

   
    Team team1 = new Team(1L, "Mumbai Indians", "Mukesh Ambani");
    Team team2 = new Team(2L, "Delhi Capitals", "Parth Jindal");
    Team team3 = new Team(3L, "Chennai Super Kings", "N. Srinivasan");

   
    List<Team> teams = new ArrayList<>(List.of(team1, team2, team3));

    
    public List<Team> getAllTeams() {
        return teams;
    }

   
    public Team getTeam(Long id) {
        return teams.stream()
                    .filter(t -> id.equals(t.getTeamID()))
                    .findFirst()
                    .orElse(null);
    }

   
    public void addTeam(Team team) {
        teams.add(team);
    }

    
    public void deleteTeam(Long id) {
        teams.removeIf(t -> t.getTeamID().equals(id));
    }

  
    public void updateTeam(Long id, Team updatedTeam) {
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            if (team.getTeamID().equals(id)) {
                teams.set(i, updatedTeam);
            }
            
        }
    }
}
