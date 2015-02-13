package joejava.poker.bean;

public class Card implements Comparable<Card> {
	
    public enum Rank{
    	Two("2",2), Three("3",3), Four("4",4), Five("5",5), Six("6",6), Seven("7",7), 
    	Eight("8",8), Nine("9",9), Ten("10",10), Jack("J",10), Queen("Q",10), King("K",10), Ace("A",11);
    	
    	private final String rank;
    	private final int bjRank;
    	
    	Rank(String rank, int bjRank){
    		this.rank = rank;
    		this.bjRank = bjRank;
    	}
    	public String rank(){
    		return rank;
    	}
		public int getBjRank() {
			return bjRank;
		}
    }

    public enum Suit{ 
    	Spades("s"), Hearts("h"), Diamonds("d"), Clubs("c"); 
    	
    	private final String suit;
    	Suit(String suit){
    		this.suit = suit;
    	}
    	public String suit(){
    		return suit;
    	}
    }	

    private final Rank rank;
    private final Suit suit;
    
	
	public Card(Rank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public String toString(){
		return this.getRank().rank() + this.getSuit().suit();
	}

	public int compareTo(Card card){
		return this.rank.compareTo(card.getRank());
	}
}
