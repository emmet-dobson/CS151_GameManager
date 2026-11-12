package com.gamemanager.ui;

import com.gamemanager.App;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/** Persistent toolbar. Always contains "Main Menu"; games may add buttons later. */
public class Toolbar extends HBox {

    public Toolbar(App app) {
        setSpacing(10);
        setPadding(new Insets(8));
        Button mainMenu = new Button("Main Menu");
        mainMenu.setOnAction(e -> app.showMainMenu());
        getChildren().add(mainMenu);
    }
}
