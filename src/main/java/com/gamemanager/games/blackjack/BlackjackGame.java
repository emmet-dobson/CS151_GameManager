package com.gamemanager.games.blackjack;

import com.gamemanager.games.AbstractGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Blackjack rules and state. No JavaFX here. TODO: deck, hands, bets, turns, save state. */
public class BlackjackGame extends AbstractGame {

    private static final int STARTING_BALANCE = 1000; // Default starting balance for players
    private static final int COMPUTER_BET = 10; 

    private final Deck deck;
    private final Player human;
    private final List<Player> players;
    private final Dealer dealer;
    private final Random random;
    private final List<String> messages = new ArrayList<>();


    private Phase currentPhase = Phase.BETTING;
    private int turnIndex = 0; // Index to track whose turn it is

    public BlackjackGame(String playerName) {
        this(playerName, new Random());
    }

    public BlackjackGame(String playerName, Random random) {
        super("Blackjack");
        this.random = random;
        this.deck = new Deck();
        this.human = new Player(playerName, COMPUTER_BET);
        this.players = List.of(
            human,
            new ComputerPlayer("CPU 1", STARTING_BALANCE, new AggressiveStrategy(random)),
            new ComputerPlayer("CPU 2", STARTING_BALANCE, new CautiousStrategy())
        );
        this.dealer = new Dealer();
        setScore(STARTING_BALANCE);
    }

    // -------- Human player actions --------
    public void placeBet(int amount) {
        if(currentPhase!= Phase.BETTING) return; // Only allow betting in the betting phase
        if(amount <= 0 || amount > human.getBalance()) {
            messages.add("Invalid bet.");
            return;
        }
        human.setBet(amount);
        messages.add(human.getName() + " placed a bet of " + amount);
        for(Player player : players) {
            if(player != human) {
                player.setBet(Math.min(COMPUTER_BET, player.getBalance()));
                messages.add(player.getName() + " placed a bet of " + player.getBet());
            }
        }
        dealRound();
    }

    public void hit() {
        if(currentPhase != Phase.PLAYER_TURN || isComputerTurn()) return; // Only allow hitting during the player's turn
        doHit();
    }

    public void stand() {
        if(currentPhase != Phase.PLAYER_TURN || isComputerTurn()) return; // Only allow standing during the player's turn
        doStand();
    }

    // -------- Automation (called by scene) --------

    public void playNextStep() {
        if (currentPhase == Phase.PLAYER_TURN && isComputerTurn()) {

        }
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



