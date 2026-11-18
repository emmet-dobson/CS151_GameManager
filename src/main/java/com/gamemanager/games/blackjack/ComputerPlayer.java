package com.gamemanager.games.blackjack;

public class ComputerPlayer extends Player {

    private final Strategy strategy;

    public ComputerPlayer(String name, int balance, Strategy strategy) {
        super(name, balance);
        this.strategy = strategy;
    }

    @Override 
    public void playTurn(Deck deck) {
        // Simple AI: hit if hand value is less than 17
        while (this.getHand().getValue() < 17) {
            this.getHand().add(deck.drawCard());
        }
    }
    
}
