package com.pinnacle.ipl.match;

import com.pinnacle.ipl.team.Team;
import com.pinnacle.ipl.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    private TeamService teamService;

    Match match1 = new Match(1L, "2025-04-01", "Wankhede Stadium", 1L, 2L, "Mumbai Indians win");
    Match match2 = new Match(2L, "2025-04-02", "Feroz Shah Kotla", 2L, 3L, "Delhi Capitals win");
    Match match3 = new Match(3L, "2025-04-03", "M Chinnaswamy Stadium", 1L, 3L, "Chennai Super Kings win");

    List<Match> matches = new ArrayList<>(List.of(match1, match2, match3));

    
    public List<Match> getAllMatches() {
        for (Match match : matches) {
            match.setTeam1(teamService.getTeam(match.getTeam1ID()));  
            match.setTeam2(teamService.getTeam(match.getTeam2ID()));  
        }
        return matches;
    }

   
    public Match getMatch(Long id) {
        Match match = matches.stream()
                .filter(m -> id.equals(m.getMatchID()))
                .findFirst()
                .orElse(null);
        if (match != null) {
            match.setTeam1(teamService.getTeam(match.getTeam1ID())); 
            match.setTeam2(teamService.getTeam(match.getTeam2ID()));  
        }
        return match;
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

   
    public void deleteMatch(Long id) {
        matches.removeIf(match -> match.getMatchID().equals(id));
    }

  
    public void updateMatch(Long id, Match updatedMatch) {
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getMatchID().equals(id)) {
                matches.set(i, updatedMatch);
                return;
            }
        }
    }
}
