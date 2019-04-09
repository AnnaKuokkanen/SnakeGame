
package SnakeGameLogic;

public class Food {
    
    private int x;
    private int y;
    
    public Food(int x, int y) {
        this.x=x;
        this.y=y;
    }
    
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
        this.x=i;
    }
    
    public void setY(int j) {
        this.y=j;
    }
}
