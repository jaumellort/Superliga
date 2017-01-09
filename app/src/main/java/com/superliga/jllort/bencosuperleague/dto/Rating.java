package com.superliga.jllort.bencosuperleague.dto;

/**
 * Created by jllort on 12/29/2016.
 */

public class Rating {

    private int matchId;
    private int raterId;
    private int ratedId;
    private float rating;
    private String comments;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getRaterId() {
        return raterId;
    }

    public void setRaterId(int raterId) {
        this.raterId = raterId;
    }

    public int getRatedId() {
        return ratedId;
    }

    public void setRatedId(int ratedId) {
        this.ratedId = ratedId;
    }

    public float getRating() {
        return rating;

    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
