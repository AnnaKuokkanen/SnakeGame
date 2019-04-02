
package com.mycompany.snakegame;

import java.util.ArrayList;

public class Snake {
    
    private ArrayList<Integer> x;
    private ArrayList<Integer> y;
    private int length;
    
    public Snake(int i, int j) {
        
        this.length=1;
        this.x = new ArrayList<>();
        this.x.add(i);
        this.y = new ArrayList<>();
        this.y.add(j);
    }
    
    public void removeLast() {
        this.x.remove(this.x.size()-1);
        this.y.remove(this.y.size()-1);
    }
    
    public void moveLeft() {
        //we are deleting one from the tail and adding one to the head.
        removeLast();
        int x=this.x.get(0);
        int y=this.y.get(0);
        this.x.add(0,x-1);
        this.y.add(0,y);
    }
    
    public void moveRight() {
        removeLast();
        int x=this.x.get(0);
        int y=this.y.get(0);
        this.x.add(0,x+1);
        this.y.add(0,y);
    }
    
    public void moveUp() {
        removeLast();
        int x=this.x.get(0);
        int y=this.y.get(0);
        this.x.add(0,x);
        this.y.add(0,y+1);
    }
    
    public void moveDown() {
        removeLast();
        int x=this.x.get(0);
        int y=this.y.get(0);
        this.x.add(0,x);
        this.y.add(0,y-1);
    }
    
    public void grow() {
        //we're adding a new spot to the tail.
        this.x.add(this.x.get(x.size()-1)+1);
        this.y.add(this.y.get(y.size()-1));
        this.length++;
    }
    
    public boolean collision() {
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
    
    public int[][] getHeadCoordinates() {
        //returns head's coordinates.
        int i=this.x.get(0);
        int j=this.y.get(0);
        return new int[i][j];
    }
}
