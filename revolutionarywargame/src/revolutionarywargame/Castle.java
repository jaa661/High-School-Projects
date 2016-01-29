/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolutionarywargame;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Castle extends Character{
   String attackDirectionString = attackDirection +"";
   Image characterImage = new ImageIcon("Infantry.png").getImage();
   int Cost = 0;
   int Width = 82;
   int Height = 176;

    public Castle(){
        setRange(0);
        setSlowness(0);
        setMaxCD(0);
        setDamage(0);
        setHealth(500);    
    }
    
    
    public void draw(Graphics g){
		g.setColor(Color.BLACK);
                   String attackDirectionString = attackDirection +"";
                characterImage = new ImageIcon("Castle"+ attackDirectionString +".png").getImage();  

		g.drawImage(characterImage, x ,y - Height ,null);
        }
    public void attack(){
    }
    public void run(){        
    }
}
