package com.gamemanager.games.blackjack;

public enum Phase {
    BETTING,        // Players place bets
    DEALING,        // Initial cards are dealt  
    PLAYER_TURN,    
    DEALER_TURN,
    ROUND_OVER      // Round ends, determine winners and update balances
}
