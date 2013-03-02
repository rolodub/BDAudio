/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDVue;

import Audio.AudioShapeGenerator;
import Elements.BoxDessine;
import Elements.Button;
import Elements.ButtonCarre;
import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;
/**
 *
 * @author rolandduboue
 */
public class VueDrag extends PApplet{
    
int ECRAN_LARG = 800;
int ECRAN_HAUT = 600;

int x_cible=10;
int y_cible=10;
int larg_cible=300;
int haut_cible=300;

int OUT=0;
int OVER=1; 
int DRAG=2;

int taille_icone = 20;

boolean isBoxIn;


//Icone movable;
BoxDessine cible;
Button stopButton;
Minim minim;
AudioOutput out;
AudioShapeGenerator dessinAudio;

     @Override
    public void setup() {
  size(ECRAN_LARG, ECRAN_HAUT);
  cible = new BoxDessine(this);
  cible.init(x_cible, y_cible, larg_cible, haut_cible);
  stopButton = new ButtonCarre(this);
  stopButton.init(400, 150, 12, 12);
  isBoxIn=false;
  //noLoop();
  minim = new Minim(this);
  out = minim.getLineOut(Minim.MONO);
  dessinAudio = new AudioShapeGenerator(this);

  
}

    @Override
    public void draw(){
  //Dessine les elements de l'appli
  //Peint le fond de la fenetre
  background(255); 
  
  //Dessine les boites
  noFill();
  cible.dessine();
  stopButton.update();
  stopButton.display();

}

    @Override
    public void mouseMoved(){
        
}

//Si on clique et le curseur est sur l'icone, l'icone entre dans l'etat DRAG
    @Override
    public void mousePressed(){
        if(stopButton.isOver()){
          background(128);
//          dessinAudio.init(cible.getCoord(),2,out.sampleRate());
          dessinAudio.initInternal(out.sampleRate());
          out.addSignal(dessinAudio);
        }
        redraw();
}

//Lorsqu'on lache le bouton, DRAG n'est plus vrai, voir quel est le nouvel etat
    @Override
    public void mouseReleased(){
 
}

//Incremente la position de l'icone si l'icone est dans l'etat DRAG
    @Override
    public void mouseDragged(){
  
     if(A_dans_B(mouseX,mouseY,cible.getX(),cible.getY(),cible.getLarg(),cible.getHaut())){
         isBoxIn=true;
          cible.storePoint(mouseX,mouseY);
     }
      else{
      isBoxIn=false;

    }
    
    redraw();

}
    
    //Retourne TRUE si le point "A" se trouve dans le rectable "B"
//On l'utilise pour detecter si le curseur se trouve sur l'icone...
//... mais aussi pour voir si l'icone se trouve dans la grande boite
boolean A_dans_B(int x_A, int y_A, int x_B, int y_B, int l_B, int h_B){
  if( (x_A>x_B && x_A<(x_B+l_B)) && (y_A>y_B && y_A<(y_B+h_B)) ){
    return true;
  }
  else {
    return false;
  }
}
        public static void main(String args[]) {
    PApplet.main(new String[] { "--present", "BDVue.VueDrag" });
  }
}
