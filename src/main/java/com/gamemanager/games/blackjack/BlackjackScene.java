package com.gamemanager.games.blackjack;

import com.gamemanager.App;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/** Blackjack UI only. TODO: hands, Hit/Stand buttons, bets, save/load strings. */
public class BlackjackScene {

    private final StackPane view = new StackPane(new Label("Blackjack - coming soon"));

    public BlackjackScene(App app, BlackjackGame game) {
    }

    public Node getView() {
        return view;
    }
}
