package com.gamemanager;

import com.gamemanager.model.User;
import com.gamemanager.ui.LoginScene;
import com.gamemanager.ui.MainMenuScene;
import com.gamemanager.ui.Toolbar;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Entry point. The toolbar is placed once in the top slot of a single BorderPane,
 * so it stays visible and identical no matter which scene is in the center.
 */
public class App extends Application {

    private final BorderPane root = new BorderPane();
    private final Toolbar toolbar = new Toolbar(this);
    private User currentUser;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Game Manager");
        stage.setScene(new Scene(root, 960, 640));
        showLogin();
        stage.show();
    }

    public void showLogin() {
        currentUser = null;
        setToolbarVisible(false);
        setCenter(new LoginScene(this).getView());
    }

    public void onLoginSuccess(User user) {
        currentUser = user;
        setToolbarVisible(true);
        showMainMenu();
    }

    public void showMainMenu() {
        setCenter(new MainMenuScene(this).getView());
    }

    /** Swap the center content; used by the main menu and each game's scene. */
    public void setCenter(Node node) {
        root.setCenter(node);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private void setToolbarVisible(boolean visible) {
        root.setTop(visible ? toolbar : null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
