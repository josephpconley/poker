package joejava.blackjack.bean;

import java.util.LinkedList;

public class Player {

	public LinkedList<BJHand> hands;
	public double score;	
	public int currentHand;
	
	public LinkedList<BJHand> getHands() {
		return hands;
	}
	public void setHand(LinkedList<BJHand> hands) {
		this.hands = hands;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	public Player(double score){
		this.score=score;
		hands = new LinkedList<BJHand>();
	}
	
	public boolean allBust(){
		for(BJHand hand : hands){
			if(hand.getAbsBjValue() < 22){
				return false;
			}
		}
		return true;
	}
	
	public BJHand getCurrentHand(){
		return hands.get(currentHand);
	}
	
	public void showdown(House house){
		for(BJHand hand : hands){
			score = score + hand.showdown(house);
		}
		hands.clear();
	}
}
