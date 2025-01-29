package com.pinnacle.ipl.player;

import com.pinnacle.ipl.team.Team;

public class Player {
    private Long playerID;
    private String playerName;
    private String nationality;
    private String role; 
    private Long teamID;
    private Team team; 

    public Player(Long playerID, String playerName, String nationality, String role, Long teamID) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.nationality = nationality;
        this.role = role;
        this.teamID = teamID;
    }

   
    public Long getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Long playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
