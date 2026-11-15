package com.gamemanager.games.snake;

import com.gamemanager.App;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class SnakeScene {

    private static final int CELL_SIZE = 25;

    private final BorderPane view = new BorderPane();
    private final SnakeGame game;

    private final Canvas canvas = new Canvas(
        SnakeGame.GRID_SIZE * CELL_SIZE,
        SnakeGame.GRID_SIZE * CELL_SIZE
    );

    private final Label status = new Label("Use arrow keys to move");
    private final Label gameOverLabel = new Label("Game Over!");
    private final Timeline timeline;

    // Constructor
    public SnakeScene(App app, SnakeGame game) {
        this.game = game;

        // StackPane allows text to appear over the game board
        StackPane gameBoard = new StackPane();

        gameBoard.getChildren().addAll(canvas, gameOverLabel);
        gameOverLabel.setVisible(false);

        view.setCenter(gameBoard);
        view.setBottom(status);

        // Allow keyboard input
        view.setFocusTraversable(true);

        view.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> game.changeDirection(SnakeGame.Direction.UP);
                case DOWN -> game.changeDirection(SnakeGame.Direction.DOWN);
                case LEFT -> game.changeDirection(SnakeGame.Direction.LEFT);
                case RIGHT -> game.changeDirection(SnakeGame.Direction.RIGHT);
                default -> {}
            }
        });

        // Move the snake every 200 milliseconds
        timeline = new Timeline(
            new KeyFrame(Duration.millis(200), event -> {
                game.move();
                draw();

                if (game.isOver()) {
                    gameOverLabel.setVisible(true);
                    status.setText("Game Over!");
                }
            })
        );
        //keeps updating until gameover
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Start when the Snake view is displayed and stops when out of focus   
        view.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                Platform.runLater(() -> view.requestFocus());

                if (!game.isOver()) {
                    timeline.play();
                }
            } else {
                timeline.stop();
            }
        });

        draw();
    }

    // update every 200ms
    private void updateGame() {
        game.move();
        draw();

        if (game.isOver()) {
            timeline.stop();
            gameOverLabel.setVisible(true);
            status.setText("Game Over!");
        }
    }


    // Draw the game board and snake
    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        int boardSize = SnakeGame.GRID_SIZE * CELL_SIZE;

        // Draw background
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, boardSize, boardSize);

        // Draw the snake
        gc.setFill(Color.GREEN);

        for (SnakeGame.Position position : game.getSnake()) {
            gc.fillRect(
                position.x() * CELL_SIZE,
                position.y() * CELL_SIZE,
                CELL_SIZE - 1,
                CELL_SIZE - 1
            );
        }

        // Draw the border
        gc.setStroke(Color.GRAY);
        gc.strokeRect(0, 0, boardSize, boardSize);
    }

    public Node getView() {
        return view;
    }
}
