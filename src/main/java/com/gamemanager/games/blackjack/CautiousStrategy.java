package com.gamemanager.games.blackjack;

public class CautiousStrategy implements Strategy {

    @Override
    public boolean shouldHit(DecisionContext context) {
        // Cautious strategy: hit if hand value is less than 12, otherwise stand
        return context.hand().getValue() < 15;
    }
    
}
