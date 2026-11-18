package com.gamemanager.games.blackjack;

public class Dealer extends Player {

    public Dealer() {
        super("Dealer", -1); // Dealer has no balance
    }

    public boolean wantsHit() {
        return getHandValue() < 17; // Dealer hits on soft 17
    }
    
}
