/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheepkeeper;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
/**
 *
 * @author simon
 */
public class Sheep extends Character{
    boolean isInHitPos=false;
    boolean isWhiteSheep=true;
    boolean hasPassedHitZone=false;
    boolean removing=false;
    boolean removed=false;
    int removeTime=0;
    Image whiteSheep = new ImageIcon("Sheep.png").getImage();
    Image blackSheep = new ImageIcon("BlackSheep.png").getImage();
    
    public Sheep(){
        xSize=117;
        isInHitPos=false;
        isWhiteSheep=true;
        y=400;
        
        Random r=new Random();
        if(r.nextInt(2)==0)
            isWhiteSheep=false;
    }
    
    public void update(Graphics g){
        //System.out.println("update, x: "+x+" y: "+y+" white: "+isWhiteSheep);
        move();
        checkHitPos();
        draw(g);
    }
    
    private void move(){
        if(!removing){
            x++;
            y= (int)(.01*(x-275)*(x-275))+50;
            
        }
        else{
            if(removeTime<=20){
                if(isWhiteSheep)
                    y--;
                else y++;
                removeTime++;
            }
            else removed=true;
        }
    }
    
    private void checkHitPos(){
        if(x+xSize>=275 && x-xSize/2<=325 && !removing)
            isInHitPos=true;
        else isInHitPos=false;
        if(x>=325)
            hasPassedHitZone=true;
    }
    
    private void draw(Graphics g){
        if(isWhiteSheep)
            g.drawImage(whiteSheep, (int)(x-xSize/2) ,y  ,null);
        
        else
            g.drawImage(blackSheep, (int)(x-xSize/2) ,y  ,null);
        
    }
    
    public void removeSelf(){
        removing=true;
    }
}
