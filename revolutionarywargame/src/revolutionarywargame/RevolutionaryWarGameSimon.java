/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolutionarywargame;

import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class RevolutionaryWarGameSimon extends JFrame{
    Image buffer;
    ArrayList<Character> c= new ArrayList<>();
    ArrayList<Attack> a= new ArrayList<>();
    
    public void initGame(){
        c.add(new Character());
        c.get(0).setX(100);
        c.get(0).setY(100);
        
        c.add(new Character());
        c.get(1).setX(199);
        c.get(1).setY(100);
        c.get(1).setTeam("Enemy");
        c.get(1).setDirections('l', 'r');
    }
    
    public void paint(Graphics g){
        buffer=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics bufferG=buffer.getGraphics();
        getAttackObjects();
        removeDeadChars();
        for(Character o:c){
            o.increment(c);
            o.draw(bufferG);
        }
        for(Attack o:a){
            o.applyEffect();
            o.draw(bufferG);
        }
            
        g.drawImage(buffer, 0, 0, this);
        repaint();
    }
    
    public void removeDeadChars(){
        for(Character o:c)
            if(o.getHealth()<=0)
                c.remove(o);
    }
    
    public void getAttackObjects(){
    for (int x=0;x<a.size();x++)
        a.remove(x);
    ArrayList<Attack> p=new ArrayList<>();
    for(int i=0;i<c.size();i++){           
            p= c.get(i).getAttacks();
            for (int x=0;x<p.size();x++)
                a.add(p.get(x));
        }

}
    
    public static void main(String[] args){
        RevolutionaryWarGameSimon f=new RevolutionaryWarGameSimon();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,400);
        f.setTitle("Revolutionary War Game");
        f.show();
        f.initGame();
    }
}
