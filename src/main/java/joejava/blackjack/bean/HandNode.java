package joejava.blackjack.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import joejava.blackjack.util.BlackjackUtility;
import joejava.poker.bean.Card;

public class HandNode {
	
	public LinkedList<Card> deck;
	public LinkedList<BJHand> hands;
	private int num;
	public String decision;
	public static ArrayList<Showdown> showdowns = new ArrayList<Showdown>();

//	public HandNode(LinkedList<BJHand> hands, LinkedList<String> deck, String decision, int num){
//		this.deck = deck;
//		this.num = num;
//		this.decision = decision;
//		this.hands = new LinkedList<BJHand>();
//
//		for(BJHand h : hands){
//			this.hands.add(new BJHand(h.getCards(),h.getBet(),h.getDecision()));
//		}
//	}
//
//	public void createTree(){
//		if(hands.get(num).getAbsBjValue() < 21){
//			addStand(this.num);
//			if(hands.get(this.num).getCards().size() == 2){
//				addDoubleDown(this.num);
//			}
//			addHit(this.num);
//			if(hands.get(this.num).isSplit()){
//				addSplit(this.num);
//			}
//		}else if(hands.get(this.num).getAbsBjValue() == 21){
//			addStand(this.num);
//		}
//	}
//
//	public void addStand(int num){
//		LinkedList<String> d1 = new LinkedList<String>();
//		LinkedList<BJHand> h1 = new LinkedList<BJHand>();
//		String decision;
//		HandNode n1;
//
//		d1.addAll(this.deck);
//		for(BJHand h : this.hands){
//			h1.add(new BJHand(h.getCards(),h.getBet(),h.getDecision()));
//		}
//		h1.get(num).setDecision(new StringBuffer(h1.get(num).getDecision()).append("S").toString());
//		decision = new StringBuffer(this.decision).append("S").toString();
//		n1 = new HandNode(h1,d1,decision,num);
//
//		if(num > 0){
//			num--;
//			h1.get(num).hit(d1.remove());
//			n1 = new HandNode(h1,d1,decision,num);
//			n1.createTree();
//		}else{
//			showdowns.add(new Showdown(n1));
//		}
//	}
//
//	public void addDoubleDown(int num){
//		LinkedList<Card> d1 = new LinkedList<Card>();
//		LinkedList<BJHand> h1 = new LinkedList<BJHand>();
//		String decision;
//		HandNode n1;
//
//		d1.addAll(this.deck);
//		for(BJHand h : this.hands){
//			h1.add(new BJHand(h.getCards(),h.getBet(),h.getDecision()));
//		}
//		h1.get(num).doubleDown(d1.remove());
//		h1.get(num).setDecision(new StringBuffer(h1.get(num).getDecision()).append("D").toString());
//		decision = new StringBuffer(this.decision).append("D").toString();
//		n1 = new HandNode(h1,d1,decision,num);
//
//		if(num > 0){
//			num--;
//			h1.get(num).hit(d1.remove());
//			n1 = new HandNode(h1,d1,decision,num);
//			n1.createTree();
//		}else{
//			showdowns.add(new Showdown(n1));
//		}
//	}
//
//	public void addHit(int num){
//		LinkedList<String> d1 = new LinkedList<String>();
//		LinkedList<BJHand> h1 = new LinkedList<BJHand>();
//		String decision;
//		HandNode n1;
//
//		d1.addAll(this.deck);
//		for(BJHand h : this.hands){
//			h1.add(new BJHand(h.getCards(),h.getBet(),h.getDecision()));
//		}
//		h1.get(num).hit(d1.remove());
//		h1.get(num).setDecision(new StringBuffer(h1.get(num).getDecision()).append("H").toString());
//		decision = new StringBuffer(this.decision).append("H").toString();
//		n1 = new HandNode(h1,d1,decision,num);
//
//		if(h1.get(num).getAbsBjValue() < 21){
//			n1.createTree();
//		}else{
//			if(num > 0){
//				num--;
//				h1.get(num).hit(d1.remove());
//				n1 = new HandNode(h1,d1,decision,num);
//				n1.createTree();
//			}else{
//				showdowns.add(new Showdown(n1));
//			}
//		}
//	}
//
//	public void addSplit(int num){
//		LinkedList<String> d1 = new LinkedList<String>();
//		LinkedList<BJHand> h = new LinkedList<BJHand>();
//		String decision = new StringBuffer(this.decision).append("P").toString();
//
//		d1.addAll(this.deck);
//		BJHand h1 = new BJHand();
//		h1.hit(hands.get(num).getCards().getFirst());
//
//		BJHand h2 = new BJHand();
//		h2.hit(hands.get(num).getCards().getLast());
//		h2.hit(d1.remove());
//
//		for(int i=0;i<hands.size();i++){
//			if(i == num){
//				h.add(h1);
//				h.add(h2);
//			}else{
//				h.add(hands.get(i));
//			}
//		}
//		num++;
//
//		HandNode n1 = new HandNode(h,d1,decision,num);
//		n1.createTree();
//	}
//
//	public void printNode(){
//		for(Showdown s : showdowns){
//			System.out.println(s.toString());
//		}
//	}
}
