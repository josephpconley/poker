package joejava.blackjack.swing;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import joejava.blackjack.bean.BJHand;
import joejava.blackjack.bean.Player;

public class PlayerPanel extends JPanel {

	private Player player;
	
	public PlayerPanel(Player player){
		setBackground(PokerSwing.felt);
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		refresh(player);
	}
	
	public void refresh(Player player){
		this.player = player;
		
		removeAll();
		add(PokerSwing.cash(player.score));
		for(BJHand hand : player.hands){
			add(new HandPanel(hand));
		}
		PokerSwing.printNow(0,this);
	}
}
