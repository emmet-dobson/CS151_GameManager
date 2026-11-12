package com.gamemanager.games.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gamemanager.games.AbstractGame;

/** Blackjack rules and state. No JavaFX here. TODO: deck, hands, bets, turns, save state. */
public class BlackjackGame extends AbstractGame {

    private final Deck deck;
    private final Player you;
    private final Player cpu1;
    private final Player cpu2;
    private final Player dealer;

    public BlackjackGame() {
        super("Blackjack");
        this.deck = new Deck();
        this.you = new Player("You");
        this.cpu1 = new Player("CPU 1");
        this.cpu2 = new Player("CPU 2");
        this.dealer = new Player("Dealer");
        dealInitialCards();
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

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.you.printHand();
        game.cpu1.printHand();
        game.cpu2.printHand();
        game.dealer.printHand();
    }
}

class Card {
    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return switch (rank) {
            case "A" -> 11;
            case "K", "Q", "J" -> 10;
            default -> Integer.parseInt(rank);
        }; // Ace can be 1 or 11, but we'll handle that in the game logic
    }
}

class Deck {

    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    public final void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No more cards in the deck");
        }
        return cards.remove(cards.size() - 1);
    }
}

 class Player {
    private final String name;
    private final List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
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
        for (Card card : hand) {
            System.out.print(card.getRank() + " of " + card.getSuit() + ", ");
        }
        System.out.println("Total value: " + getHandValue());
    }
 }
