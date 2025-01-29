package com.pinnacle.ipl.player;

import com.pinnacle.ipl.team.Team;

public class PlayerWithTeam {

    private Long playerID;
    private String playerName;
    private String nationality;
    private String role;
    private Team team; 

  
    public PlayerWithTeam(Player player, Team team) {
        this.playerID = player.getPlayerID();
        this.playerName = player.getPlayerName();
        this.nationality = player.getNationality();
        this.role = player.getRole();
        this.team = team;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
