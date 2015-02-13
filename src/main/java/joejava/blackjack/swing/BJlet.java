package joejava.blackjack.swing;
// Blackjack.java
//
//Applet to play blackjack against a computer (should include an option to do BasicTraining)

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.Arrays;

import joejava.blackjack.Blackjack;
 
public class BJlet extends JApplet{

	Container c;
	
	public void init(){
		c=getContentPane();
		setSize(800,500);
		c.add(new Blackjack());
	}
		
}	