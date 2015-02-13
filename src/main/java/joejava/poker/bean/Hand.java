package joejava.poker.bean;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

import joejava.poker.bean.Card.Rank;
import joejava.poker.bean.Card.Suit;
import joejava.util.MathUtility;

public class Hand implements Comparable<Hand> {
	private LinkedList<Card> cards;
	
	public Hand(){
		cards = new LinkedList<Card>();
	}
	
	public LinkedList<Card> getCards() {
		return cards;
	}
	
	public void addCard(Card c){
		this.cards.add(c);
		this.sortHand();
	}
	public void addCards(Card[] cards){
		for(Card c : cards){
			this.cards.add(c);
		}
		this.sortHand();
	}
	
	public HashMap<Rank,Integer> countRanks(){
		HashMap<Rank,Integer> map = new HashMap<Rank,Integer>();
		for(Card c : this.cards){
			if(map.containsKey(c.getRank()) == false){
				map.put(c.getRank(), 1);
			}else{
				int n = map.get(c.getRank());
				map.put(c.getRank(), n + 1);
			}
		}
		
		return map;
	}
	
	public void sort(){
		Comparator<Card> comp = Collections.reverseOrder();
		Collections.sort(this.cards,comp);
	}
	
	//Sorts hand based on rules of poker	
	public void sortHand(){
		Comparator<Card> comp = Collections.reverseOrder();
		Collections.sort(this.cards,comp);
		HashMap<Rank,Integer> map = countRanks();
		LinkedList<Card> temp = new LinkedList<Card>();
		temp.addAll(this.cards);
		
		//Quads
		if(map.size() == 2 && map.containsValue(4)){
			for(Card c : temp){
				if(map.get(c.getRank()) != 4){
					this.cards.remove(c);
					this.cards.addLast(c);
				}
			}
		}
		
		//Full House
		if(map.size() == 2 && map.containsValue(3)){
			for(Card c : temp){
				this.cards.remove(c);
				if(map.get(c.getRank()) == 3){
					
					this.cards.addFirst(c);
				}else{
					this.cards.addLast(c);
				}
			}
		}
		
		//Trips
		if(map.size() == 3 && map.containsValue(3)){
			for(Card c : temp){
				if(map.get(c.getRank()) == 3){
					this.cards.remove(c);
					this.cards.addFirst(c);
				}
			}
		}
		
		//Two Pair
		if(map.size() == 3 && map.containsValue(2)){
			for(Card c : temp){
				if(map.get(c.getRank()) == 1){
					this.cards.remove(c);
					this.cards.addLast(c);
				}
			}
		}
		
		//One Pair
		if(map.size() == 4 && map.containsValue(2)){
			for(Card c : temp){
				if(map.get(c.getRank()) == 2){
					this.cards.remove(c);
					this.cards.addFirst(c);
				}
			}
		}
	}
	
	//Determines if every card in hand has same suit	
	public boolean isFlush(){
		Suit suit = this.cards.getFirst().getSuit();
		boolean isFlush = true;
	
		for(int i=1;i < cards.size();i++) {
			if(cards.get(i).getSuit() != suit){
				isFlush = false;
				break;
			}
		}		
		return isFlush;
	}
	
	//Determines if this hand is a straight
	public boolean isStraight()	{
		boolean isStr = true;
	
		for(int i=0;i<this.cards.size()-1;i++){
			if(this.cards.get(i).compareTo(this.cards.get(i+1)) != 1){
				isStr = false;
				break;
			}
		}
		
		
		if(!(this.cards.getFirst().getRank().toString().equals("Ace") && this.getCards().getLast().getRank().toString().equals("Five")) &&
				((this.cards.getFirst().getRank().ordinal() - this.cards.getLast().getRank().ordinal()) != 4)){
			isStr = false;
		}
		
		return isStr;	
	}
	
	//Assigns a value to a five card hand based on rules of Poker
	public double pokerRank(){
		double value=0;
		HashMap<Rank,Integer> map = countRanks();
		
	//Royal Flush
		if(isStraight() && isFlush() && this.cards.getFirst().getRank().toString().equals("Ace")){
			value=10;
		}
	
	//Straight Flush
		if(isStraight() && isFlush() && this.cards.getFirst().getRank().toString().equals("Ace") == false){	
			value=9+(0.01*this.cards.getLast().getRank().ordinal());
		}
		
	//Quads
		if(map.size() == 2 && map.containsValue(4)){
			value=8+(0.01*this.cards.getFirst().getRank().ordinal())+(0.0001*this.getCards().getLast().getRank().ordinal());
		}
		
	//Full House
		if(map.size() == 2 && map.containsValue(3)){
			value=7+(0.01*this.cards.getFirst().getRank().ordinal())+(0.0001*this.getCards().get(3).getRank().ordinal());
		}
		
	//Flush
		if(isFlush() && !isStraight()){
			value=6+(0.01*this.cards.getFirst().getRank().ordinal());
		}
		
	//Straight
		if(isStraight() && !isFlush()){
			value=5+(0.01*this.cards.getFirst().getRank().ordinal());
		}
		
	//Trips
		if(map.size() == 3 && map.containsValue(3)){
			value=4+(0.01*this.getCards().get(0).getRank().ordinal()) + 
					(0.0001*this.getCards().get(3).getRank().ordinal()) + 
					(0.000001*this.getCards().get(4).getRank().ordinal());
		}
		
	//Two Pair
		if(map.size() == 3 && map.containsValue(2)){
			value=3+(0.01*this.getCards().get(0).getRank().ordinal()) + 
					(0.0001*this.getCards().get(2).getRank().ordinal()) + 
					(0.000001*this.getCards().get(4).getRank().ordinal());
		}
		
	//One Pair
		if(map.size() == 4 && map.containsValue(2)){
			value=2+(0.01*this.getCards().get(0).getRank().ordinal()) + 
					(0.0001*this.getCards().get(2).getRank().ordinal()) + 
					(0.000001*this.getCards().get(3).getRank().ordinal()) + 
					(0.00000001*this.getCards().get(4).getRank().ordinal());
		}
			
	//High card
		if(map.size() == 5 && !isStraight() && !isFlush()){
			value=1+(0.01*this.getCards().get(0).getRank().ordinal()) + 
					(0.0001*this.getCards().get(1).getRank().ordinal()) + 
					(0.000001*this.getCards().get(2).getRank().ordinal()) + 
					(0.00000001*this.getCards().get(3).getRank().ordinal()) +
					(0.0000000001*this.getCards().get(4).getRank().ordinal());
		}
			
		return value;
	}
	
	//Determines best hand out of all possible hands
	public Hand bestHoldemHand(LinkedList<Card> community) {	
		Hand bestHand = null;
		LinkedList<Card> allCards = new LinkedList<Card>();
		allCards.addAll(this.cards);
		allCards.addAll(community);
		
		int[][] combos = MathUtility.combos(7,5);

		for(int i=0;i<combos.length;i++) {
			Card[] cards = new Card[5];
			for(int j=0;j<combos[i].length;j++){
				cards[j] = (Card)allCards.get(combos[i][j]);
			}
			Hand h = new Hand();
			h.addCards(cards);
			
			if(bestHand == null || h.compareTo(bestHand) > 0){
				bestHand = h;
			}
		}
		
		return bestHand;
	}	
	
	public int compareTo(Hand o) {
		return new Double(pokerRank()).compareTo(new Double(o.pokerRank()));
	}
	public String toString(){
		return cards.toString(); 
	}
}
