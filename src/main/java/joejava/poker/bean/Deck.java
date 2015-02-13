package joejava.poker.bean;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.StringBuilder;

import joejava.poker.bean.Card.Rank;
import joejava.poker.bean.Card.Suit;

public class Deck {
	
	private LinkedList<Card> cards;
	
	public Deck(int n){
		this.cards = new LinkedList<Card>();
		for(int i=0;i<n;i++){
			for(Suit suit : Suit.values()){
				for (Rank rank : Rank.values()){
					cards.add(new Card(rank, suit));
				}
			}
		}
		shuffle();
	}
	
	public Card deal(){
		return cards.remove();
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public String toString(){
		StringBuilder deckStringBuilder = new StringBuilder();
		/*
		deckStringBuilder.append("Deck Size: " +
				deck.size());
		/*IF we don't want the whole deck to print out
		 * then we can just print out the size.
		 */
		Card card;
		Iterator<Card> iterator = cards.iterator();
		while (iterator.hasNext())
		{
			card = iterator.next();
			deckStringBuilder.append(card.toString());
			deckStringBuilder.append(",");
		}
		return deckStringBuilder.toString();
	}
}
