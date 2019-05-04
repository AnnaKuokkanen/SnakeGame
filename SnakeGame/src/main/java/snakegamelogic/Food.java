
package snakegamelogic;

/**
 Class contains methods for logic behind shapes representing food in this game
 */
public class Food {
    
    private int x;
    private int y;
    
    public Food(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     Resets food bit's coordinates.
     */
    public void move(int i, int j) {
        setX(i);
        setY(j);
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setX(int i) {
        this.x = i;
    }
    
    public void setY(int j) {
        this.y = j;
    }
}
