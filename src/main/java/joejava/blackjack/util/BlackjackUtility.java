package joejava.blackjack.util;

import joejava.blackjack.bean.BJHand;

import java.sql.SQLException;

public class BlackjackUtility {
	
	public static void main(String[] args) throws SQLException{
		
		//LinkedList<String> deck = PokerUtility.shuffleList(PokerUtility.Deck);
//		String[] d = {"5s","5h","Js","4c","Ac","7d","Jc","10s","10s","Jh","10s","10c","10d","Qh","Kc","Js","6d","6h","6c","6s","7d","7h","7c","7s","8d","8h","8c","8s","9h","9d","9c","9s","10d","10h","10c","10s","Jd","Jh","Jc","Js","Qd","Qh","Qc","Qs","Kd","Kh","Kc","Ks","Ad","Ah","Ac","As"};
//		LinkedList<String> deck = new LinkedList<String>(Arrays.asList(d));
//
//		LinkedList<String> cards = new LinkedList<String>();
//		cards.add(deck.remove());
//		cards.add(deck.remove());
//		BJHand h = new BJHand(cards,10,"");
//
//		LinkedList<BJHand> hands = new LinkedList<BJHand>();
//		hands.add(h);
//
//		House house = new House();
//		house.hit(deck.remove());
//		house.hit(deck.remove());
//
//		HandNode tree = new HandNode(hands,deck,"",0);
//		tree.createTree();
//
//		for(Showdown s : tree.showdowns){
//			Integer showId = (Integer)DAO.client.queryForObject("getNextBJHandId",null);
//			s.processDealer(showId,house,deck);
//		}
	}
	
	//Takes the BJValue of a blackjack hand
	public static String BJValue(BJHand hand){
		int[] bjValue = hand.getBjValue();
		StringBuffer sb = new StringBuffer();

		for(int i=0;i<bjValue.length;i++){
			sb.append(bjValue[i] + ",");
		}
	
		sb.delete(sb.length()-1, sb.length());
		return sb.toString();
	}
	
	/*
	public static String getBasic(Hand hand,String House) {
		String[] Hand = new String[hand.cards.size()];
		Hand=hand.cards.toArray(Hand);
		int numCards = Hand.length;
		String Decision = null;
		boolean DD = true;
		boolean noSplit = false;
		int[] BJ = BJValue(hand.cards);
			
		if(numCards > 2){
			DD = false;
		}
		//FOR SPLITS//
		if(isSplit(hand)==true && noSplit == false)	{
			if(Hand[0].charAt(0)=='A' || Hand[0].charAt(0)=='8')			//Start w/ Aces or 8s
			Decision="Split";
			if(Hand[0].charAt(0)=='K' || Hand[0].charAt(0)=='Q' || Hand[0].charAt(0)=='J' || Hand[0].charAt(0)=='1')  //Start with 20
			Decision="Stand";
			if(Hand[0].charAt(0)=='9' && (House.charAt(0)=='7' || Rank(House)>9))  //Nines
			Decision="Stand";
			if(Hand[0].charAt(0)=='9' && (Rank(House)<7 || Rank(House)==8 || Rank(House)==9))
			Decision="Split";
			if(Hand[0].charAt(0)=='7' && Rank(House)<8)		//Sevens
			Decision="Split";
			if(Hand[0].charAt(0)=='7' && Rank(House)>7)
			Decision="Hit";
			if(Hand[0].charAt(0)=='6' && Rank(House)<7)		//Sixes
			Decision="Split";		
			if(Hand[0].charAt(0)=='6' && Rank(House)>6)
			Decision="Hit";
			if(Hand[0].charAt(0)=='5' && Rank(House)<10)		//Fives
			Decision="Double Down";
			if(Hand[0].charAt(0)=='5' && Rank(House)>9)
			Decision="Hit";
			if(Hand[0].charAt(0)=='4' && (Rank(House)<5 || Rank(House)>6))		//Fours
			Decision="Hit";
			if(Hand[0].charAt(0)=='4' && (Rank(House)==5 || Rank(House)==6))
			Decision="Split";
			if((Hand[0].charAt(0)=='3' || Hand[0].charAt(0)=='2') && Rank(House)<8)		//Threes or Twos
			Decision="Split";
			if((Hand[0].charAt(0)=='3' || Hand[0].charAt(0)=='2') && Rank(House)>7)		//Threes or Twos
			Decision="Hit";
		}	
		//FOR HARD, NON-SPLITTABLE HANDS//
		if((BJ.length==1 && Rank(Hand[0])!= Rank(Hand[1])) 
				|| numCards>2 || (isSplit(hand)==true && noSplit==true)) {
			
			if(BJ[0]<9)
			Decision="Hit";
			if(BJ[0]>16)
			Decision="Stand";
			if((BJ[0]<17 && BJ[0]>12) && Rank(House)<7)
			Decision="Stand";
			if((BJ[0]<17 && BJ[0]>12) && Rank(House)>6)
			Decision="Hit";
			if(BJ[0]==12 && (Rank(House)<4 || Rank(House)>6))
			Decision="Hit";
			if(BJ[0]==12 && (Rank(House)==4 || Rank(House)==5 || Rank(House)==6))
			Decision="Stand";		
			if(BJ[0]==11 && Rank(House)<14) {		// anything less than an ace
			
				if(DD==true)
				Decision="Double Down";
				else
				Decision="Hit";
			}
			if(BJ[0]==11 && House.charAt(0)=='A')
			Decision="Hit";
			if(BJ[0]==10 && Rank(House)<10) {
				if(DD==true)
				Decision="Double Down";
				else
				Decision="Hit";
			}
			if(BJ[0]==10 && Rank(House)>9)
			Decision="Hit";				
			if(BJ[0]==9 && (House.charAt(0)=='2' || Rank(House)>6))
			Decision="Hit";
			if(BJ[0]==9 && Rank(House)>2 && Rank(House)<7) {
				if(DD==true)
				Decision="Double Down";
				else
				Decision="Hit";
			}	
		}
		//SOFT HANDS//
		if(BJ.length==2 && Hand[0].charAt(0)!=Hand[1].charAt(0))	{
			if(BJ[1]>18)
			Decision="Stand";
			if(BJ[1]==18 && Rank(House)>8)
			Decision="Hit";
			if(BJ[1]==18 && (House.charAt(0)=='2' || House.charAt(0)=='7' || House.charAt(0)=='8'))
			Decision="Stand";
			if(BJ[1]==18 && House.charAt(0)>'2' && House.charAt(0)<'7')	{
				if(DD==true)
				Decision="Double Down";
				else
				Decision="Stand";
			}
			if(BJ[1]==17 && (House.charAt(0)=='2' || Rank(House)>6))
			Decision="Hit";
			if(BJ[1]==17 && House.charAt(0)>'2' && House.charAt(0)<'7')	{
				if(DD==true)
				Decision="Double Down";
				else
				Decision="Hit";
			}
			if((BJ[1]==16 || BJ[1]==15) && (Rank(House)<4 || Rank(House)>6))
			Decision="Hit";
			if((BJ[1]==16 || BJ[1]==15) && Rank(House)>3 && Rank(House)<7)	{
				if(DD==true)
				Decision="Double Down";
				else
				Decision="Hit";
			}		
			if((BJ[1]==14 || BJ[1]==13) && (Rank(House)<5 || Rank(House)>6))
			Decision="Hit";
			if((BJ[1]==14 || BJ[1]==13) && Rank(House)>4 && Rank(House)<7)	{
				if(DD==true)
				Decision="Double Down";
				else
				Decision="Hit";
			}		
		}
	
		return Decision;	
	}
	*/
}
