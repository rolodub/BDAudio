/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

/**
 *
 * @author rolandduboue
 */
public interface Button {
    
  public void init(int x, int y,  int width, int height);
  public void update();
  public void overEvent();
  public void pressEvent();
  public void releaseEvent();
  public void display();
  public boolean isOver();

}
//