package com.gamemanager.games.blackjack;

public record DecisionContext(
    Hand hand,
    Card dealerUpCard,
    int balance, 
    int bet
) {}