
package snakegamelogic;
/**
 * Class keeps track of scores during game
 */
public class Score {
    
    private int score;
    
    public Score() {
        this.score = 0;
    } 
    
    public int getScore() {
        return this.score;
    }
    /**
     * Grows score
     */
    public void addScore() {
        this.score++;
    }
}
