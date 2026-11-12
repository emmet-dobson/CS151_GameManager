package com.gamemanager.games.blackjack;

import com.gamemanager.games.AbstractGame;

/** Blackjack rules and state. No JavaFX here. TODO: deck, hands, bets, turns, save state. */
public class BlackjackGame extends AbstractGame {

    public BlackjackGame() {
        super("Blackjack");
    }

    @Override
    public boolean isOver() {
        return false; // TODO: player out of money
    }

    @Override
    public void reset() {
        // TODO: reshuffle and keep balances
    }
}
