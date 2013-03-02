/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import processing.core.PApplet;

/**
 *
 * @author rolandduboue
 */
public class BoxdeBase {
    int[][] coord;
    int haut;
    int larg;
    PApplet parent;
    int x;
    int y;

    public int getHaut() {
        return haut;
    }

    public void setHaut(int haut) {
        this.haut = haut;
    }

    public int getLarg() {
        return larg;
    }

    public void setLarg(int larg) {
        this.larg = larg;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BoxdeBase() {
    }

    public void dessine() {
        parent.rect(x, y, larg, haut);
        for (int i = 0; i < larg; i++) {
            for (int j = 0; j < haut; j++) {
                if (coord[i][j] == 1) {
                    float pointX = i + this.x;
                    float pointY = j + this.y;
                    parent.point(pointX, pointY);
                }
            }
        }
    }

    //
    public int[][] getCoord() {
        return coord;
    }
        
    public void setCoord(int[][] coord) {
        this.coord = coord;
    }

    public void init(int x, int y, int larg, int haut) {
        this.x = x;
        this.y = y;
        this.larg = larg;
        this.haut = haut;
        coord = new int[larg][haut];
        for (int i = 0; i < larg; i++) {
            for (int j = 0; j < haut; j++) {
                coord[i][j] = 0;
            }
        }
    }
    
}
