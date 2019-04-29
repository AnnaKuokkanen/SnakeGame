
package snakegamelogic;

import gui.SnakeGraphics;
import gui.FirstView;

public class Highscore {
    
    private String name;
    private int score;
    
    public Highscore(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return this.name;
    }
    public int getScore() {
        return this.score;
    }
    public void setScore(int s) {
        this.score = s;
    }
}
