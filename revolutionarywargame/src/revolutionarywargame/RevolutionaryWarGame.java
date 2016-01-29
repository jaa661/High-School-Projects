package revolutionarywargame;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;

public class RevolutionaryWarGame extends JFrame implements ActionListener{
    Image buffer;
    Button btn = new Button("Title");
    Button bat1=new Button("Lexington and Concord");
    Button bat2=new Button("Bunker Hill");
    Button bat3=new Button("Fort Washington");
    Button bat4=new Button("Trenton");
    Button bat5=new Button("Saratoga");
    Button bat6=new Button("Yorktown");
    ArrayList<Battle> battles = new ArrayList();    
    
    boolean bat1Win=true;
    boolean bat2Win=true;       //Set to true to allow keeping progress through restarts
    boolean bat3Win=true;
    boolean bat4Win=true;
    boolean bat5Win=true;
    
    Font myfont = new Font("Serif",Font.BOLD,12);
    
    
      public void init(){
       setFocusable(true);
       requestFocusInWindow(); 
       battles.clear();
       battles.add(new Battle());
       battles.get(0).setVisible(false);
       
       bat1.setSize(160,20);
       bat1.setLocation(100,50);
       add(bat1); //BATTLE 1
       
       bat2.setSize(160,20);
       bat2.setLocation(100,80);
       add(bat2); //BATTLE 2
       
       bat3.setSize(160,20);
       bat3.setLocation(100,110);
       add(bat3); //BATTLE 3
       
       bat4.setSize(160,20);
       bat4.setLocation(100,140);
       add(bat4); //BATTLE 4
       
       bat5.setSize(160,20);
       bat5.setLocation(100,170);
       add(bat5); //BATTLE 5
       
       bat6.setSize(160,20);
       bat6.setLocation(100,200);
       add(bat6); //BATTLE 6
       
       bat1.addActionListener(this);
       bat2.addActionListener(this);
       bat3.addActionListener(this);
       bat4.addActionListener(this);
       bat5.addActionListener(this);
       bat6.addActionListener(this);
        
    }


    public void paint(Graphics g){
        buffer=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics bufferG=buffer.getGraphics();
        bufferG.setColor(Color.red);
        bufferG.fillRect(0,0,20,00);

        g.drawImage(buffer, 0, 0, this);
    }
    
    public static void main(String[] args) {
        RevolutionaryWarGame f = new RevolutionaryWarGame();
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setVisible(true);
        f.setSize(300, 600);
        f.setTitle("Revolutionary War Game");
        f.init();       
    }
    
    public void win(){
            if(battles.get(0).battleNum==1){
                bat1Win=true;
                JOptionPane.showMessageDialog(null, "The battle itself was low in actual casualties, but the effects were great. \n"+
"The “shot heard ‘round the world” became known across the colonies\n"+
"and Great Britain, bringing on a true war for independence by the summer of 1775.", "Victory!!", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==2){
                bat2Win=true;
                JOptionPane.showMessageDialog(null, "The fighting was bloody and difficult for the British, who succeeded in taking\n"+
"Breed’s Hill and, therefore, Boston, but they suffered heavy casualties. The British had 1,000 men dead\n"+
"or injured, as opposed to the colonists, who had only 400 casualties. The Battle of Bunker Hill was crucial\n"+
"in defeating the idea of the invincible British and breaking down British morale in the beginning of the war.", "Victory 2", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==3){
                bat3Win=true;
                JOptionPane.showMessageDialog(null, "The surviving Continental soldiers were put on prison ships, most of whom died of starvation\n"+
"and disease. The British victory is mainly attributed to a traitor to the Continental army, William Demont, who defected to the British.", "Victory 3", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==4){
                bat4Win=true;
                JOptionPane.showMessageDialog(null, "The Battle of Trenton likely saved Washington’s Continental Army and the war effort \n"+
"from destruction and is arguably one of Washington’s only good military actions. The Hessian troops garrisoned\n"+
"at Trenton surrendered with just over 1,000 casualties, while the Continental Army only had 7 casualties. The 2\n"+
"deaths suffered by the Continentals were by freezing during the march to Trenton. Trenton was not a major\n"+
"blow against the British in itself, but it was essential for the continuation of the war.", "Victory 4", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==5){
                JOptionPane.showMessageDialog(null, "The Battle of Saratoga was not a major military victory, but it was a monumental political victory.\n"+
"Not only did it grant the Continental soldiers their desperately needed morale boost, but it also turned\n"+
"the American Revolution into a small-scale world war. Saratoga was the tipping point that\n" +
"convinced the French to openly aid the colonists in their Revolution. It also served as the catalyst for\n"+
"bringing Holland and Spain directly into the war, attacking the British Isles, as well as Russia’s organization\n"+
"of Armed Neutrality, which was essentially a collective screw-you-Britain from the rest of Europe.", "Victory 5", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==6){
                JOptionPane.showMessageDialog(null, "Any hope for British survival fell to the bottom of the Chesapeake Bay with Britain’s New York \n"+
"naval fleet, sunk by the French armada. General Cornwallis could no longer hold out against the artillery barrages\n"+
"and gave the order to surrender. The Siege of Yorktown would be the last true battle of the Revolutionary War and\n"+
"peace negotiations would begin soon after the conclusion of the battles.get(0).", "Victory 6", JOptionPane.INFORMATION_MESSAGE);
            }
            battles.get(0).setVisible(false);         
    }
    public void lose(){
        
            if(battles.get(0).battleNum==1){
                JOptionPane.showMessageDialog(null, "You were defeated! Try again...", "Defeat 1", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==2){
                JOptionPane.showMessageDialog(null, "You were defeated! Try again...", "Defeat 2", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==3){
                JOptionPane.showMessageDialog(null, "You were defeated! Try again...", "Defeat 3", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==4){
                JOptionPane.showMessageDialog(null, "You were defeated! Try again...", "Defeat 4", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==5){
                JOptionPane.showMessageDialog(null, "You were defeated! Try again...", "Defeat 5", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(battles.get(0).battleNum==6){
                JOptionPane.showMessageDialog(null, "You were defeated! Try again...", "Defeat 6", JOptionPane.INFORMATION_MESSAGE);
            }
            battles.get(0).setVisible(false);        
        repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bat1){
             battles.clear();
            battles.add(new Battle());
            System.gc();
            JOptionPane.showMessageDialog(null, "April 19, 1775\n" +
"Massachusetts\n" +
"\n" +
"The battles of Lexington and Concord were preceded by years of somewhat quiet frustration \n"+
"by the colonists, mostly on principle rather than actual injustice, until the Boston Massacre \n"+
"and Tea Party. When Colonial and British troops met in Lexington, the colonists fled to Concord, \n"+
"where they were reinforced by the remaining minutemen and made a final stand to successfully drive \n"+
"off the 700 British Regulars. \n"+
"\n Game Type: Survival ","Battles of Lexington and Concord", JOptionPane.INFORMATION_MESSAGE);
            battles.get(0).setVisible(true);
            battles.get(0).init(450,3,true,this);
            battles.get(0).setMaxKills(7);
            battles.get(0).setBattleNum(1);
            //System.out.println("Battle 1");
            repaint();
        } //end bat1
        else if(e.getSource()==bat2){
            if(bat1Win){   
                battles.clear();
                battles.add(new Battle());
                System.gc();
                JOptionPane.showMessageDialog(null, "June 17, 1775\n" +
"Breed’s Hill, Massachusetts\n" +
"\n" +
"British troops intended to invade and occupy Colonial-controlled Boston, so the colonists fortified\n"+
"nearby Breed’s Hill to defend against the coming army. Concerned due to low ammunition, Colonel\n"+
"Prescott gave his Continental soldiers the famous order not to “fire until you see the whites of their eyes.”\n"+
"\n Game Type: Survival ", "Bunker Hill", JOptionPane.INFORMATION_MESSAGE);
                battles.get(0).setVisible(true);
                battles.get(0).init(550, 3,true, this);           
                System.out.println("Battle 2");
                battles.get(0).setMaxKills(7);
                //battles.get(0).setBattleNum(2);
                repaint();
            }
        } //end bat2
        else if(e.getSource()==bat3){
            if(bat2Win){     
                battles.clear();
                battles.add(new Battle());
                System.gc();
                JOptionPane.showMessageDialog(null, "November 16, 1776\n" +
"Manhattan Island, New York\n" +
"\n" +
"General Wilhelm von Knyphausen of Germany led 8,000 troops, both Hessian and British, to\n"+
"Fort Washington in New York. The Colonial troops stationed in the fort gave strong resistance,\n"+
"but it was short lived. The battle lasted a matter of hours with British victory.\n"+
"\n Game Type: Survival ", "Fort Washington", JOptionPane.INFORMATION_MESSAGE);
                battles.get(0).pack();
                battles.get(0).init(600, 4,true, this);  
                battles.get(0).setMaxKills(5);
                //System.out.println("Battle 3");
                battles.get(0).setBattleNum(3);
                repaint();
            }
        } //end bat3
        else if(e.getSource()==bat4){
            if(bat3Win){     
                battles.clear();
                battles.add(new Battle());
                 System.gc();
                System.gc();
                JOptionPane.showMessageDialog(null, "December 26, 1776\n" +
"Trenton, New Jersey\n" +
"\n" +
"Before the Battle of Trenton, General Washington was on the run from General Howe in New York,\n"+
"stopping at Valley Forge, Pennsylvania, for the winter. Washington crossed the Delaware River to\n"+
"Trenton on Christmas, knowing the German mercenaries would be too drunk to form a defense or even \n"+
"aim properly.\n"+
"\n Game Type: Battle ", "Trenton", JOptionPane.INFORMATION_MESSAGE);
                battles.get(0).pack();
                battles.get(0).init(800, 4,false, this);           
                //System.out.println("Battle 4");
                battles.get(0).setBattleNum(4);
                repaint();
            }
        } //end bat4
        else if(e.getSource()==bat5){
            if(bat4Win){  
                battles.clear();
            battles.add(new Battle());
            System.gc();
                JOptionPane.showMessageDialog(null, "October 7, 1777\n" +
"New York\n" +
"\n" +
"After British troops took Fort Ticonderoga, they moved towards New York, the colonial trade\n"+
"center, from Canada. Slow movement on the side of the British gave Continental forces the time\n"+
"to prepare defenses and gather reinforcements to ward of the incoming British army. Fighting took\n"+
"place on 2 separate days, but ended with British General John Burgoyne’s surrender 10 days later.\n"+
"\n Game Type: Battle ", "Saratoga", JOptionPane.INFORMATION_MESSAGE);
                battles.get(0).pack();
                battles.get(0).init(800, 5,false, this);           
                //System.out.println("Battle 5");
                battles.get(0).setBattleNum(5);
                repaint();
            }
        }//end bat5
        else if(e.getSource()==bat6){
            if(bat5Win){  
                battles.clear();
                battles.add(new Battle());
                System.gc();
                JOptionPane.showMessageDialog(null, "October 14, 1781\n" +
"Yorktown, Virginia\n" +
"\n" +
"British General Cornwallis holed up in Yorktown, Virginia after retreating from previous engagements,\n"+
"only to be surrounded by a French fleet of 34 ships and 3,000 soldiers by sea and every remaining soldier\n"+
"General Washington could find by land. Both Colonists and the French bombarded the city of Yorktown for days.\n"+
"\n Game Type: Battle ", "Yorktown", JOptionPane.INFORMATION_MESSAGE);
                battles.get(0).pack();
                battles.get(0).init(800, 5,false, this);           
                //System.out.println("Battle 6");
                battles.get(0).setBattleNum(6);
                repaint();
            }
        } //end bat6     
    }
}