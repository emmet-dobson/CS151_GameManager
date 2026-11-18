package com.gamemanager.games.blackjack;

public class ComputerPlayer extends Player {

    private final Strategy strategy;

    public ComputerPlayer(String name, int balance, Strategy strategy) {
        super(name, balance);
        this.strategy = strategy;
    }

    public boolean wantsHit(DecisionContext context) {
        return strategy.shouldHit(context);
    }

    
}
