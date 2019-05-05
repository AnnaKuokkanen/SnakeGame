
package snakegamelogictest;

import snakegamelogic.Snake;
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
    public void isConstructorRight() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(list, snake.getX());
        assertEquals(list, snake.getY());
        assertEquals(1,snake.getLength());
    }
    
    @Test
    public void isSnakeGrowing() {
        snake.grow();
        assertEquals(2, snake.getLength());
        assertEquals(1, (int) snake.getX().get(0));
        assertEquals(1, (int) snake.getY().get(0));
        assertEquals(2, (int) snake.getX().get(snake.getX().size() - 1));
    }
    
    @Test
    public void isLastRemoved() {
        snake.removeLast();
        assertEquals(0,snake.getLength());
        assertEquals(true, snake.getX().isEmpty());
        assertEquals(true, snake.getY().isEmpty());
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
        assertEquals(1, snake.getLength());
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
        assertEquals(1, snake.getLength());
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
        assertEquals(1, snake.getLength());
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
        assertEquals(1, snake.getLength());
    }
    
    @Test
    public void rigthLength() {
        assertEquals(1, snake.getLength());
    }

}
