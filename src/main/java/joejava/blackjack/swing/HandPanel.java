package joejava.blackjack.swing;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import joejava.blackjack.bean.BJHand;
import joejava.poker.bean.Card;

public class HandPanel extends JPanel{

	public JLabel BJLabel;
	
	public HandPanel(BJHand hand){
		removeAll();
		setBackground(PokerSwing.felt);
		setBorder(BorderFactory.createLineBorder(Color.white));
		
		BJLabel = new JLabel(" You have " + Arrays.toString(hand.getBjValue()));
		BJLabel.setForeground(Color.red);
		add(BJLabel);

		for(Card card : hand.getCards()){
			add(PokerSwing.getCard(card));
		}
	}
}