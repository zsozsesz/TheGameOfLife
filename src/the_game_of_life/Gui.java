/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game_of_life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vzsoz
 */
public class Gui extends JFrame {

    private Game g;
    private Map map;
    private static final int push = 35;
    private int input;

    public Gui() {
        this.input = 100;
        this.showInputDialog();
        setVisible(true);
        setTitle("The Game Of Life");
        setPreferredSize(new Dimension(400, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        g = new Game();
        this.map = g.startOneRound();
    }
    /**
     * open an input dialog box 
     * check the format of the input
     * @return true if format is correct false if not
     */
    private Boolean showInputDialog() {
        String input = JOptionPane.showInputDialog("Please add the number of the rounds (Default: 100): ");
        try {
           this.input = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
    /**
     * call the startOneRound method
     * Set the frame pixels to black if cell exist white if not
     * @param Graphics g 
     */
    private void rePaint(Graphics g) {
        this.map = this.g.startOneRound();
        for (int i = 0; i < this.map.getWidth(); i++) {
            for (int j = 0; j < this.map.getHeight(); j++) {
                if (this.map.getMatrix()[i][j].getExists()) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.drawLine(i + this.push, j + this.push, i + this.push, j + this.push);
            }
        }
    }
    /**
     * call the rePaint method  
     * sleep 500ms in each iteration
     */
    public void playNextRound() {
        for (int i = 0; i < this.input; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.rePaint(this.getGraphics());
        }
    }
}
