package com.gamemanager.games.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank().equals("A")) {
                aceCount++;
            }
        }

        // Adjust for Aces
        while (value > 21 && aceCount > 0) {
            value -= 10; // Count Ace as 1 instead of 11
            aceCount--;
        }

        return value;
    }

    public int size() {
        return cards.size();
    }

    public boolean isBust() {
        return getValue() > 21;
    }

    public boolean isBlackjack() {
        return getValue() == 21 && cards.size() == 2;
    }



}
