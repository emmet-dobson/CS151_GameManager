package com.gamemanager.games.snake;

import com.gamemanager.games.AbstractGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Snake rules and state. No JavaFX here. TODO: grid, movement, food, collisions. */
public class SnakeGame extends AbstractGame {

    public static final int GRID_SIZE = 20;

    public record Position (int x, int y){}

    public enum Direction{
        UP, DOWN, LEFT, RIGHT
    }

    private final ArrayList<Position> snake = new ArrayList<>();
    private Direction direction;
    private boolean gameOver;

    public SnakeGame() {
        super("Snake");
        reset();
    }

    @Override
    public void reset() {
        snake.clear();

        int x = GRID_SIZE / 2;
        int y = GRID_SIZE / 2;

        Direction[] directions = Direction.values();
        direction = directions[new Random().nextInt(directions.length)];

        snake.add(new Position(x, y));

        switch(direction){
            case UP -> {
                snake.add(new Position(x, y + 1));
                snake.add(new Position(x, y + 2));
            }
            case DOWN -> {
                snake.add(new Position(x, y -1));
                snake.add(new Position(x, y -2));
            }
            case LEFT -> {
                snake.add(new Position(x + 1, y));
                snake.add(new Position(x + 2, y));
            }
            case RIGHT -> {
                snake.add(new Position(x - 1, y));
                snake.add(new Position(x - 2, y));
            }
        }

    gameOver = false;
    setScore(0);

    }

    public void changeDirection(Direction newDirection){
        if(newDirection == null || gameOver){
            return;
        }

        if(direction == Direction.UP && newDirection == Direction.DOWN ||
            direction == Direction.DOWN && newDirection == Direction.UP || 
            direction == Direction.LEFT && newDirection == Direction.RIGHT || 
            direction == Direction.RIGHT && newDirection == Direction.LEFT) {
                return;
            }

            direction = newDirection;
            }

            public void move(){
                if(gameOver){
                    return;
                }
                
                Position head = snake.get(0);
                int x = head.x();
                int y = head.y();

                switch(direction){
                    case UP -> y--;
                    case DOWN -> y++;
                    case LEFT -> x--;
                    case RIGHT -> x++;
                }
                //snake hits wall
                if(x < 0 || x >= GRID_SIZE || y < 0 || y >= GRID_SIZE){
                    gameOver = true;
                    return;
                }
                Position newHead = new Position(x, y);

                for(int i = 0; i < snake.size() - 1; i++){
                    if(snake.get(i).equals(newHead)){
                        gameOver = true;
                        return;
                    }
                }

                /// Remove the tail and add the new head
                snake.remove(snake.size() - 1);
                snake.add(0, newHead);
            }

            public List<Position> getSnake(){
                return new ArrayList<>(snake);
            }

            public Direction getDirection(){
                return direction;
            }

      @Override
    public boolean isOver() {
        return gameOver;
    }
}
