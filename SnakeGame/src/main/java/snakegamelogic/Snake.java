
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
        //we are deleting one from the tail and adding one to the head.
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
        //we're adding a new spot to the tail.
        this.x.add(this.x.get(x.size() - 1) + 1);
        this.y.add(this.y.get(y.size() - 1));
        this.length++;
    }
    /**
     * Checks if snake has collided with itself
     * @return boolean value
     */
    public boolean collision() {
        int[][] head = getHeadCoordinates();
        int x = head[0][0];
        int y = head[1][0];
        for (int i = 1; i < this.x.size(); i++) {
            if (x == this.x.get(i) && y == this.y.get(i)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Checks if snake has collided with some spot
     * @param x is for x-coordinate
     * @param y is for y-coordinate 
     * @return boolean value true if has collided
     */
    public boolean collision2(int x, int y) {
        //this can be used for checking food.
        int[][] head = getHeadCoordinates();
        int i = head[0][0];
        int j = head[1][0];
        if (x == i && y == j) {
            return true;
        }
        return false;
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
    /**
     * @return two-dimensional array containing snake's head coordinates
     */
    public int[][] getHeadCoordinates() {
        //returns head's coordinates.
        int i = this.x.get(0);
        int j = this.y.get(0);
        int[][] dot = new int[2][1];
        dot[0][0] = i;
        dot[1][0] = j;
        return dot;
    }
}
