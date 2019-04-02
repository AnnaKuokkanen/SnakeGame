
package com.mycompany.snakegame;

import java.util.ArrayList;

public class Snake {
    
    private ArrayList<Integer> x;
    private ArrayList<Integer> y;
    private int length;
    private int head;
    
    public Snake(int i, int j) {
        
        this.length=1;
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        //variable head is a pointer to the index in which x and y of the ead are.
        this.head = 0;
    }
    
    public void moveRight() {
        //we are deleting one from the tail and adding one to the head. At the same time pointer must be moved 
        if(this.head==0) {
            this.x.remove(this.x.size()-1);
            this.x.add()
            this.head++;
        }
        else {
            this.x.remove()
        }
    }
    
    public void moveLeft() {
        if(this.head==0) {
             this.x.remove(this.x.size()-1);
             this.x.add()
             this.head++;
         }
         else {

         }
    }
    
    public void moveUp() {
        if(this.head==0) {
            this.x.remove(this.x.size()-1);
            this.x.add()
            this.head++;
        }
        else {
            
        }
    }
    
    public void moveDown() {
        if(this.head==0) {
            this.x.remove(this.x.size()-1);
            this.x.add()
            this.head++;
        }
        else {
            
        }
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
    
    public int getHead() {
        return this.head;
    }
    
    public int[][] getHeadCoordinates() {
        //returns head's coordinates.
        int i=this.x.get(this.head);
        int j=this.y.get(this.head);
        return new int[i][j];
    }
}
