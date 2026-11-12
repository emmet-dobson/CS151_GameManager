package com.gamemanager.games.snake;

import com.gamemanager.games.AbstractGame;

/** Snake rules and state. No JavaFX here. TODO: grid, movement, food, collisions. */
public class SnakeGame extends AbstractGame {

    public SnakeGame() {
        super("Snake");
    }

    @Override
    public boolean isOver() {
        return false; // TODO: wall or self collision
    }

    @Override
    public void reset() {
        // TODO
    }
}
