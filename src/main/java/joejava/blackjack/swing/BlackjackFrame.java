package joejava.blackjack.swing;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.net.URL;

import joejava.blackjack.Blackjack;

public class BlackjackFrame extends JFrame {

	public static void main (String[] args){
		new BlackjackFrame();
	}
	
	public BlackjackFrame(){
		setSize (800, 500);
		setLocationRelativeTo(null);
		setVisible (true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Blackjack");
		
		Container c = getContentPane();
		JScrollPane pane = new JScrollPane(new Blackjack());
		c.add(pane);
		c.validate();
	}
}
