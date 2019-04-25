package SnakeGameTest;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import snakegamelogic.Score;

public class ScoreTest {
    
    private Score score;
    
    @Before
    public void setUp() {
        this.score = new Score();
    }

    @Test
    public void isConstructorRight() {
        assertEquals(0,score.getScore());
    }
    
    @Test
    public void isScoreGrowing() {
        score.addScore();
        assertEquals(1,score.getScore());
    }
}
