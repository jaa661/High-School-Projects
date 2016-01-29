/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolutionarywargame;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Navy extends Character{
   String attackDirectionString = "r";
   Image characterImage = new ImageIcon("Navy.png").getImage();  
   int Cost = 350;
   int Width = 236;
   int Height = 150;
       
       public Navy(){
         initThread();
         moveRight = true;
        setRange(100);
        setSlowness(50);
        setMaxCD(60);
        setDamage(-25);
        setHealth(175);


           
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

                characterImage = new ImageIcon("Navy"+ attackDirectionString +".png").getImage();  
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
 