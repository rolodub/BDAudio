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
public class ButtonCarre implements Button{

  PApplet parent;
  int boxx, boxy;
  int size;

  boolean press;
  boolean locked;
  boolean over;

    public ButtonCarre(PApplet parent) {
        this.parent = parent;
    }

    @Override
    public void update() {
        overEvent();
        pressEvent();
    }

    @Override
    public void overEvent() {
      if(overRect(boxx, boxy, size, size)) {
        over = true;
      } else {
        over = false;
      }
    }


    @Override
    public void pressEvent() {
       if(over && parent.mousePressed || locked) {
        press = true;
        locked = true;
      } else {
        press = false;
      }
    }
    

    @Override
    public void init(int x, int y,  int width, int height) {
    this.boxx = x;
    this.boxy = y;
    this.size = width;
    
    }

    @Override
    public void releaseEvent() {
        locked = false;
    }

    @Override
    public void display() {
      parent.fill(255);
      parent.stroke(0);
      parent.rect(boxx, boxy, size, size);
      if(over || press) {
        parent.line(boxx, boxy, boxx+size, boxy+size);
        parent.line(boxx, boxy+size, boxx+size, boxy);
      }
    }

    boolean overRect(int x, int y, int width, int height) {
  if (parent.mouseX >= x && parent.mouseX <= x+width && 
      parent.mouseY >= y && parent.mouseY <= y+height) {
    return true;
  } else {
    return false;
  }
}

    @Override
    public boolean isOver() {
        return over;
    }
}
