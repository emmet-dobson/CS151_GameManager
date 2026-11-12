package com.gamemanager.ui;

import com.gamemanager.App;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Left: top 5 high scores. Right: 2x2 grid of game buttons (3 games + 1 empty slot).
 * TODO: fill top-5 list from HighScoreStorage; wire game buttons to scenes.
 */
public class MainMenuScene {

    private final BorderPane view = new BorderPane();

    public MainMenuScene(App app) {
        VBox scores = new VBox(6, new Label("Top 5 High Scores"));
        GridPane games = new GridPane();
        games.setHgap(12);
        games.setVgap(12);
        games.add(new Button("Blackjack"), 0, 0);
        games.add(new Button("Snake"), 1, 0);
        games.add(new Button("Connect Four"), 0, 1);
        games.add(new Button("(Empty)"), 1, 1);

        view.setLeft(scores);
        view.setCenter(games);
    }

    public Node getView() {
        return view;
    }
}
