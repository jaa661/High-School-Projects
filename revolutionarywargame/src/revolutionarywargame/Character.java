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

public class Character {
	int slowness=200;
        boolean moveRight=true;
        boolean moveLeft=false;
        String lastMoveDir="left";
        int x=10;
        int y=178;
        int xSize=10;
        int ySize=10;
        int health=100;
        char attackDirection='r';
        char defendDirection='l';
        int coolDown=0;
        int maxCD=200;
        int range=100;
        int damage=-1;
        ArrayList<Character> allies = new ArrayList<>();
        ArrayList<Character> c=new ArrayList<>();
        ArrayList<Character> targets=new ArrayList<>();
        ArrayList<Attack> P =new ArrayList<>();
        String team="Player";
        String lastMoveCommand="attack";
        boolean runThread=true;

    
	public void draw(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(x,y,xSize,ySize);
        }
        public void increment(ArrayList<Character> c2){
            updateP();
            c=c2;
            allies = new ArrayList<Character>();
            targets = new ArrayList<Character>();
            for(Character o:c){
                if(o.getTeam().equals(team))
                    allies.add(o);
                else if(o.getTeam().equals("Enemy")||o.getTeam().equals("Player"))
                    targets.add(o);               
            }
            if (coolDown>0)
                coolDown--;
            if(enemyInRange()){
                stopMove();
                attack();
            }
            else if(lastMoveCommand.equals("attack"))
                setAttack(true);
            else if(lastMoveCommand.equals("retreat"))
                setRetreat(true);
            
      }
        
        
    	public void moveRight(){
      		x+=1;
  	}
    	public void moveLeft(){
        	x-=1;
    	}
    	public void moveUp(){
        	y-=1; 
    	}
    	public void moveDown(){
        	y+=1;
    	}
	public void setSlowness(int newSlowness){
            slowness=newSlowness;
	}
        
	public int getSlowness(){
		return slowness;
	}
        
        public void setMoveRight(boolean newMoveRight){
            moveRight=newMoveRight;
            if(moveRight)
                lastMoveDir="right";
        }
        
        public void setMoveLeft(boolean newMoveLeft){
            moveLeft=newMoveLeft;
            if(moveLeft)
                lastMoveDir="left";
        }
        
        public void setAttack(boolean a){
            lastMoveCommand="attack";
            if (a){
                if (attackDirection=='r'){
                    moveRight=true;
                    moveLeft=false;
                }
                else{ 
                    moveLeft=true;
                    moveRight=false;
                }
            }
            else{
                if (attackDirection=='r')
                    moveRight=false;
                else moveLeft=false;
            }              
        }
        
        public void setRetreat(boolean a){
            lastMoveCommand="retreat";
            if (a){
                if (defendDirection=='r'){
                    moveRight=true;
                    moveLeft=false;
                }
                else{ 
                    moveLeft=true;
                    moveRight=false;
                }
            }
            else{
                if (defendDirection=='r')
                    moveRight=false;
                else moveLeft=false;
            }              
        }
        
        public void holdPos(){
            stopMove();
            lastMoveCommand="stop";
        }
      
        public void stopMove(){
            moveRight=false;
            moveLeft=false;
        }
        
        Runnable r=new Runnable(){
        public void run(){
         while (runThread){
            if (moveRight && !moveLeft && !enemyInRange() && x<=1200-82-range){
                    moveRight();
                try {
                  Thread.sleep(slowness);
                } catch (InterruptedException ex) {
                  Logger.getLogger(Character.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
             if (moveLeft && !moveRight && !enemyInRange()){
                     moveLeft();
                  try {
                    Thread.sleep(slowness);
                  } catch (InterruptedException ex) {
                    Logger.getLogger(Character.class.getName()).log(Level.SEVERE, null, ex);
                  } 
            }
       }
      }
     };
      
      public void initThread(){
         new Thread(r).start();
        }

      public void stopThread(){
         runThread=false;
        }
      
      public void addAlly(Character a){
          allies.add(a);
      }
      public void removeAlly(Character a){
          allies.remove(a);
      }
      
      public void setHealth(int newHealth){
        health=newHealth;
      }
      public int getHealth(){
        return health;
      }
      public void changeHealth(int value){
        health+=value;
      }
    
      
      public void setDirections(char newAttackDir, char newDefendDir){
         attackDirection=newAttackDir;
         defendDirection=newDefendDir;
     }
      
      public void updateP(){
        for (int x=0;x<P.size();x++){
            if(P.get(x).hasHit() /*|| P.get(x).x>=1050*/||P.get(x).x<=0)
                P.remove(x);
        }
    }
      
      public ArrayList<Attack> getAttacks(){
        return P;
    }
      
      public void attack(){
        if(coolDown<=0){      
            P.add(new Attack());
            P.get(P.size()-1).setDirection(attackDirection);
            if(attackDirection=='l')
                P.get(P.size()-1).setX(x);
            else
                P.get(P.size()-1).setX(x);
            P.get(P.size()-1).setY(y+3);
            P.get(P.size()-1).setSlowness(10);
            P.get(P.size()-1).setDamage(damage);
            P.get(P.size()-1).setTargets(targets);
            //P.get(P.size()-1).initThread();
            coolDown=maxCD;
        }
    }
      
      public void findTargets(){
        for (Character t:c){
            boolean isAlly=false;
            for (Character a:allies)
                if(t==a)
                    isAlly=true;                         
            if(!isAlly)
                targets.add(t);
        }
    }
      
      public String getTeam(){
          return team;
      }
      public void setTeam(String newTeam){
          team=newTeam;
      }
      public boolean enemyInRange(){
          for(Character t:targets){
              if(Math.abs(t.x-x)<=range)
                  return true;
          }
          
          return false; 
              
      }
      public void setX(int newX){
          x=newX;
      }
      public void setY(int newY){
          y=newY;
      }
      public void setRange(int newRange){
          range=newRange;
      }
      public void setMaxCD(int newCD){
          maxCD=newCD;
      }
      public void setDamage(int newDmg){
          damage=newDmg;
      }
      public void deleteObjs(){
          stopThread();
          c=null;
          allies=null;
          targets=null;
          P=null;
      }
      
      
}
