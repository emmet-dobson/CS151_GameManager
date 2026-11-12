package com.gamemanager.games.connectfour;

import com.gamemanager.games.AbstractGame;

/** Connect Four rules and state (6x7 board). No JavaFX here. TODO: drops, win and draw checks. */
public class ConnectFourGame extends AbstractGame {

    public ConnectFourGame() {
        super("Connect Four");
    }

    @Override
    public boolean isOver() {
        return false; // TODO: win or draw
    }

    @Override
    public void reset() {
        // TODO
    }
}
