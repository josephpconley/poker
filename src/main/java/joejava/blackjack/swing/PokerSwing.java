package joejava.blackjack.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import joejava.poker.PokerUtility;
import joejava.poker.bean.Card;

public class PokerSwing{

	public static Color felt = new Color(20,64,0);
	static String path="resources/images/cards/";
	JLabel back = new JLabel(new ImageIcon(path+"back-red.jpg"));
	JLabel chips = new JLabel(new ImageIcon(path+"chips.jpg"));
	Icon spade = new ImageIcon(path+"spade.gif");
	Icon club = new ImageIcon(path+"club.gif");
	Icon heart = new ImageIcon(path+"heart.gif");
	Icon diamond = new ImageIcon(path+"diamond.gif");
	public static JButton[] suits = new JButton[4];
	public static JButton[] ranks = new JButton[13];
	
	public PokerSwing(){
		suits[0]=new JButton(club);
		suits[0].setName("club");	
		suits[1]=new JButton(diamond);
		suits[1].setName("diamond");
		suits[2]=new JButton(heart);
		suits[2].setName("heart");
		suits[3]=new JButton(spade);
		suits[3].setName("spade");
		
		for(int i=0;i<ranks.length;i++){
			if(i!=8)
				ranks[i]=new JButton(PokerUtility.deck[i*4].substring(0,1));
			else
				ranks[i]=new JButton(PokerUtility.deck[i*4].substring(0,2));
		}		
	}
	
	public static JLabel getCard(Card card){
		if(card == null){
            return new JLabel(new ImageIcon(path+"back-red.jpg"));
        } else{
            String gif = path + card.toString() + ".gif";
            return new JLabel(new ImageIcon(gif));
        }
	}
	
	//Generates a label displaying money for Blackjack
	public static JLabel cash(double cash){
		JLabel score = new JLabel();	
		score.setFont(new Font("Verdana",Font.BOLD,18));
	
		if(cash<0){
			score.setText("-$"+(-1*cash)+"   ");	
			score.setForeground(Color.red);
		}
		else{
			score.setText("$"+cash+"   ");		
			score.setForeground(Color.green);
		}
		return score;
	}
	
	public static void printNow(int time,JComponent obj){
		Dimension dim=obj.getSize();
		obj.validate();
		obj.paintImmediately(0,0,dim.width,dim.height);
		try{
			Thread.sleep(time);
			}
			catch (InterruptedException e){
			}
	}
	
	public static void Delay(int delay){	//delays process 
	
		try{
		Thread.sleep(delay);
		}
		catch (InterruptedException e){
		}
	}
}
