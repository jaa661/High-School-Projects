/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolutionarywargame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class AI{
   Image characterImage = new ImageIcon("Infantry.png").getImage();
   int Cost = 50;
   int Width = 125;
   int Height = 100;
   ArrayList<Character> enemies= new ArrayList<>();
   Random generator = new Random();
   int difficulty = 0;
   int check = 0;
   boolean runThread=true;
       public AI(int newDifficulty){
       difficulty = newDifficulty;

           
       }
//========================================================================
 Runnable r=new Runnable(){
        public void run(){
         while (runThread){
             if(difficulty !=0){
            check = generator.nextInt(25 + (5*(difficulty + 1)) +(5*difficulty) + (2*(difficulty + 1)));
             if(check < 25){
                enemies.add(new Infantry());
                enemies.get(enemies.size()-1).setTeam("Enemy");
                enemies.get(enemies.size()-1).setX(1200-83);
                enemies.get(enemies.size()-1).setDirections('l','r');
                enemies.get(enemies.size()-1).setAttack(true);
                enemies.get(enemies.size()-1).initThread();
                }
            if(check >= 25 && check < 25 + (5*(difficulty + 1))){
                enemies.add(new Cavalry());
                enemies.get(enemies.size()-1).setTeam("Enemy");
                enemies.get(enemies.size()-1).setDirections('l','r');
                enemies.get(enemies.size()-1).setAttack(true);
                enemies.get(enemies.size()-1).setX(1200-83);
                enemies.get(enemies.size()-1).initThread();
                 }
            if(check >= 25+ (5*(difficulty + 1)) && check < 25 + (5*(difficulty + 1)) +(5*difficulty)){
                enemies.add(new Artillery());
                enemies.get(enemies.size()-1).setTeam("Enemy");
                enemies.get(enemies.size()-1).setDirections('l','r');
                enemies.get(enemies.size()-1).setAttack(true);
                enemies.get(enemies.size()-1).setX(1200-83);
                enemies.get(enemies.size()-1).initThread();
                 }
            if(check >= 25 + (5*(difficulty + 1)) +(5*difficulty)){  
                enemies.add(new Navy());
                enemies.get(enemies.size()-1).setTeam("Enemy");
                enemies.get(enemies.size()-1).setX(1200-83);
                enemies.get(enemies.size()-1).setDirections('l','r');
                enemies.get(enemies.size()-1).setAttack(true);
                enemies.get(enemies.size()-1).initThread();
                }
            try {
                Thread.sleep(70000/((int)Math.pow(difficulty, 1.5)));
                } catch (InterruptedException ex) {
                Logger.getLogger(Character.class.getName()).log(Level.SEVERE, null, ex);
                } 
             }
            }//end while
       }//end run
 };
      
    
      
      public void initThread(){
          runThread=true;
          new Thread(r).start();
        }
      public void stopThread(){
         runThread=false;
        }
//=========================================================================
	
     public void setDifficulty(int newdifficulty){
         difficulty = newdifficulty;
     }
     
     public void clear(){
         enemies.clear();
     }
      
}
 