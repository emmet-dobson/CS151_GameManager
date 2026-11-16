package com.gamemanager.games.snake;

import com.gamemanager.games.AbstractGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Snake rules and state. No JavaFX here. TODO: grid, movement, food, collisions. */
public class SnakeGame extends AbstractGame {

    public static final int GRID_SIZE = 25;

    public record Position (int x, int y){}

    public enum Direction{
        UP, DOWN, LEFT, RIGHT
    }

    private final ArrayList<Position> snake = new ArrayList<>();
    private Direction direction;
    private Direction nextDirection;
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

        nextDirection = direction;

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
    spawnFood();

    }

    public void changeDirection(Direction newDirection){
        if(newDirection == null || gameOver || nextDirection != direction){
            return;
        }

        if(direction == Direction.UP && newDirection == Direction.DOWN ||
            direction == Direction.DOWN && newDirection == Direction.UP || 
            direction == Direction.LEFT && newDirection == Direction.RIGHT || 
            direction == Direction.RIGHT && newDirection == Direction.LEFT) {
                return;
            }

            nextDirection = newDirection;
            }

            public void move(){
                if(gameOver){
                    return;
                }
                
                direction = nextDirection;
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

                boolean eating = newHead.equals(food);

                int segmentsToCheck;
                
                if(eating){
                    segmentsToCheck = snake.size();
                } else {
                    segmentsToCheck = snake.size() - 1;
                }

                for(int i = 0; i < segmentsToCheck; i++){
                    if(snake.get(i).equals(newHead)){
                        gameOver = true;
                        return;
                    }
                }

                /// Remove the tail and add the new head
                snake.add(0, newHead);
                if(eating){
                    setScore(getScore() + 100);
                    spawnFood();
                } else {
                    snake.remove(snake.size() - 1);
                }
            }

            private Position food;
            private final Random random = new Random();

            //spawns food in random location where snake is not
            private void spawnFood(){
                if(snake.size() == GRID_SIZE * GRID_SIZE){
                    food = null;
                    gameOver = true;
                    return;
                }
                Position newFood;

                do{
                    int x = random.nextInt(GRID_SIZE);
                    int y = random.nextInt(GRID_SIZE);

                    newFood = new Position(x,y);
                } while(snake.contains(newFood));
                food = newFood;
            }

            public List<Position> getSnake(){
                return new ArrayList<>(snake);
            }

            public Direction getDirection(){
                return direction;
            }

            public Position getFood(){
                return food;
            }

      @Override
    public boolean isOver() {
        return gameOver;
    }
}
