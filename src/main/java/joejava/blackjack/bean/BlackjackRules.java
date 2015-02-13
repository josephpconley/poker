package joejava.blackjack.bean;

public class BlackjackRules {
	private boolean standSoft17;
	private boolean doubleAfterSplit;
	private boolean dealerPeeks;
	private String surrender;
	private int numDecks;
	
	public boolean isStandSoft17() {
		return standSoft17;
	}
	public void setStandSoft17(boolean standSoft17) {
		this.standSoft17 = standSoft17;
	}
	public boolean isDoubleAfterSplit() {
		return doubleAfterSplit;
	}
	public void setDoubleAfterSplit(boolean doubleAfterSplit) {
		this.doubleAfterSplit = doubleAfterSplit;
	}
	public boolean isDealerPeeks() {
		return dealerPeeks;
	}
	public void setDealerPeeks(boolean dealerPeeks) {
		this.dealerPeeks = dealerPeeks;
	}
	public String getSurrender() {
		return surrender;
	}
	public void setSurrender(String surrender) {
		this.surrender = surrender;
	}
	public int getNumDecks() {
		return numDecks;
	}
	public void setNumDecks(int numDecks) {
		this.numDecks = numDecks;
	}
	
	
}
