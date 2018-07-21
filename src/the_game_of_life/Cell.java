/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game_of_life;

/**
 *
 * @author vzsoz
 * 
 * Represents one cell which can exsist or not 
 */
public class Cell {
    private Boolean exists;

    public Cell() {
        this.exists = false;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }
      
}
