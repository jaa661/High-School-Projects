/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolutionarywargame;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Attack {
    char dir='r';
    int slowness=800;
    int x=0;
    int y=0;
    int range=100;
    int damage=-1;
    boolean hasHit=false;
    ArrayList<Character> targets=new ArrayList<>();
    int count=0;
    
    public void draw(Graphics g){
        if(!hasHit && range>0){
            g.setColor(Color.black);
            g.drawRect(x + 50, y - 50, 4, 1);
        }
    }
    
    public void applyEffect(){
        if(dir=='l')
            x-= 5;
        else x+= 5;
        if(!hasHit && range>0){
            for(int i=0;i<targets.size();i++){
                if(targets.get(i).x+targets.get(i).xSize>=x && targets.get(i).x<=x+4 && targets.get(i).y+targets.get(i).ySize>=y && targets.get(i).y<=y+1 && !hasHit){
                    //Checks if character in AOE
                    targets.get(i).changeHealth(damage);
                    hasHit=true;  
                }
            }
        }
    }
    
    
  /*  Runnable r=new Runnable(){
        public void run(){
         while (true){
            
            if (dir=='l' && range>0 && !hasHit){
                  x-=1;
                  range--;
                  try {
                    Thread.sleep(slowness);
                  } catch (InterruptedException ex) {
                    Logger.getLogger(Attack.class.getName()).log(Level.SEVERE, null, ex);
                  }
            }        
             if (dir=='r' && range>0 && !hasHit){
                  x+=1;
                  range--;
                  try {
                    Thread.sleep(slowness);
                  } catch (InterruptedException ex) {
                    Logger.getLogger(Attack.class.getName()).log(Level.SEVERE, null, ex);
                  }    
            }
       }
      }
     };
      
      public void initThread(){
         new Thread(r).start();
        }*/
    
    public void setTargets(ArrayList<Character> t){
        targets=t;
    }
    public void setX(int newX){
        x=newX;
    }
    public void setY(int newY){
        y=newY;
    }
    public void setDamage(int newDamage){
        damage=newDamage;
    }
    public void setSlowness(int newSlow){
        slowness=newSlow;
    }
    public void setDirection(char newDir){
        dir=newDir;
    }
    public boolean hasHit(){
        return hasHit;
    }
}
