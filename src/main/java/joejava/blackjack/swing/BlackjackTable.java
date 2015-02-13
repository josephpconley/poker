package joejava.blackjack.swing;

import joejava.blackjack.Blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlackjackTable extends JPanel{
	public JCheckBox basic;
	
	public JButton hit;
	public JButton split;
	public JButton stand;
	public JButton dd;
	public JButton yes;
	public JButton no;
	
	public JLabel restart;
	public JLabel wrongMove;
	public JLabel scoreLabel;
	
	public JPanel begin; 
	public JPanel dealer;
	public JPanel opts; 
	public JPanel win; 
	public JPanel end;
	
	public BlackjackTable(JComponent parent){
		setBackground(PokerSwing.felt);
		setLayout(new BorderLayout());
		
		hit=new JButton("Hit");	hit.addActionListener((ActionListener) parent); hit.setMnemonic('H');
		stand=new JButton("Stand");	stand.addActionListener((ActionListener) parent);			stand.setMnemonic('S');
		split=new JButton("Split");	split.addActionListener((ActionListener) parent);		split.setMnemonic('P');
		dd =new JButton("Double Down");		dd.addActionListener((ActionListener) parent);			dd.setMnemonic('D');
		yes=new JButton("Yes");		yes.addActionListener((ActionListener) parent);		yes.setMnemonic('Y');
		no=new JButton("No");		no.addActionListener((ActionListener) parent);		no.setMnemonic('N');
		
		
		wrongMove=new JLabel("Wrong move!"); wrongMove.setForeground(Color.red);	wrongMove.setFont(new Font("Verdana",Font.BOLD,18));
			
		//GridLayout to get same size
		

		opts = new JPanel();
		basic = new JCheckBox("Basic Training");
		basic.setSelected(false);
		opts.setVisible(false);
		
		//adds all possible moves	
		opts.setLayout(new BoxLayout(opts,BoxLayout.Y_AXIS));
		opts.add(dd);
		opts.add(split);
		opts.add(stand);
		opts.add(hit);
		opts.add(basic);
		opts.setBackground(PokerSwing.felt);
		
		add(BorderLayout.EAST,opts);
		
		hit.requestFocusInWindow();
		stand.requestFocusInWindow();
		split.requestFocusInWindow();
		dd.requestFocusInWindow();
		yes.requestFocusInWindow();
		no.requestFocusInWindow();
	}
}
