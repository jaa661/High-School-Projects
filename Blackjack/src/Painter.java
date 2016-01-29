import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Painter extends JFrame implements ActionListener{

	private JMenuItem exit;
	private JMenuItem colorMenu;
	static String Suit;
	static String Number;
	int PlayerCardAmount = 1;
	int DealerCardAmount = 0;
	static	String PlayerCardSuit[] = new String[10];
	static String PlayerCardNumber[] = new String[10];
	static int PlayerCardValue[] = new int[10];
	static String DealerCardSuit[] = new String[10];
	static String DealerCardNumber[] = new String[10];
	static int DealerCardValue[] = new int[10];
	int PlayerCount;
	int DealerCount;
	int TempDealerCount = 0;
	int TempCounter = 0;
	int gregory = 0;
	JButton Hit, Stay;
	Boolean PressStay = false;
	Boolean Bust = false;
	Boolean Ace = false;


	Painter(){

		super("Blackjack");

		init();
		this.setSize(900, 800);
		this.setVisible(true);
	}

	private void init(){

		Color darkgreen = new Color(14, 74, 3);

		//buttons
		Hit = new JButton("Hit");
		Stay  = new JButton("Stay");

		Hit.addActionListener(this);
		Stay.addActionListener(this);
		JPanel panel = new JPanel(new GridBagLayout());  
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 5;
		panel.add(Hit, c);
		c.gridx = 0;
		c.gridy = 6;
		panel.add(Stay);

		this.add(panel);
		panel.setBackground(darkgreen);

		//generate card values		
		PlayerGenerateCardType();
		DealerGenerateCardType();
	}//end init

	public void paint(Graphics g){

		super.paint(g);

		Gameboard(g);
		Dealer(g);
	}
	public void PlayerGenerateCardType(){

		Random generator = new Random();
		int PickedNumber;
		int PickedNumber2;
		for(int index = 0; index <= 9; index++){

			PickedNumber = generator.nextInt(13);
			String Numbers [] = {"A", "2", "3", "4","5","6","7","8","9","10","J","Q","K"};

			PlayerCardNumber[index] = Numbers[PickedNumber];
			if(Numbers[PickedNumber].equals("K") || Numbers[PickedNumber].equals("Q") || Numbers[PickedNumber].equals("J")){
				PlayerCardValue[index] = 10;
			}
			else if(Numbers[PickedNumber].equals("A")){
				PlayerCardValue[index] = 11;
			}	
			else{	
				PlayerCardValue[index] = PickedNumber + 1; 
			}
			PickedNumber2 = generator.nextInt(4);
			String suits [] = {"Heart","Club","Spade","Diamond"};
			PlayerCardSuit[index] = suits[PickedNumber2];
		}}//end for and generate
	public void DealerGenerateCardType(){

		Random generator = new Random();
		int PickedNumber;
		int PickedNumber2;
		for(int index = 0; index <= 9; index++){

			PickedNumber = generator.nextInt(13);
			String Numbers [] = {"A", "2", "3", "4","5","6","7","8","9","10","J","Q","K"};
			DealerCardNumber[index] = Numbers[PickedNumber];
			if(Numbers[PickedNumber].equals("K") || Numbers[PickedNumber].equals("Q") || Numbers[PickedNumber].equals("J")){
				DealerCardValue[index] = 10;
			}
			else{
				DealerCardValue[index] = PickedNumber + 1; 
			}
			PickedNumber2 = generator.nextInt(4);
			String suits [] = {"Heart","Club","Spade","Diamond"};
			DealerCardSuit[index] = suits[PickedNumber2];
		}}//end for and generate
	public void Dealer(Graphics g){
		//dealercards	
		CardBack(150, 0, g);
		DealerCardFront(0, 0, DealerCardNumber[0],  DealerCardSuit[0], g);

		switch(DealerCardAmount){
		case 1:
			PlayerCardFront(0, 0, DealerCardNumber[0],  DealerCardSuit[0], g);
			PlayerCardFront(150, 0, DealerCardNumber[1],  DealerCardSuit[1], g);
			DealerCount = DealerCardValue[0] + DealerCardValue[1]; 
			break;
		case 2:
			PlayerCardFront(0, 0, DealerCardNumber[0],  DealerCardSuit[0], g);
			PlayerCardFront(150, 0, DealerCardNumber[1],  DealerCardSuit[1], g);
			PlayerCardFront(300, 0, DealerCardNumber[2],  DealerCardSuit[2], g);
			DealerCount = DealerCardValue[0] + DealerCardValue[1] + DealerCardValue[2]; 

			break;
		case 3:
			PlayerCardFront(0, 0, DealerCardNumber[0],  DealerCardSuit[0], g);
			PlayerCardFront(150, 0, DealerCardNumber[1],  DealerCardSuit[1], g);
			PlayerCardFront(300, 0, DealerCardNumber[2],  DealerCardSuit[2], g);
			PlayerCardFront(450, 0, DealerCardNumber[3],  DealerCardSuit[3], g);
			DealerCount = DealerCardValue[0] + DealerCardValue[1] + DealerCardValue[2]  + DealerCardValue[3]; 
			break;
		case 4:
			PlayerCardFront(0, 0, DealerCardNumber[0],  DealerCardSuit[0], g);
			PlayerCardFront(150, 0, DealerCardNumber[1],  DealerCardSuit[1], g);
			PlayerCardFront(300, 0, DealerCardNumber[2],  DealerCardSuit[2], g);
			PlayerCardFront(450, 0, DealerCardNumber[3],  DealerCardSuit[3], g);
			PlayerCardFront(600, 0, DealerCardNumber[4],  DealerCardSuit[4], g);
			DealerCount = DealerCardValue[0] + DealerCardValue[1] + DealerCardValue[2] + DealerCardValue[3] + DealerCardValue[4]; 
			break;
		case 5:
			PlayerCardFront(0, 0, DealerCardNumber[0],  DealerCardSuit[0], g);
			PlayerCardFront(150, 0, DealerCardNumber[1],  DealerCardSuit[1], g);
			PlayerCardFront(300, 0, DealerCardNumber[2],  DealerCardSuit[2], g);
			PlayerCardFront(450, 0, DealerCardNumber[3],  DealerCardSuit[3], g);
			PlayerCardFront(600, 0, DealerCardNumber[4],  DealerCardSuit[4], g);
			PlayerCardFront(750, 0, DealerCardNumber[5],  DealerCardSuit[5], g);
			DealerCount = DealerCardValue[0] + DealerCardValue[1] + DealerCardValue[2] + DealerCardValue[3] + DealerCardValue[4] + DealerCardValue[5]; 
			break;
		case 6:
			PlayerCardFront(0, 0, DealerCardNumber[0],  DealerCardSuit[0], g);
			PlayerCardFront(150, 0, DealerCardNumber[1],  DealerCardSuit[1], g);
			PlayerCardFront(300, 0, DealerCardNumber[2],  DealerCardSuit[2], g);
			PlayerCardFront(450, 0, DealerCardNumber[3],  DealerCardSuit[3], g);
			PlayerCardFront(600, 0, DealerCardNumber[4],  DealerCardSuit[4], g);
			PlayerCardFront(750, 0, DealerCardNumber[5],  DealerCardSuit[5], g);
			PlayerCardFront(900, 0, DealerCardNumber[6],  DealerCardSuit[6], g);
			DealerCount = DealerCardValue[0] + DealerCardValue[1] + DealerCardValue[2] + DealerCardValue[3] + DealerCardValue[4] + DealerCardValue[5] + DealerCardValue[6]; 
		case 7:
			PlayerCardFront(0, 0, DealerCardNumber[0],  DealerCardSuit[0], g);
			PlayerCardFront(150, 0, DealerCardNumber[1],  DealerCardSuit[1], g);
			PlayerCardFront(300, 0, DealerCardNumber[2],  DealerCardSuit[2], g);
			PlayerCardFront(450, 0, DealerCardNumber[3],  DealerCardSuit[3], g);
			PlayerCardFront(600, 0, DealerCardNumber[4],  DealerCardSuit[4], g);
			PlayerCardFront(750, 0, DealerCardNumber[5],  DealerCardSuit[5], g);
			PlayerCardFront(900, 0, DealerCardNumber[6],  DealerCardSuit[6], g);
			PlayerCardFront(1050, 0, DealerCardNumber[7],  DealerCardSuit[7], g);
			DealerCount = DealerCardValue[0] + DealerCardValue[1] + DealerCardValue[2] + DealerCardValue[3] + DealerCardValue[4] + DealerCardValue[5] + DealerCardValue[6] + DealerCardValue[7]; 
		case 8:
			PlayerCardFront(0, 0, DealerCardNumber[0],  DealerCardSuit[0], g);
			PlayerCardFront(150, 0, DealerCardNumber[1],  DealerCardSuit[1], g);
			PlayerCardFront(300, 0, DealerCardNumber[2],  DealerCardSuit[2], g);
			PlayerCardFront(450, 0, DealerCardNumber[3],  DealerCardSuit[3], g);
			PlayerCardFront(600, 0, DealerCardNumber[4],  DealerCardSuit[4], g);
			PlayerCardFront(750, 0, DealerCardNumber[5],  DealerCardSuit[5], g);
			PlayerCardFront(900, 0, DealerCardNumber[6],  DealerCardSuit[6], g);
			PlayerCardFront(1050, 0, DealerCardNumber[7],  DealerCardSuit[7], g);
			PlayerCardFront(1200, 0, DealerCardNumber[8],  DealerCardSuit[8], g);
			DealerCount = DealerCardValue[0] + DealerCardValue[1] + DealerCardValue[2] + DealerCardValue[3] + DealerCardValue[4] + DealerCardValue[5] + DealerCardValue[6] + DealerCardValue[7] + DealerCardValue[8]; 

			break;
			//default:
			//System.out.println("error");
		}

	}
	public void Gameboard(Graphics g){
		//dealercards	

		switch(PlayerCardAmount){
		case 1:
			PlayerCardFront(0, 500, PlayerCardNumber[0],  PlayerCardSuit[0], g);
			PlayerCardFront(150, 500, PlayerCardNumber[1],  PlayerCardSuit[1], g);
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1]; 
			break;
		case 2:
			PlayerCardFront(0, 500, PlayerCardNumber[0],  PlayerCardSuit[0], g);
			PlayerCardFront(150, 500, PlayerCardNumber[1],  PlayerCardSuit[1], g);
			PlayerCardFront(300, 500, PlayerCardNumber[2],  PlayerCardSuit[2], g);
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2]; 

			break;
		case 3:
			PlayerCardFront(0, 500, PlayerCardNumber[0],  PlayerCardSuit[0], g);
			PlayerCardFront(150, 500, PlayerCardNumber[1],  PlayerCardSuit[1], g);
			PlayerCardFront(300, 500, PlayerCardNumber[2],  PlayerCardSuit[2], g);
			PlayerCardFront(450, 500, PlayerCardNumber[3],  PlayerCardSuit[3], g);
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2]  + PlayerCardValue[3]; 
			break;
		case 4:
			PlayerCardFront(0, 500, PlayerCardNumber[0],  PlayerCardSuit[0], g);
			PlayerCardFront(150, 500, PlayerCardNumber[1],  PlayerCardSuit[1], g);
			PlayerCardFront(300, 500, PlayerCardNumber[2],  PlayerCardSuit[2], g);
			PlayerCardFront(450, 500, PlayerCardNumber[3],  PlayerCardSuit[3], g);
			PlayerCardFront(600, 500, PlayerCardNumber[4],  PlayerCardSuit[4], g);
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4]; 
			break;
		case 5:
			PlayerCardFront(0, 500, PlayerCardNumber[0],  PlayerCardSuit[0], g);
			PlayerCardFront(150, 500, PlayerCardNumber[1],  PlayerCardSuit[1], g);
			PlayerCardFront(300, 500, PlayerCardNumber[2],  PlayerCardSuit[2], g);
			PlayerCardFront(450, 500, PlayerCardNumber[3],  PlayerCardSuit[3], g);
			PlayerCardFront(600, 500, PlayerCardNumber[4],  PlayerCardSuit[4], g);
			PlayerCardFront(750, 500, PlayerCardNumber[5],  PlayerCardSuit[5], g);
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4] + PlayerCardValue[5]; 
			break;
		case 6:
			PlayerCardFront(0, 500, PlayerCardNumber[0],  PlayerCardSuit[0], g);
			PlayerCardFront(150, 500, PlayerCardNumber[1],  PlayerCardSuit[1], g);
			PlayerCardFront(300, 500, PlayerCardNumber[2],  PlayerCardSuit[2], g);
			PlayerCardFront(450, 500, PlayerCardNumber[3],  PlayerCardSuit[3], g);
			PlayerCardFront(600, 500, PlayerCardNumber[4],  PlayerCardSuit[4], g);
			PlayerCardFront(750, 500, PlayerCardNumber[5],  PlayerCardSuit[5], g);
			PlayerCardFront(900, 500, PlayerCardNumber[6],  PlayerCardSuit[6], g);
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4] + PlayerCardValue[5] + PlayerCardValue[6]; 
			break;
		case 7:
			PlayerCardFront(0, 500, PlayerCardNumber[0],  PlayerCardSuit[0], g);
			PlayerCardFront(150, 500, PlayerCardNumber[1],  PlayerCardSuit[1], g);
			PlayerCardFront(300, 500, PlayerCardNumber[2],  PlayerCardSuit[2], g);
			PlayerCardFront(450, 500, PlayerCardNumber[3],  PlayerCardSuit[3], g);
			PlayerCardFront(600, 500, PlayerCardNumber[4],  PlayerCardSuit[4], g);
			PlayerCardFront(750, 500, PlayerCardNumber[5],  PlayerCardSuit[5], g);
			PlayerCardFront(900, 500, PlayerCardNumber[6],  PlayerCardSuit[6], g);
			PlayerCardFront(1050, 500, PlayerCardNumber[7],  PlayerCardSuit[7], g);
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4] + PlayerCardValue[5] + PlayerCardValue[6] + PlayerCardValue[7]; 
			break;
		case 8:
			PlayerCardFront(0, 500, PlayerCardNumber[0],  PlayerCardSuit[0], g);
			PlayerCardFront(150, 500, PlayerCardNumber[1],  PlayerCardSuit[1], g);
			PlayerCardFront(300, 500, PlayerCardNumber[2],  PlayerCardSuit[2], g);
			PlayerCardFront(450, 500, PlayerCardNumber[3],  PlayerCardSuit[3], g);
			PlayerCardFront(600, 500, PlayerCardNumber[4],  PlayerCardSuit[4], g);
			PlayerCardFront(750, 500, PlayerCardNumber[5],  PlayerCardSuit[5], g);
			PlayerCardFront(900, 500, PlayerCardNumber[6],  PlayerCardSuit[6], g);
			PlayerCardFront(1050, 500, PlayerCardNumber[7],  PlayerCardSuit[7], g);
			PlayerCardFront(1200, 500, PlayerCardNumber[8],  PlayerCardSuit[8], g);
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4] + PlayerCardValue[5] + PlayerCardValue[6] + PlayerCardValue[7] + PlayerCardValue[8]; 
			break;
			//default:
			//System.out.println("error");
		}


	}
	public int PlayerCount(){
		//dealercards	

		switch(PlayerCardAmount){
		case 1:
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1]; 
			break;
		case 2:
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2]; 

			break;
		case 3:
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2]  + PlayerCardValue[3]; 
			break;
		case 4:
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4]; 
			break;
		case 5:
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4] + PlayerCardValue[5]; 
			break;
		case 6:
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4] + PlayerCardValue[5] + PlayerCardValue[6]; 
			break;
		case 7:
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4] + PlayerCardValue[5] + PlayerCardValue[6] + PlayerCardValue[7]; 
			break;
		case 8:
			PlayerCount = PlayerCardValue[0] + PlayerCardValue[1] + PlayerCardValue[2] + PlayerCardValue[3] + PlayerCardValue[4] + PlayerCardValue[5] + PlayerCardValue[6] + PlayerCardValue[7] + PlayerCardValue[8]; 
			break;
			//default:
			//System.out.println("error");
		}
		return PlayerCount;

	}

	public void PlayerCardFrontMoving(int xposition, int yposition, String Number, String Suit, Graphics g){

		Image Blackjack = new ImageIcon("Blackjack.jpg").getImage();  
		Image Club = new ImageIcon(Suit + ".jpg").getImage();  

		//amount of cards
		g.setColor(Color.white);
		g.fillRoundRect((xposition+5)+(PlayerCardAmount*150), yposition+60, 150, 200, 20, 20);
		g.setColor(Color.black);
		g.drawRoundRect((xposition+5)+(PlayerCardAmount*150), yposition+60, 150, 200, 20, 20);
		//logo
		g.drawImage(Blackjack, (xposition+20)+(PlayerCardAmount*150), yposition+80, 120, 160, null, null);
		//suit/num
		g.drawString(Number, (xposition+15)+(PlayerCardAmount*150), yposition+75);
		g.drawImage(Club, (xposition+25)+(PlayerCardAmount*150), yposition+85, 25, 25, null, null);
		g.drawString(Number, (xposition+140)+(PlayerCardAmount*150), yposition+250);
		g.drawImage(Club, (xposition+110)+(PlayerCardAmount*150), yposition+210, 25, 25, null, null);

	}
	public void PlayerCardFront(int xposition, int yposition, String Number, String Suit, Graphics g){

		Image Blackjack = new ImageIcon("Blackjack.jpg").getImage();  
		Image Club = new ImageIcon(Suit + ".jpg").getImage();  

		//keeps dealer card mount
		g.setColor(Color.white);
		g.fillRoundRect(xposition+5, yposition+60, 150, 200, 20, 20);
		g.setColor(Color.black);
		g.drawRoundRect(xposition+5, yposition+60, 150, 200, 20, 20);
		//logo
		g.drawImage(Blackjack, xposition+20, yposition+80, 120, 160, null, null);
		//suit/num
		g.drawString(Number, xposition+15, yposition+75);
		g.drawImage(Club, xposition+25, yposition+85, 25, 25, null, null);
		g.drawString(Number, xposition+140, yposition+250);
		g.drawImage(Club, xposition+110, yposition+210, 25, 25, null, null);

	}

	public void DealerCardFront(int xposition, int yposition, String Number, String Suit, Graphics g){

		Image Blackjack = new ImageIcon("Blackjack.jpg").getImage();  
		Image Club = new ImageIcon(Suit + ".jpg").getImage();  

		//keeps dealer card mount
		g.setColor(Color.white);
		g.fillRoundRect(xposition+5, yposition+60, 150, 200, 20, 20);
		g.setColor(Color.black);
		g.drawRoundRect(xposition+5, yposition+60, 150, 200, 20, 20);
		//logo
		g.drawImage(Blackjack, xposition+20, yposition+80, 120, 160, null, null);
		//suit/num
		g.drawString(Number, xposition+15, yposition+75);
		g.drawImage(Club, xposition+25, yposition+85, 25, 25, null, null);
		g.drawString(Number, xposition+140, yposition+250);
		g.drawImage(Club, xposition+110, yposition+210, 25, 25, null, null);

	}

	public void CardBack(int xposition, int yposition, Graphics g){

		Image CardBack = new ImageIcon("CardBack.jpg").getImage();  
		g.drawImage(CardBack, xposition+5, yposition+60, 150, 200, null, null);
	}

	public void fillDiamond(int diamondxposition, int diamondyposition, Graphics g){

		int xpos [] = {diamondxposition+25, diamondxposition+50, diamondxposition+25, diamondxposition};
		int ypos[] = {diamondyposition, diamondyposition+25, diamondyposition+50, diamondyposition+25};
		g.setColor(Color.red);
		g.fillPolygon(xpos, ypos, 4);



	}
	public void actionPerformed(ActionEvent e){


		if (e.getSource() == Hit)
		{
			PlayerCardAmount = PlayerCardAmount + 1;
			PlayerCount();
			PlayerCardAmount = PlayerCardAmount - 1;
			if(PressStay == true)
			{
				JOptionPane.showMessageDialog(null, "Sorry, but you already stayed");
			}//close if
			else if(PlayerCount >= 22){	
				PlayerCardAmount = PlayerCardAmount + 1;
				repaint();
			///*
				for(int i = 0;i <= 9; i++)
				{
					if(PlayerCardValue[i] == 11)
					{
						PlayerCardValue[i] = 1;
						Ace = true;
					}//close if
				}//close for
			//*/	
				if(Ace != true)
				{
					JOptionPane.showMessageDialog(null, "Sorry, but you bust!\n" + PlayerCount);
                                        RunPainter.main(null);
					Bust = true;
				}
				else if(Ace == true){
				Ace = false;	
					
				}
			}//close else if
			

			else{
				repaint();
				PlayerCardAmount = PlayerCardAmount + 1;
			}//close else
		}//end if
		else if(e.getSource() == Stay){

			PressStay = true;

			while( TempDealerCount <= 16){
				TempDealerCount = TempDealerCount + DealerCardValue[TempCounter];
				TempCounter = TempCounter + 1; 
			}//close while

			DealerCardAmount = TempCounter - 1;
			repaint();	

			if(PressStay == true)
			{
				if(TempDealerCount >= 22){		
					JOptionPane.showMessageDialog(null, "You Win! The dealer busted\n");
                                        RunPainter.main(null);
				}//close if
                                else if(TempDealerCount > PlayerCount || Bust){		
					JOptionPane.showMessageDialog(null, "Sorry, but you lose!\n");
                                        RunPainter.main(null);
				}//close if
                                else if(PlayerCount > TempDealerCount){
					repaint();
					JOptionPane.showMessageDialog(null, "You Win!\n");
                                        RunPainter.main(null);

				}//close else if
				else if(PlayerCount == TempDealerCount){
					repaint();
					JOptionPane.showMessageDialog(null, "You Tied!\n");
                                        RunPainter.main(null);
				}//close else if
			}//close if

		}//end else if
	}//end actionPerformed

}//end class






