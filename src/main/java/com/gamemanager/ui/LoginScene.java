package com.gamemanager.ui;

import com.gamemanager.App;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/** Placeholder login screen. TODO: username/password fields, UserStorage checks. */
public class LoginScene {

    private final VBox view = new VBox(12);

    public LoginScene(App app) {
        view.setAlignment(Pos.CENTER);
        Button logIn = new Button("Log In");
        Button createAccount = new Button("Create Account");
        // TODO: replace with real credential checks via UserStorage
        logIn.setOnAction(e -> app.onLoginSuccess(null));
        createAccount.setOnAction(e -> app.onLoginSuccess(null));
        view.getChildren().addAll(logIn, createAccount);
    }

    public Node getView() {
        return view;
    }
}
