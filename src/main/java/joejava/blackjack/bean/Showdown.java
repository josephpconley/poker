package joejava.blackjack.bean;

import java.util.List;

public class Showdown {
	
	private int showId;
	private List<BJHand> hands;
	private String house;
	private String decision;
	
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public List<BJHand> getHands() {
		return hands;
	}
	public void setHands(List<BJHand> hands) {
		this.hands = hands;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public Showdown(){}
	
	public Showdown(HandNode n){
		this.hands = n.hands;
		this.decision = n.decision;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(BJHand h : hands){
			sb.append(h.toString() + " " + "("+h.getBet()+") ");
		}
		sb.append(decision);
		return sb.toString();
	}
	
//	public void processDealer(Integer showId, House house, LinkedList<String> deck) throws SQLException{
//		LinkedList<String> d = new LinkedList<String>();
//		d.addAll(deck);
//		House h = new House(house.getCards());
//
//		System.out.println(h.toString());
//		int index = 0;
//		for(BJHand n : this.hands){
//			index += n.getCards().size();
//		}
//
//		while(h.getAbsBjValue() < 17){
//			h.hit(d.get(index));
//			index++;
//		}
//		System.out.println(h.toString());
//
//		Showdown evt = new Showdown();
//		evt.setShowId(showId);
//		evt.setHouse(house.getCards().getFirst().toString());
//		evt.setDecision(this.decision);
//		DAO.client.insert("insertShowdown", evt);
//
//		int i = 0;
//		for(BJHand n : this.hands){
//			n.setShowId(showId);
//			n.setHandId(i);
//			n.setHandStr(n.toString());
//			n.setHouse(evt.getHouse());
//			n.setProfit(n.showdown(h));
//
//			DAO.client.insert("insertHand",n);
//			i++;
//		}
//	}
}
