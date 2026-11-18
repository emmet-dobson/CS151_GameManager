package com.gamemanager.games.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class Deck {

    private final List<Card> cards = new ArrayList<>();
    private final Random random;
    private int nextIndex;

    public Deck() {
        random = new Random();
        reset();
    }

    public void reset() {
        cards.clear();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(cards, random);
        nextIndex = 0;
    }

    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No more cards in the deck");
        }
        return cards.remove(cards.size() - 1);
    }


}
