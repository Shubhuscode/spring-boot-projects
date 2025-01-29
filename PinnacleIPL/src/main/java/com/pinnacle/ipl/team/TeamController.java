package com.pinnacle.ipl.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    
    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

   
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

   
    @PostMapping
    public void addTeam(@RequestBody Team team) {
        teamService.addTeam(team);
    }

    
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

   
    @PutMapping("/{id}")
    public void updateTeam(@PathVariable Long id, @RequestBody Team updatedTeam) {
        teamService.updateTeam(id, updatedTeam);
    }
}
