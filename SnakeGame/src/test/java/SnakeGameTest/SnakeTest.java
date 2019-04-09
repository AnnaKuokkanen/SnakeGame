
package SnakeGameTest;

import com.mycompany.snakegame.Snake;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SnakeTest {
    
    private Snake snake;
    
    @Before
    public void setUp() {
        this.snake = new Snake(1,1);
    }
    
    @Test
    public void isConstructorhRight() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(list, snake.getX());
        assertEquals(list, snake.getY());
        assertEquals(1,snake.getLength());
    }
    
    @Test
    public void isSnakeGrowing() {
        snake.grow();
        assertEquals(2,snake.getLength());
    }
    
    @Test
    public void isSnakeMovingUp() {
        
    }
    
    @Test
    public void isSnakeMovingDown() {
    
    }
    
    @Test 
    public void isSnakeMovingLeft() {
    
    }
    
    @Test
    public void isSnakeMovingRight() {
    
    }
    
    @Test
    public void isCollisionRight() {
    
    }
    
    @Test
    public void areHeadCoordinatesRight() {
        int[][] coordinates = snake.getHeadCoordinates();
        assertEquals(1,coordinates[0][0]);
        assertEquals(1,coordinates[1][0]);
    }

}
