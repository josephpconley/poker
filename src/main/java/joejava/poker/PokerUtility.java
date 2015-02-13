package joejava.poker;

//Various methods for poker situations

public class PokerUtility{

	public static String[] deck = {"2d","2h","2c","2s","3d","3h","3c","3s","4d","4h","4c","4s","5d","5h","5c","5s","6d","6h","6c","6s","7d","7h","7c","7s","8d","8h","8c","8s","9h","9d","9c","9s","10d","10h","10c","10s","Jd","Jh","Jc","Js","Qd","Qh","Qc","Qs","Kd","Kh","Kc","Ks","Ad","Ah","Ac","As"};
	
//	public static String[] shoe(int ndecks){
//		String[] shoe = new String[ndecks*52];
//		String[] D = new String[52];
//		int index=0;
//
//		for(int i=0;i<ndecks;i++){
//			D = shuffle(deck);
//
//			for(int j=0;j<52;j++){
//				shoe[index]=D[j];
//				index++;
//			}
//		}
//		return shoe;
//	}

//Genereates the odds of a given set of hold 'em hands	(must know status of hand(preflop,flop,etc.))
//	public static double[] preFlopOdds(String[][] Players) {
//
//		int nPlayers = Players.length;
//		double[] scores = new double[nPlayers+1];
//		int count=0;
//
//		for(int k=0;k<nPlayers+1;k++){
//			scores[k]=0;
//		}
//
//		int trials=3000;
//		String[] origdeck = deck;
//
//		while(count < trials) {
//			count++;
//			Collections.shuffle(Arrays.asList(origdeck));
//
//			for(int i=0;i<nPlayers;i++){
//				deck = MathUtility.subtractArray(deck,Players[i]);
//			}
//
//			String[] Community = Dealer(5,deck,0);
//			String[][] hand = new String[nPlayers][7];
//
//			for(int x=0;x<nPlayers;x++) {
//				for(int y=0;y<7;y++){
//					if(y < 2){
//						hand[x][y]=Players[x][y];
//					}else{
//						hand[x][y]=Community[y-2];
//					}
//				}
//			}
//
//			String[][] winner= winner(hand);
//
//			if(winner.length>1){
//				scores[nPlayers]++;
//			}else{
//				int index=0;
//				boolean done=false;
//
//				while(done==false) {
//					if(MathUtility.isMember(Players[index][0],winner[0])==true || MathUtility.isMember(Players[index][1],winner[0])==true) {
//						scores[index]++;
//						done=true;
//					}else{
//						index++;
//					}
//				}
//			}
//		}
//
//		for(int m=0;m<nPlayers+1;m++)
//		scores[m]=scores[m]/trials;
//
//		return scores;
//	}
}