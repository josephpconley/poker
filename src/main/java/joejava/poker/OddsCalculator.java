package joejava.poker;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

import joejava.blackjack.swing.PokerSwing;


//Basic Texas Hold 'em Calculator
public class OddsCalculator extends JPanel {
//    implements ActionListener,MouseListener{
	JPanel[] players;
	JPanel suits,ranks;
	JLabel[][] handLbls;
	JLabel[] oddLbl;
	String[][] hands;
	int[] ID = new int[2];
	double[] odds;
	Cursor hand = new Cursor(Cursor.HAND_CURSOR);
	Cursor norm = new Cursor(Cursor.DEFAULT_CURSOR);	
	JDialog card;
	JButton apply,calc;
	JLabel pick = new JLabel();
	String pickRank=null,pickSuit=null,pickCard;
	int num,count;
	
	
//	public OddsCalculator(int num){
//		this.num=num;
//		hands=new String[num][2];
//		loadTable(false);
//	}
//
//	public OddsCalculator(String[][] hands){
//		this.hands=hands;
//		num=hands.length;
//		loadTable(true);
//		add(calc);
//		validate();
//	}
//	public void loadTable(boolean hand){
//		setBackground(PokerSwing.felt);
//		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
//		apply=new JButton("Apply");		apply.addActionListener(this);
//		calc=new JButton("Pre-flop odds");	calc.addActionListener(this);
//
//		players=new JPanel[num];
//		handLbls=new JLabel[num][2];
//		odds=new double[num+1];
//		oddLbl=new JLabel[num+1];
//		for(int i=0;i<num;i++){
//			players[i] = new JPanel();
//			players[i].setLayout(new BoxLayout(players[i],BoxLayout.LINE_AXIS));
//			players[i].add(new JLabel("Hand "+(i+1)+" : "));
//
//			if(hand==false)
//			hands[i]=new String[2];
//
//			for(int j=0;j<2;j++){
//					if(hand==false)
//						handLbls[i][j]=PokerSwing.getCard("back");
//					else
//						handLbls[i][j]=PokerSwing.getCard(hands[i][j]);
//				handLbls[i][j].addMouseListener(this);
//				players[i].add(handLbls[i][j]);
//			}
//			add(players[i]);
//		}
//
//		card=new JDialog();
//		card.setLayout(new FlowLayout());
//		card.setSize(400,200);
//		card.setTitle("Pick a card, any card");
//
//		suits=new JPanel(new GridLayout(2,2));
//			for(int i=0;i<PokerSwing.suits.length;i++){
//				suits.add(PokerSwing.suits[i]);
//				PokerSwing.suits[i].addActionListener(this);
//			}
//		ranks=new JPanel();
//		GridLayout grid = new GridLayout(4,4);
//		grid.setHgap(10);
//		grid.setVgap(5);
//		ranks.setLayout(grid);
//
//			for(int i=0;i<PokerSwing.ranks.length;i++){
//				ranks.add(PokerSwing.ranks[i]);
//				PokerSwing.ranks[i].addActionListener(this);
//			}
//		card.add(suits); card.add(ranks);card.add(apply); card.add(pick);
//
//		update();
//	}
//
//	public void update(){
//		removeAll();
//
//		for(int i=0;i<num;i++){
//			players[i].removeAll();
//			players[i].add(new JLabel("Hand "+(i+1)+" : "));
//			oddLbl[i]=new JLabel(Double.toString(odds[i]));
//			for(int j=0;j<2;j++){
//				players[i].add(handLbls[i][j]);
//			}
//			players[i].add(oddLbl[i]);
//			add(players[i]);
//		}
//		validate();
//	}
//
//	public void actionPerformed(ActionEvent evt){
//
//		if(evt.getActionCommand().isEmpty()){
//			for(int i=0;i<4;i++){
//				if(evt.getSource()==PokerSwing.suits[i])
//					pickSuit=PokerSwing.suits[i].getName().substring(0,1);
//			}
//		}
//		else{
//			if(evt.getSource()!=apply)
//				pickRank=evt.getActionCommand();
//		}
//		pickCard=pickRank+pickSuit;
//		pick.setText(pickCard);
//
//		if(evt.getSource()==apply){
//			if(pickRank==null || pickSuit==null)
//				JOptionPane.showMessageDialog(this,"Pick a card dirtbag!");
//			else{
//				System.out.println(pickCard);
//				handLbls[ID[0]][ID[1]]=PokerSwing.getCard(pickCard);
//				hands[ID[0]][ID[1]]=pickCard;
//				count++;
//				update();
//				card.setVisible(false);
//				validate();
//			}
//		}
//
//		if(count==(num*2)){
//			add(calc);
//			validate();
//		}
//		if(evt.getSource()==calc){
//            //TODO restore me!
////			odds=PokerUtility.preFlopOdds(hands);
//			for(int i=0;i<num;i++){
//				System.out.println(Double.toString(odds[i]));
//				oddLbl[i].setText(Double.toString(odds[i]));
//			}
//			update();
//		}
//	}
//
//	public void mousePressed(MouseEvent evt){}
//	public void mouseClicked(MouseEvent evt){
//		setCursor(norm);
//		pickCard=null;
//		card.setVisible(true);
//		validate();
//
//		for(int i=0;i<num;i++){
//			for(int j=0;j<2;j++){
//				if(evt.getSource()==handLbls[i][j]){
//					ID[0]=i;
//					ID[1]=j;
//				}
//			}
//		}
//	}
//	public void mouseReleased(MouseEvent evt){}
//	public void mouseEntered(MouseEvent evt){
//		setCursor(hand);
//	}
// 	public void mouseExited(MouseEvent evt){
//	 	setCursor(norm);
//	}
}