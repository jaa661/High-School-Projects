/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolutionarywargame;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Infantry extends Character{
   String attackDirectionString = attackDirection +"";
   Image characterImage = new ImageIcon("Infantry.png").getImage();
   int Cost = 50;
   int Width = 125;
   int Height = 100;
   
       
       public Infantry(){
         initThread();
         moveRight = true;
        setRange(30);
        setSlowness(50);
        setMaxCD(30);
        setDamage(-15);
        setHealth(45);  

           
       }
//========================================================================
     /*  
       public void run(){
         while (x<1300){
             
             x++;
             
             try {
                    Thread.sleep(10);
                  } catch (InterruptedException ex) {
                    Logger.getLogger(Cavalry.class.getName()).log(Level.SEVERE, null, ex);
                  }
         }
       }//end run*/
//=========================================================================
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
                   String attackDirectionString = attackDirection +"";
                characterImage = new ImageIcon("Infantry"+ attackDirectionString +".png").getImage();  
                g.drawRect(x, y - Height - 15, getHealth(), 10);
                g.setColor(Color.red);
                g.fillRect(x, y - Height - 14, getHealth(), 9);
		g.drawImage(characterImage, x ,y - Height ,null);
}

    	
	
        public void setDirection(String newDirection){
		attackDirectionString=newDirection;
	}
	public int getDirection(){
		return attackDirection;
	}
        public void setx(int newx){
		x=newx;
	}
	public int getx(){
		return x;
	}
        public void sety(int newy){
		y=newy;
	}
	public int gety(){
		return y;
	}
}
 