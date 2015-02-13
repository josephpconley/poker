package joejava.blackjack.bean;

import java.util.LinkedList;

import joejava.blackjack.util.BlackjackUtility;
import joejava.poker.bean.Card;
import joejava.poker.bean.Hand;
import joejava.util.MathUtility;

//BJHand.java
//
//Creates a hand of Blackjack to be played against the house (a BJhouse)

public class BJHand extends Hand{

	public LinkedList<Card> cards = new LinkedList<Card>();
	private double bet;
	public int[] bjValue;
	private int absBjValue;
	
	//For database
	private int showId;
	private int handId;
	private String handStr;
	private String handSoft;
	private String handHard;
	private String house;
	private String decision;
	private double profit;
	
	public LinkedList<Card> getCards() {
		return cards;
	}
	public void setCards(LinkedList<Card> cards) {
		this.cards = cards;
	}
	public double getBet() {
		return bet;
	}
	public void setBet(double bet) {
		this.bet = bet;
	}
	public int[] getBjValue() {
		return bjValue;
	}
	public void setBjValue(int[] bjValue) {
		this.bjValue = bjValue;
	}
	public int getAbsBjValue() {
		return absBjValue;
	}
	public void setAbsBjValue(int absBjValue) {
		this.absBjValue = absBjValue;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getHandId() {
		return handId;
	}
	public void setHandId(int handId) {
		this.handId = handId;
	}
	public String getHandStr() {
		return handStr;
	}
	public void setHandStr(String handStr) {
		this.handStr = handStr;
	}
	public String getHandSoft() {
		return handSoft;
	}
	public void setHandSoft(String handSoft) {
		this.handSoft = handSoft;
	}
	public String getHandHard() {
		return handHard;
	}
	public void setHandHard(String handHard) {
		this.handHard = handHard;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	public BJHand(){
		bet = 10;
		bjValue = new int[2];
		absBjValue = 0;
		decision = "";
	}
	
	public BJHand(LinkedList<Card> cards, double bet, String decision){
		this.bet = bet;
		bjValue = new int[2];
		absBjValue = 0;
		
		for(Card card : cards){
			this.hit(card);
		}
		
		setDecision(decision);
		refresh();
	}
	
	public void doubleDown(Card card){
		cards.add(card);
		this.bet *= 2;
		refresh();
	}
	
	public void hit(Card card){
		cards.add(card);
		refresh();
	}
	
	public void remove(int index){
		cards.remove(index);
		refresh();
	}
	
	public void refresh(){
		handHard = Integer.toString(absBjValue);
			
		if(bjValue.length == 2){
			handSoft = "A," + (bjValue[0] - 1);
		}else{
			handSoft = null;
		}
	}
	
	public double showdown(House house){
		System.out.println(this.toString() + " " + house.toString());
		if(this.absBjValue > 21 || (this.absBjValue < house.getAbsBjValue() && house.getAbsBjValue() < 22)){
			return -1 * this.bet;
		}else if(this.absBjValue == house.getAbsBjValue()){
			return 0;
		}
		return this.bet;
	}
	
	//Takes the BJValue of a blackjack hand
	public static int[] BJValue(){
		int[] score = new int[1];		
		int[] ace = {1,11};
		int hard;

		return score;
	}
	
	//Used for Blackjack, should receive a 2 card hand as an argument
	public boolean isSplit() {
		boolean split=false;
		if(this.getCards().get(0).getRank().ordinal() == this.getCards().get(1).getRank().ordinal()
												      && this.getCards().size() == 2){
			return true;
		}else{
			return false;
		}
	}
	
	//Returns "absolute value" (greater of 2 if soft) of the int[] of a BJValue
	public static int abs() {
		int hBJ=0;
		return hBJ;
	}
	
	public String toString(){
		String handStr = "";
		for(int i=0;i<cards.size()-1;i++){
		}
		return handStr;
	}
}