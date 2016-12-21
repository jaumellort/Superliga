package com.superliga.jllort.bencosuperleague.dto;

/**
 * Created by jllort on 12/20/2016.
 */

public class User {

    private Integer id;
    private String name;
    private String gamerTag;
    private String preferedTeam;
    private String currentLeagueTeam;
    private float rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGamerTag() {
        return gamerTag;
    }

    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    public String getPreferedTeam() {
        return preferedTeam;
    }

    public void setPreferedTeam(String preferedTeam) {
        this.preferedTeam = preferedTeam;
    }

    public String getCurrentLeagueTeam() {
        return currentLeagueTeam;
    }

    public void setCurrentLeagueTeam(String currentLeagueTeam) {
        this.currentLeagueTeam = currentLeagueTeam;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
