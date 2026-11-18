package com.gamemanager.games.blackjack;

public interface Strategy {
    boolean shouldHit(DecisionContext context);
}
