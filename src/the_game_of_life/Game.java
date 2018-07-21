
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game_of_life;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vzsoz
 */
public class Game {

    private Map gameMap;
    private Map tempGameMap;
    private ArrayList<Coordinates> kords;

    public Game() {
        this.kords = new ArrayList<Coordinates>();
        this.gameMap = new Map();
        this.tempGameMap = new Map();
        this.randCoordinates(40000);
        this.gameMap.setCells(this.kords);
        this.tempGameMap.setCells(this.kords);
    }
    
/**
 * Call liveOrDead method for each field of the gameMap
 * @return Map type object
 */
    public Map startOneRound() {

        for (int i = 0; i < this.gameMap.getWidth(); i++) {
            for (int j = 0; j < this.gameMap.getHeight(); j++) {
                this.liveOrDead(i, j);
            }
        }
        this.gameMap.copyMatrix(this.tempGameMap.getMatrix());
        
        return this.gameMap;
    }
/**
 * random x and y coordinates and push into an arrayList with type of Coordinates
 * @param int count the number of the coordinates
 */
    private void randCoordinates(int count){
        int randomx;
        int randomy; 
        for (int i = 0; i < count; i++) {
            randomx = (int )(Math.random() * (this.gameMap.getWidth()-1) + 0);
            randomy = (int )(Math.random() * (this.gameMap.getHeight()-1) + 0);
            this.kords.add(new Coordinates(randomx, randomy));
        }  
    }
    
    // count the existing Neighboors of a cell
    //@params int a kordinate, int b kordinate
    private int countNeighbour(int a, int b) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (((a + i) >= 0 && (b + j) >= 0) && ((a + i) < this.gameMap.getWidth() && this.gameMap.getHeight() > (b + j))) {
                    if (this.gameMap.getMatrix()[a + i][b + j].getExists() && (i != 0 || j != 0)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    /**
     * set a cells exists value depending on the number of the neigbour
     * @param int a coordinate 
     * @param int b coordinate
     */
    private void liveOrDead(int a, int b) {

        int count = this.countNeighbour(a, b);
        if (this.gameMap.getMatrix()[a][b].getExists()) {
            if (count != 2 && count != 3) {
                this.tempGameMap.getMatrix()[a][b].setExists(false);
            }
        } else {
            if (count == 3) {
                this.tempGameMap.getMatrix()[a][b].setExists(true);
            }
        }
    }

}
