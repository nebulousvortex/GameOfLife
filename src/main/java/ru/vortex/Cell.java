package main.java.ru.vortex;

import java.awt.*;

public class Cell {

    private int x, y;
    private boolean alive;
    private int countNeighbours = 0;
    Color color;

    private char value;
    public Cell(int x, int y, boolean alive){
        this.x = x;
        this.y = y;
        this.alive = alive;
        this.updateValue();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public char getValue(){
        return this.value;
    }

    public Color getColor() {
        return color;
    }

    public int getCountNeighbours() {
        return this.countNeighbours;
    }

    public void addNeighbours(){
        this.countNeighbours++;
    }

    public void nullifyNeighbours() {
        this.countNeighbours = 0;
    }

    /*
     * Calculate count of alive neighbours
     */
    public void setCountNeighbours(Cell[][] cells){
        for(int i=-1; i<2;i++){
            for(int j=-1; j<2;j++){
                if((j!=0)|(i!=0)){
                    try {
                        int newX = this.getX() + i;
                        int newY = this.getY() + j;
                        if(cells[newX][newY].getAlive()){
                            this.addNeighbours();
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored){
                    }
                }
            }
        }
    }

    /*
     * Update status of cells
     */
    public void killOrRevive(){
        if((this.getCountNeighbours()>3)|(this.getCountNeighbours()<2)){
            this.setAlive(false);
        }
        if(this.countNeighbours ==3) {
            this.setAlive(true);
        }
        this.updateValue();
    }

    /*
     * Update value of cells
     */
    public void updateValue(){
        if (this.alive){
            this.value = 'O';
            this.color = Color.RED;
        }
        else {
            this.value = '#';
            this.color = Color.lightGray;
        }
    }
}
