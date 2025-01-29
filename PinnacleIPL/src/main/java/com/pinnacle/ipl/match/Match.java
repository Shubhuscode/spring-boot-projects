package com.pinnacle.ipl.match;

import com.pinnacle.ipl.team.Team;

public class Match {
    private Long matchID;
    private String date;
    private String venue;
    private Long team1ID;
    private Long team2ID;
    private String result;
    private Team team1; 
    private Team team2;  

    public Match(Long matchID, String date, String venue, Long team1ID, Long team2ID, String result) {
        this.matchID = matchID;
        this.date = date;
        this.venue = venue;
        this.team1ID = team1ID;
        this.team2ID = team2ID;
        this.result = result;
    }

   
    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    // Getters and setters for other fields
    public Long getMatchID() {
        return matchID;
    }

    public void setMatchID(Long matchID) {
        this.matchID = matchID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Long getTeam1ID() {
        return team1ID;
    }

    public void setTeam1ID(Long team1ID) {
        this.team1ID = team1ID;
    }

    public Long getTeam2ID() {
        return team2ID;
    }

    public void setTeam2ID(Long team2ID) {
        this.team2ID = team2ID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
