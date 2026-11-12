package com.gamemanager.games;

/** Shared state for games (inheritance). Subclasses supply their own rules. */
public abstract class AbstractGame implements Game {

    private final String name;
    private int score;

    protected AbstractGame(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score;
    }

    protected void setScore(int score) {
        this.score = score;
    }
}
