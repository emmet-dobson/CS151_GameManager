package com.gamemanager.games.blackjack;

import java.util.Random;

public class AggressiveStrategy implements Strategy {

    private Random random = new Random();

    public AggressiveStrategy(Random rand) {
        this.random = rand;
    }
    
    @Override
    public boolean shouldHit(DecisionContext context) {
        int value = context.hand().getValue();
        if(value < 13) {
            return true; // Always hit if hand value is less than 13
        } else if(value < 17) {
            // Hit with a 70% chance if hand value is between 13 and 16
            return random.nextDouble() < 0.7;
        } else {
            return false; // Stand if hand value is 17 or more
        }
    }
}
