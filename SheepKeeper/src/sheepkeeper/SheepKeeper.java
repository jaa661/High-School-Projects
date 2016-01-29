/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheepkeeper;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.Random;

/**
 *
 * @author simon
 */
public class SheepKeeper extends JFrame implements KeyListener{

    /**
     * @param args the command line arguments
     */
    Image buffer;
    ArrayList<Sheep> sheeps;
    int score;
    int time;
    int sheepDelay;
    int sheepTimer;
    boolean isRunning;
    Image Backgroundimage = new ImageIcon("Background.png").getImage();
    
    public static void main(String[] args) {
        SheepKeeper f = new SheepKeeper();
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setVisible(true);
        f.setSize(600, 1000);
        f.setTitle("SheepKeeper");
        f.init();       
    }
    
    public void init(){
       setFocusable(true);
       requestFocusInWindow(); 
       addKeyListener(this);
       score=0;
       time=0;
       sheepDelay=300;
       sheepTimer=300;
       sheeps = new ArrayList<Sheep>();
       sheeps.add(new Sheep());
       isRunning=true;
    }
    
    public void paint(Graphics g){
        buffer=new BufferedImage(600,1000,BufferedImage.TYPE_INT_RGB);
        Graphics bufferG=buffer.getGraphics();
        bufferG.setColor(Color.RED);
        bufferG.fillRect(0,0,600,1000);
            
        if(isRunning){
            bufferG.setColor(Color.RED);
            bufferG.fillRect(274,0,3,1000);
            bufferG.fillRect(324,0,3,1000);
            bufferG.drawImage(Backgroundimage, 0, 0, null);
            bufferG.drawString("Score: "+score, 100, 100);

            for(int i=0;i<sheeps.size();i++){
                sheeps.get(i).update(bufferG);
                if(sheeps.get(i).hasPassedHitZone)
                    endGame();
                else if(sheeps.get(i).removed){
                    sheeps.remove(i);
                    i-=1;
                }
            }
            time++;
            newSheep();
        }
        else{
            bufferG.setColor(Color.BLACK);
            bufferG.drawString("You Lost \n   Score: "+score, 275, 280);
        }
        
        g=this.getGraphics();
        g.drawImage(buffer, 0,0, 600,1000, 0,0, 600,1000, this);
        repaint();
        for(int i=Integer.MIN_VALUE;i>=Integer.MAX_VALUE;i++)
            i=i;
    }
    
    public void newSheep(){
        System.out.println("newSheep: sheepTimer: "+sheepTimer+" sheepDelay: "+sheepDelay+" time: "+time);
        sheepTimer--;
        if(sheepTimer==0){
            sheeps.add(new Sheep());
            sheepTimer=sheepDelay;
            if(sheepDelay>25)
                sheepDelay= 200-5*(int)(Math.pow(time, .5)); 
        }
    }
    
    public void swipeUp(){
        if(isRunning){
            for(Sheep s:sheeps)
                if(s.isInHitPos){
                    if(s.isWhiteSheep){
                        s.removeSelf();
                        score++;
                    }
                    else endGame();
                }
        }
    }

    public void swipeDown(){
        if(isRunning){
            for(Sheep s:sheeps)
                if(s.isInHitPos){
                    if(!s.isWhiteSheep){
                        s.removeSelf();
                        score++;
                    }
                    else endGame();
                }
        }
    }
    
    public void endGame(){
        isRunning=false;
    }
    
    public void newGame(){
        if(!isRunning)
            init();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                swipeUp();
                break;
            case KeyEvent.VK_DOWN:
                swipeDown();
                break;
            case KeyEvent.VK_A:
                newGame();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
