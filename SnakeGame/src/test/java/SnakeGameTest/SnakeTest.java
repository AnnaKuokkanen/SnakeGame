
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
    public void isLastremoved() {
        snake.grow();
        snake.removeLast();
        assertEquals(1,snake.getLength());
    }
    
    @Test
    public void isSnakeMovingUp() {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        x.add(1);
        y.add(0);
        snake.moveUp();
        assertEquals(x,snake.getX());
        assertEquals(y,snake.getY());
    }
    
    @Test
    public void isSnakeMovingDown() {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        x.add(1);
        y.add(2);
        snake.moveDown();
        assertEquals(x,snake.getX());
        assertEquals(y,snake.getY());
    }
    
    @Test 
    public void isSnakeMovingLeft() {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        x.add(0);
        y.add(1);
        snake.moveLeft();
        assertEquals(x,snake.getX());
        assertEquals(y,snake.getY());
    }
    
    @Test
    public void isSnakeMovingRight() {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        x.add(2);
        y.add(1);
        snake.moveRight();
        assertEquals(x,snake.getX());
        assertEquals(y,snake.getY());
    }
    
    @Test
    public void isCollisionWorking() {
        assertEquals(false, snake.collision());
        snake.grow();
        snake.grow();
        snake.grow();
        snake.grow();
        snake.moveDown();
        snake.moveRight();
        snake.moveUp();
        
        assertEquals(true, snake.collision());
    }
    
    @Test
    public void areHeadCoordinatesRight() {
        int[][] coordinates = snake.getHeadCoordinates();
        assertEquals(1,coordinates[0][0]);
        assertEquals(1,coordinates[1][0]);
    }

}
