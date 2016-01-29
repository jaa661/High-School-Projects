/*
 * To change frame license header, choose License Headers in Project Properties.
 * To change frame template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolutionarywargame;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Battle extends JFrame implements ActionListener, KeyListener{
   Image bufferTop1;
   Image bufferTop2;
   Image bufferAction;

   //Image cavalry = new ImageIcon("Cavalry.png").getImage();
   int difficulty = 100;
   Castle castle;
   Castle castle2;
   
   
   Color brown = new Color(139,119,101);

   ArrayList<Character> c= new ArrayList<>();
   ArrayList<Attack> a= new ArrayList<>();
   
   Image background = new ImageIcon("Background.jpg").getImage();  

   AI ai=new AI(difficulty);


   Button cavbut = new Button("Cavalry 250");
   Button shipbut = new Button("Navy 250");
   Button infbut = new Button("Infantry 250");
   Button artbut = new Button("Artillery 250");
   Button Dummybut = new Button();
   Font myfont = new Font("Serif",Font.BOLD,12);
   int money=0;
   int maxBuildCD=30; 
   int buildCD=0;
   int battleNum=0;
   RevolutionaryWarGame control;
   Graphics g;
   boolean survival=false;
   int kills=0;
   int maxKills=0;
   boolean hasEnded=false;
   boolean firstInit=true;

//=============================================================================
   public void init(int moneys, int newdifficulty, boolean gamemode, RevolutionaryWarGame r){
       hasEnded=false;
       survival=gamemode;
       control=r;
       kills=0;
       difficulty = newdifficulty;
       c= new ArrayList<>();
       a= new ArrayList<>();
       ai=new AI(difficulty);
       money=moneys;

       //System.out.println("BInit");
       
       setFocusable(true);
       requestFocusInWindow();
       this.setSize(1200,600);
       this.setTitle("Battle ON!");
       this.setVisible(true);
       this.setBackground(Color.blue);
       
       addKeyListener(this);
       
       if(firstInit)
        g=this.getGraphics();
       firstInit=false;
       
       castle=null;
       castle2=null;
       
       castle=new Castle();
       castle.setX(0); //castle 1
       castle.setY(178);
       
       castle2=new Castle();
       castle2.setX(1200-82); //castle 2
       castle2.setY(178);
       castle2.setDirections('l','r');
       castle2.setTeam("Enemy");

       //System.out.println("2");
       
       g.drawImage(background, 0,50, 1200,600, 0,50, 1200,600, null);
       
       g.setColor(brown);
       g.fillRect(0, 20, 1200, 30);
      
       g.setColor(Color.gray);
       g.fillRoundRect(150, 20, 100, 30, 20, 20);
       g.fillRoundRect(250, 20, 100, 30, 20, 20);
       g.fillRoundRect(350, 20, 100, 30, 20, 20);
       g.fillRoundRect(450, 20, 100, 30, 20, 20);
       g.setColor(Color.black);
       g.drawRoundRect(150, 20, 100, 30, 20, 20);
       g.drawRoundRect(250, 20, 100, 30, 20, 20);
       g.drawRoundRect(350, 20, 100, 30, 20, 20);
       g.drawRoundRect(450, 20, 100, 30, 20, 20);
       
       g.drawString("Infantry 50", 170, 40);
       g.drawString("Cavalry 100", 265, 40);
       g.drawString("Artillery 200", 365, 40);
       g.drawString("Navy 350", 470, 40);
       
       
       infbut.setSize(100,20);
       infbut.setLocation(150,5);
       add(infbut); //Infantry
       
       cavbut.setSize(100,20);
       cavbut.setLocation(250,5);
       add(cavbut); //Cavalry
       
       artbut.setSize(100,20);
       artbut.setLocation(350,5);
       add(artbut); //artillery
       
       shipbut.setSize(100,20);
       shipbut.setLocation(450,5);
       add(shipbut); //navy

       add(Dummybut); //navy
       
       
       cavbut.addActionListener(this);
       shipbut.addActionListener(this);
       infbut.addActionListener(this);
       artbut.addActionListener(this);
       
             
       ai.setDifficulty(difficulty);
       ai.initThread();
       
       c.add(castle);
       if(!survival)
           c.add(castle2);
       //System.out.println("Init");    
       
       repaint();
   }//end constructor
//=========================================================================   
   public void paint(Graphics k){
       if(!hasEnded ){
       if(money<(200*difficulty))
        money++;
       if (buildCD>0)
           buildCD--;
       c.addAll(ai.enemies);
       ai.clear();
       
       //Buffer Top
       
       bufferTop1=new BufferedImage(149,50,BufferedImage.TYPE_INT_RGB);
       Graphics bufferG=bufferTop1.getGraphics();
       
       bufferG.setColor(brown);
       bufferG.fillRect(0, 0, 149, 50);
       bufferG.setColor(Color.red);
       bufferG.fillRect(0,0,castle.getHealth()/5,50);
       bufferG.setFont(myfont);
       bufferG.drawString(castle.getHealth() + "/500", 100, 40);
       
// Buffer Top 2
       
       bufferTop2=new BufferedImage(630,50,BufferedImage.TYPE_INT_RGB);
       bufferG=bufferTop2.getGraphics();
       
       bufferG.setColor(brown);
       bufferG.fillRect(0, 0, 630, 50);
       if(!survival){
            bufferG.setColor(Color.red);
            bufferG.fillRect(1200-570-castle2.getHealth()/5,0,castle2.getHealth(),50);
            bufferG.setFont(myfont);
            bufferG.drawString(castle2.getHealth() + "/500", 1050-570, 40);
       }
       else{
           bufferG.setColor(Color.red);
           bufferG.setFont(myfont);
           bufferG.drawString("Kills: "+kills + "/"+maxKills, 200, 40);
       }
       bufferG.setColor(Color.yellow);
       bufferG.drawString("MONEY: "+money, 0, 40);
       
//Buffer Action
       
       bufferAction=new BufferedImage(1200,178,BufferedImage.TYPE_INT_RGB);
       bufferG=bufferAction.getGraphics();
       
       bufferG.drawImage(background, 0,0, 1200,178, 0,422, 1200,600, this);
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
       
//Draw
       g.drawImage(bufferTop1, 0, 0, this);
       g.drawImage(bufferTop2, 570,0,this);
       g.drawImage(bufferAction, 0,422, 1200,600, 0,0, 1200,178, this);

       repaint();
   }//end if
   }
   
       public void removeDeadChars(){
        for(int i=0;i<c.size();i++)
            if(c.get(i).getHealth()<=0){
                if(c.get(i).team.equals("Enemy"))
                    kills++;
                if((c.get(i)==castle2 && !survival) || (kills>=maxKills && survival)){
                    hasEnded=true;
                    cavbut.removeActionListener(this);
                    shipbut.removeActionListener(this);
                    infbut.removeActionListener(this);
                    artbut.removeActionListener(this);
                    for(int z=0;z<c.size();z++){
                        c.get(z).deleteObjs();
                        c.remove(z);
                    }
                    for(int z=0;z<a.size();z++)
                        a.remove(z);
                    ai.stopThread();
                    ai=null;
                    //System.gc();
                    control.win(); 
                }
                else if(c.get(i)==castle){
                    hasEnded=true;
                    cavbut.removeActionListener(this);
                    shipbut.removeActionListener(this);
                    infbut.removeActionListener(this);
                    artbut.removeActionListener(this);
                    for(int z=0;z<c.size();z++){
                        c.get(z).deleteObjs();
                        c.remove(z);
                    }
                    for(int z=0;z<a.size();z++)
                        a.remove(z);
                    //System.gc();
                    control.lose();
                }
                else c.remove(i);
            }
    }
    
    public void getAttackObjects(){
    for (int x=0;x<a.size();x++)
        a.remove(x);
    ArrayList<Attack> p =new ArrayList<>();
    for(int i=0;i<c.size();i++){           
            p = c.get(i).getAttacks();
            for (int x=0;x< p.size();x++)
                a.add(p.get(x));
        }
}
    
    public void setBattleNum(int bn){
        battleNum=bn;
    }
    
    public void setMaxKills(int mk){
        maxKills=mk;
    }
    
    /*public void resetGame(int moneys,int difficulty, boolean gamemode, RevolutionaryWarGame r){
        hasEnded=false;
        survival=gamemode;
        control=r;
        c.clear();
        a.clear();
        ai.clear();
        money=moneys;
        
        ai.setDifficulty(difficulty);
        ai.stopThread();
        ai.initThread();
        
        castle=new Castle();
        castle.setX(0); //castle 1
        castle.setY(178);
       
       
        if(!survival){
           castle2=new Castle();
           castle2.setX(1200-82); //castle 2
           castle2.setY(178);
           castle2.setDirections('l','r');
           castle2.setTeam("Enemy");
        }
       c.add(castle);
       if(!survival)
           c.add(castle2);
       System.out.println("Init");   
       
       g=this.getGraphics();
       
       repaint();
        
    }*/
   
   
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==infbut && money>=50){
            money-=150;
            c.add(new Infantry());
            repaint();
        } //end infbut
        
        else if(e.getSource()==cavbut && money>=100){
            money-=100;
            c.add(new Cavalry());
            repaint();
        } //end cavbut
        else if(e.getSource()==artbut && money>=200){
            money-=200;
            c.add(new Artillery());
            repaint();
        } //end artbut
        else if(e.getSource()==shipbut && money>=350){
            money-=350;
            c.add(new Navy());
            repaint();
        } //end shipbut
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
         switch (e.getKeyCode()){
            case KeyEvent.VK_T:
                //System.out.println(" IHATE SIMON");
                castle2.setHealth(0);
                if(survival)
                    c.add(castle2);
                removeDeadChars();
        }    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_T:
                castle2.setHealth(0);
                if(survival)
                    c.add(castle2);
                removeDeadChars();
        }
    }
}//end battle
