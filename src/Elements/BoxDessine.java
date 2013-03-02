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
public class BoxDessine extends BoxdeBase{
  
public BoxDessine(PApplet p) {
    parent = p;
}
  
  public void storePoint(int mX, int mY){
      
      int newCoordX= mX-this.x;
      int newCoordY= mY-this.y;
      int coinX= newCoordX-3;
      int coinY= newCoordY-3;
      for (int i=0; i<5; i++){
          for (int j=0; j<5; j++){    
          coord[coinX+i][coinY+j] = 1;
          }
      }
  }

}
