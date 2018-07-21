/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game_of_life;

import java.util.ArrayList;

/**
 *
 * @author vzsoz
 */
public class Map {

    private Cell[][] matrix;
    private int height;
    private int width;

    public Map() {
        this.height = 300;
        this.width = 300;
        this.matrix = new Cell[this.width][this.height];
        this.setMapToDefault();
    }

    // return the matrix
    public Cell[][] getMatrix() {
        return matrix;
    }

    // set each cells existing value to false in the matrix 
    public void setMapToDefault() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.matrix[i][j] = new Cell();
            }
        }
    }

    // set the specified cells to true
    //@param an arraylist of kordinates
    public void setCells(ArrayList<Coordinates> list) {
        for (Coordinates kord : list) {
            this.matrix[kord.getX()][kord.getY()].setExists(true);
        }
    }
    
    // copy the matrix value to the standard matrix
    //@param Cell[][] matrix
    public void copyMatrix(Cell[][] matrix) {
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                this.matrix[i][j].setExists(matrix[i][j].getExists());
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
