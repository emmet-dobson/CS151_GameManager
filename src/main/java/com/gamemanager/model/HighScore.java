package com.gamemanager.model;

/** One score entry: a username and an int score, tagged with the game it came from. */
public class HighScore {

    private final String username;
    private final String gameName;
    private int score;

    public HighScore(String username, String gameName, int score) {
        this.username = username;
        this.gameName = gameName;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public String getGameName() {
        return gameName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
