
package com.mycompany.snakegame;

public class Snake {
    
    private int[] x;
    private int[] y;
    private int length;
    
    public Snake() {
        this.length=1;
        this.x = new int[this.length];
        this.y = new int[this.length];
    }
    
    public void moveRight() {
        for(int i=0; i<this.x.length; i++) {
            this.x[i]++;
        }
    }
    
    public void moveLeft() {
        
    }
    
    public void moveUp() {
        
    }
    
    public void moveDown() {
        
    }
    
    public void grow() {
        this.length++;
        
    }
    
    public boolean collision() {
        
    }
    
    public int[] getX() {
        return this.x;
    }
    
    public int[] getY() {
        return this.y;
    }
    
    public int getLength() {
        return this.length;
    }
}
