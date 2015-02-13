package joejava.blackjack;

/** Blackjack.java
 *
 *	Application to play blackjack against a computer 
 * (including an option to restrict moves to BasicTraining)
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JPanel;

import joejava.blackjack.bean.BJHand;
import joejava.blackjack.bean.House;
import joejava.blackjack.bean.Player;
import joejava.blackjack.swing.BlackjackTable;
import joejava.blackjack.swing.HousePanel;
import joejava.blackjack.swing.PlayerPanel;
import joejava.blackjack.swing.PokerSwing;
import joejava.poker.PokerUtility;
import joejava.poker.bean.Card;
import joejava.poker.bean.Deck;
 
public class Blackjack extends JPanel implements ActionListener{
	House house;
	Player player;
	
	BlackjackTable table;
	HousePanel housePanel;
	PlayerPanel playerPanel;
	
	int nDecks = 8;
	int time = 1000;	
	private final int MAX_HANDS = 4;

	Deck deck = new Deck(nDecks); 
	//String[] cards = {"As","Ah","As","9c","8c","Qd","10c","10s","As","9h","As","10c","5d","5h","5c","5s","6d","6h","6c","6s","7d","7h","7c","7s","8d","8h","8c","8s","9h","9d","9c","9s","10d","10h","10c","10s","Jd","Jh","Jc","Js","Qd","Qh","Qc","Qs","Kd","Kh","Kc","Ks","Ad","Ah","Ac","As"};
	//LinkedList<String> Deck = new LinkedList<String>(Arrays.asList(cards));
	
	public Blackjack(){
		player = new Player(100);
		setLayout(new BorderLayout());
		setSize(800,500);
		
		PokerSwing.printNow(0,this);
		PokerSwing.Delay(time);
		deal();
	}	
	
	public void deal(){
		removeAll();
		table = new BlackjackTable(this);
		add(table);

		BJHand hand = new BJHand();
		hand.hit(deck.deal());
		hand.hit(deck.deal());
		player.hands.add(hand);
		player.currentHand = 0;

		house = new House();
		house.hit(deck.deal());
		
		playerPanel = new PlayerPanel(player);
		housePanel = new HousePanel(house,true);
		
		table.add(BorderLayout.NORTH,housePanel);
		table.add(BorderLayout.SOUTH,playerPanel);
		
		PokerSwing.printNow(0,this);
		PokerSwing.printNow(0,table);
		peek();
	}	

	public void peek(){
		System.out.println(player.hands.getFirst().getCards().toString());
		System.out.println( " vs. " + house.getCards().toString());

		PokerSwing.Delay(time);
		
		if(player.getCurrentHand().getAbsBjValue() == 21){	//Player gets blackjack
			player.getCurrentHand().setBet((int)(1.5 * player.getCurrentHand().getBet()));							
			dealHouse();
		}
		if(house.getAbsBjValue() == 21 && player.hands.get(0).getAbsBjValue() != 21){		//Dealer gets blackjack, player doesn't
			dealHouse();
		}
		
		table.opts.setVisible(true);
		/*
		if(!PokerUtility.isSplit(player.hands.getFirst().cards)){
			table.split.setEnabled(false);
		}else{
			table.split.setEnabled(true);
		}
		*/
	}
	
	public void split(){
		int[] aces = {2,12};
		boolean isAces = false;
		if(Arrays.equals(player.getCurrentHand().getBjValue(),aces)){	//No resplitting aces
			isAces = true;
		}
		
		BJHand newHand = new BJHand();
		newHand.hit(player.getCurrentHand().getCards().removeLast());
		player.getCurrentHand().refresh(); 
		newHand.hit(deck.deal());
		player.hands.add(player.currentHand + 1, newHand);
		
		if(isAces){
			player.getCurrentHand().hit(deck.deal());
			player.currentHand--;
			System.out.println(9);
		}else{
			player.currentHand++;
			
			if(player.hands.size() == MAX_HANDS){
				table.split.setEnabled(false);
			}
		}
	}

	public void dealHouse(){
		PokerSwing.Delay(time);
		housePanel.refresh(house, false);
		
		while(house.getAbsBjValue() < 17 && player.allBust() == false){
			house.hit(deck.deal());
			housePanel.refresh(house, false);
			PokerSwing.Delay(time);
		}
		
		player.showdown(house);
		PokerSwing.Delay(time);
		deal();
	}
	
	public void actionPerformed (ActionEvent evt){
	
		if(table.basic.isSelected() == false){ 
				//evt.getActionCommand().equals(PokerUtility.getBasic(player.hands.get(0),house.cards.getFirst())) || 
			if(evt.getSource() == table.stand){
				player.currentHand--;
				if(player.currentHand > -1){
					player.getCurrentHand().hit(deck.deal());
				}
			}
			if(evt.getSource() == table.hit){
				player.getCurrentHand().hit(deck.deal());
				playerPanel.refresh(player);
				
				if(player.getCurrentHand().getAbsBjValue() > 20){
					player.currentHand--;
					if(player.currentHand > -1){
						player.getCurrentHand().hit(deck.deal());
					}
				}
			}
			if(evt.getSource() == table.dd){
				player.getCurrentHand().setBet(2 * player.getCurrentHand().getBet());
				player.getCurrentHand().hit(deck.deal());
				player.currentHand--;
				if(player.currentHand > -1){
					player.getCurrentHand().hit(deck.deal());
				}
			}
			if(evt.getSource() == table.split){
				split();
			}
		}else{
			table.add(BorderLayout.CENTER,table.wrongMove); 
			table.wrongMove.setVisible(true);validate();
		}
		
		playerPanel.refresh(player);
		if(player.currentHand < 0){
			dealHouse();
		}
	}
	
	public class StandListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class HitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			player.getCurrentHand().hit(deck.deal());
			playerPanel.refresh(player);
			
			if(player.getCurrentHand().getAbsBjValue() > 20){
				player.currentHand--;
				if(player.currentHand > -1){
					player.getCurrentHand().hit(deck.deal());
				}
			}
		}
	}
	
	public class DoubleDownListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class SplitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}	