package hearthstone;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class main {
	Deck deck;
	Controller controller;
	
	public main(){
		
//		deck = new Deck();
//		controller = new Controller(controller);
	}
	
	

	public static void main(String[]args){
//		Deck run = new Deck();
		Controller run = new Controller();
		Gui view = new Gui(run);
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(1800,850));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.pack();
		frame.add(view);
		frame.setLocation(100, 123);
		frame.setVisible(true);			
		
	}
}
