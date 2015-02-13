package joejava.poker.bean;


public class Player {
	private Hand hand;
	private short chips; 
	private short currentBet;
	private boolean isDealer;
	private boolean inHand;
	private boolean goodToGo;
	private int seatNumber;
	private String username;
	
	public Player(){}
	
	public Player(String username, boolean inHand){
		this.username = username;
		this.inHand = inHand;
	}
	
	public Hand getHand() {
		return hand;
	}
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	public short getChips() {
		return chips;
	}
	public void setChips(short chips) {
		this.chips = chips;
	}
	public boolean isDealer() {
		return isDealer;
	}
	public void setDealer(boolean isDealer) {
		this.isDealer = isDealer;
	}
	public void setInHand(boolean inHand) {
		this.inHand = inHand;
	}
	public boolean isInHand() {
		return inHand;
	}
	public void setCurrentBet(short currentBet) {
		this.currentBet = currentBet;
	}
	public short getCurrentBet() {
		return currentBet;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setGoodToGo(boolean goodToGo) {
		this.goodToGo = goodToGo;
	}
	public boolean isGoodToGo() {
		return goodToGo;
	}
}
