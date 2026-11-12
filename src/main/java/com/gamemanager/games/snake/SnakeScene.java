package com.gamemanager.games.snake;

import com.gamemanager.App;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/** Snake UI only. TODO: canvas board, arrow-key input, Escape pause, game-over overlay. */
public class SnakeScene {

    private final StackPane view = new StackPane(new Label("Snake - coming soon"));

    public SnakeScene(App app, SnakeGame game) {
    }

    public Node getView() {
        return view;
    }
}
