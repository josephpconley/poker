package joejava.blackjack.swing;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import joejava.blackjack.bean.House;
import joejava.poker.bean.Card;

public class HousePanel extends JPanel{
	
	public JLabel BJlabel;
	public JLabel betLabel;
	public JPanel cards;
	public JPanel right;
	
	public HousePanel(House house, boolean down){
		setBackground(PokerSwing.felt);
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.white));
		setAlignmentY(Box.CENTER_ALIGNMENT);
		
		refresh(house, down);
	}

	public void refresh(House house, boolean down){
		removeAll();
		BJlabel = new JLabel(" House has " + Arrays.toString(house.bjValue));
		BJlabel.setForeground(Color.red);
		add(BJlabel);	
		
		if(down){
			add(PokerSwing.getCard(house.cards.getFirst()));
			add(PokerSwing.getCard(null));
		}else{
			for(Card card : house.cards){
				add(PokerSwing.getCard(card));
			}
		}
		PokerSwing.printNow(0,this);
	}
	/*
	public void remove(Hand hand){
		removeAll(); setBorder(BorderFactory.createLineBorder(poker.felt));
		SwingUtility.printNow(0,this);	//removes previous stuff (remnants of cards remain otherwise)
		addCards(hand);
		add(BJlabel);
	}
	*/
}
