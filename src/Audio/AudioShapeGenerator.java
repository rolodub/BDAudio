/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Audio;

import ddf.minim.AudioSignal;
import processing.core.PApplet;
/**
 *
 * @author rolandduboue
 */

public class AudioShapeGenerator implements AudioSignal{
    PApplet parent;
    float[] frequency;
    float amplitude = (float) 0.33;
    int timer = 0;
    int sampleRate;
    float amp;
    int[][] ampliGraph =  {{0,0,0,1,0,0},
                        {0,0,0,1,0,0},
                        {0,0,1,1,0,0},
                        {0,0,1,1,1,0},
                        {0,1,1,1,1,1},
                        {1,1,1,1,1,1}};

   private float echNum=0;
   private int tempo=0;
   int[][] ampliFreq;
 //  private int nbBandes=6;
//private int[][] ampliGraph;

  
    public void initInternal(float sr){

      //tableau des bandes de freq en fonction des pixels horizontaux
      ampliFreq=new int[ampliGraph.length][ampliGraph[0].length];
      for (int c=0;c<ampliGraph.length;c++){
            System.arraycopy(ampliGraph[c], 0, ampliFreq[c], 0, ampliGraph[0].length);
          
      }
      sampleRate = (int) sr;
//    int numBand=0;
      frequency = new float[ampliGraph[0].length];
      for(int i=0;i<frequency.length;i++){
        frequency[i] = 200*3*i+1;//freq/seconde
        frequency[i] /= sr;//fréquence par échantillon
     }
  }
   
  public void init(int[][] ampliGraph, int tempo, float sr){
      
      this.ampliGraph=ampliGraph;
      //tableau des bandes de freq en fonction des pixels horizontaux
      ampliFreq=new int[ampliGraph.length][ampliGraph[0].length];
      sampleRate = (int) sr;
//    int numBand=0;
    frequency = new float[ampliGraph[0].length];
     for(int i=0;i<frequency.length;i++){
        frequency[i] = 200*3*i+1;//freq/seconde
        frequency[i] /= sr;//fréquence par échantillon
     }
//        int sommeAmp=0;
//        int pixPerBand=ampliGraph[0].length/nbBandes;
//        for(int col=0; col<ampliGraph.length;col++){
//           for(int nbb=0;nbb<nbBandes;nbb++){
//                for(int j=0;j<pixPerBand;j++){
//                sommeAmp+=ampliGraph[col][j+numBand];
//                } 
//                ampliFreq[col][nbb]=sommeAmp/pixPerBand;
//                numBand+=pixPerBand;
//            }   
//        } 
     
  }

    public AudioShapeGenerator(PApplet parent) {
        this.parent = parent;
    }
    @Override
  public void generate(float[] samp){
    for(int i=0;i<samp.length;i++){
      samp[i] = getSample();
    }
  }
    @Override
  public void generate(float[] left,float[] right){
   
    for(int i=0;i<left.length;i++){

      left[i] = getSample();
      right[i] = getSample();
    }
  }

    private float getSample() {

        float testAmplitude;
            for(int f=0; f<frequency.length;f++){
                
                amp += amplitude *(ampliFreq[tempo][f])/15*PApplet.sin(PApplet.TWO_PI*echNum*frequency[f]);

            }
//            amp += amplitude *PApplet.sin(PApplet.TWO_PI*echNum*frequency[2]);
            echNum++;        
            if (echNum==sampleRate){
                echNum=0;
                if (tempo==ampliFreq.length-1){
                   tempo=0; 
                }
                else{
                tempo++;
                }
                System.out.println(tempo);
            }
            
            return amp;
            }  
    }
