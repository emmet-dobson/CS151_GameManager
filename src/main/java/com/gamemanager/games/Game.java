package com.gamemanager.games;

/** Logic-only contract every game implements. No JavaFX in this package's logic classes. */
public interface Game {

    String getName();

    int getScore();

    boolean isOver();

    void reset();
}
