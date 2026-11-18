package com.gamemanager.games.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int balance; // Starting balance for each player
    private int bet; // Current bet for the round
    private final Hand hand; // Player's hand of cards
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, int startingBalance) {
        this.name = name;
        this.balance = startingBalance;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int setBalance(int balance) {
        this.balance = balance;
        return balance;
    }

    public int adjustBalance(int amount) {
        this.balance += amount;
        return balance;
    }

    public int getBet() {
        return bet;
    }

    public int setBet(int bet) {
        if (bet > balance) {
            throw new IllegalArgumentException("Bet cannot exceed current balance");
        }
        this.bet = bet;
        return bet;
    }

    public Hand getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
        cards.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank().equals("A")) {
                aceCount++;
            }
        }

        // Adjust for Aces if value exceeds 21
        while (value > 21 && aceCount > 0) {
            value -= 10; // Count Ace as 1 instead of 11
            aceCount--;
        }

        return value;
    }

    public void printHand() {
        System.out.print(name + "'s hand: ");
        for (Card card : cards) {
            System.out.print(card.getRank() + " of " + card.getSuit() + ", ");
        }
        System.out.println("Total value: " + getHandValue());
    }
 
}
