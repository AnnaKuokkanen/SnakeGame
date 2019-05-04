
package snakegamelogictest;

import snakegamelogic.Food;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FoodTest {

    private Food food;
    
    @Before
    public void setUp() {
        this.food = new Food(1,1);
    }
    
    @Test
    public void isConstructorWorking() {
        assertEquals(1, food.getX());
        assertEquals(1,food.getY());
    }
    
    @Test
    public void isFoodMoving() {
        food.move(2,3);
        assertEquals(2, food.getX());
        assertEquals(3, food.getY());
    }
}
