package com.gamemanager.games.connectfour;

import com.gamemanager.App;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/** Connect Four UI only. TODO: board, mouse + keyboard input, animation, overlays. */
public class ConnectFourScene {

    private final StackPane view = new StackPane(new Label("Connect Four - coming soon"));

    public ConnectFourScene(App app, ConnectFourGame game) {
    }

    public Node getView() {
        return view;
    }
}
