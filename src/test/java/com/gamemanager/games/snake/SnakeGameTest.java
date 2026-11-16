package com.gamemanager.games.snake;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTest {
    
    @Test
    public void testNewGame(){
        SnakeGame game = new SnakeGame();

        assertEquals(3, game.getSnake().size());
        assertEquals(0, game.getScore());
        assertFalse(game.isOver());
    }
}
