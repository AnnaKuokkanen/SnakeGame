
package snakegamelogic;

import java.util.ArrayList;

/**
 * Class contains methods that define logic behind character snake in the game
 */
public class Snake {
    private ArrayList<Integer> x;
    private ArrayList<Integer> y;
    private int length;
    
    public Snake(int i, int j) {
        this.length = 1;
        this.x = new ArrayList<>();
        this.x.add(i);
        this.y = new ArrayList<>();
        this.y.add(j);
    }
    /**
     * Method removes last bit of snakes bits
     */
    public void removeLast() {
        this.x.remove(this.x.size() - 1);
        this.y.remove(this.y.size() - 1);
        this.length--;
    }
    /**
     * Method sets new coordinates after snake has moved   
     */
    public void moveLeft() {
        int x = this.x.get(0);
        int y = this.y.get(0);
        removeLast();
        this.x.add(0 , x - 1);
        this.y.add(0 , y);
        this.length++;
    }
    /**
     * Method sets new coordinates after snake has moved   
     */
    public void moveRight() {
        int x = this.x.get(0);
        int y = this.y.get(0);
        removeLast();
        this.x.add(0, x + 1);
        this.y.add(0, y);
        this.length++;
    }
    /**
     * Method sets new coordinates after snake has moved   
     */
    public void moveUp() {
        int x = this.x.get(0);
        int y = this.y.get(0);
        removeLast();
        this.x.add(0, x);
        this.y.add(0, y - 1);
        this.length++;
    }
    /**
     * Method sets new coordinates after snake has moved   
     */
    public void moveDown() {
        int x = this.x.get(0);
        int y = this.y.get(0);
        removeLast();
        this.x.add(0, x);
        this.y.add(0, y + 1);
        this.length++;
    }
    /**
     * adds new bit to tail 
     */
    public void grow() {
        this.x.add(this.x.get(x.size() - 1) + 1);
        this.y.add(this.y.get(y.size() - 1));
        this.length++;
    }
        
    public ArrayList<Integer> getX() {
        return this.x;
    }
    
    public ArrayList<Integer> getY() {
        return this.y;
    }
    
    public int getLength() {
        return this.length;
    }
}
