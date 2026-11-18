package com.gamemanager.games.blackjack;

import com.gamemanager.games.AbstractGame;

/** Blackjack rules and state. No JavaFX here. TODO: deck, hands, bets, turns, save state. */
public class BlackjackGame extends AbstractGame {

    private final Deck deck;
    private final Player you;
    private final Player cpu1;
    private final Player cpu2;
    private final Player dealer;

    public BlackjackGame(String playerName, int startingBalance) {
        super("Blackjack");
        this.deck = new Deck();
        this.you = new Player(playerName, startingBalance);
        this.cpu1 = new Player("CPU 1", 100);
        this.cpu2 = new Player("CPU 2", 100);
        this.dealer = new Player("Dealer", -1); 
    }

    public final void dealInitialCards() {
        this.deck.shuffle();
        // Deal two cards to each player and the dealer
        you.addCard(deck.drawCard());
        cpu1.addCard(deck.drawCard());
        cpu2.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        you.addCard(deck.drawCard());
        cpu1.addCard(deck.drawCard());
        cpu2.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
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



