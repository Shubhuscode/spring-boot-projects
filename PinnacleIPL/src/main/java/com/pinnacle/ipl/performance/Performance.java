package com.pinnacle.ipl.performance;

import com.pinnacle.ipl.player.Player;
import com.pinnacle.ipl.team.Team;

public class Performance {
    private Long performanceID;
    private int runs;
    private int balls;
    private int wickets;
    private int overs;
    private Long playerID;
    private Long matchID;
    
   
    private Player player;
    private Team team;

    public Performance(Long performanceID, int runs, int balls, int wickets, int overs, Long playerID, Long matchID) {
        this.performanceID = performanceID;
        this.runs = runs;
        this.balls = balls;
        this.wickets = wickets;
        this.overs = overs;
        this.playerID = playerID;
        this.matchID = matchID;
    }

   
    public Long getPerformanceID() {
        return performanceID;
    }

    public void setPerformanceID(Long performanceID) {
        this.performanceID = performanceID;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public Long getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Long playerID) {
        this.playerID = playerID;
    }

    public Long getMatchID() {
        return matchID;
    }

    public void setMatchID(Long matchID) {
        this.matchID = matchID;
    }

   
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
