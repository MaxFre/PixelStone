package hearthstone;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Gui extends JPanel {
	ArrayList<Card> playerOne = new ArrayList<Card>();
	private JTextArea score = new JTextArea(" Score: 0");
	private JLabel testar = new JLabel("ttest");
	Controller controller;
	
	public Gui(Controller controller) {
	this.controller = controller;	

//		JFrame frame = new JFrame("Spel");
//
//		frame.setSize(800, 620);
////		frame.add(buildUI());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setResizable(false);
//		frame.setLocation(553, 123);
		
//		fetchCards();
		buildUI();
	}
	
	public void fetchCards(){
		playerOne = controller.getPlayerOneCards();
		System.out.println(playerOne.get(0).getName());
	}
	
	public void buildUI(){
		setLayout(null);
		setPreferredSize(new Dimension(1000, 420));
		
		score.setBounds(700, 330, 150, 50);
		testar.setBounds(400, 130, 150, 50);
		add(score);
		
		add(testar);
		
	}
	
	public void theCards(ArrayList<Card> cards){
		System.out.println("här??");
		playerOne = cards;
		Icon icon = new ImageIcon("images/bub.png");
		
		System.out.println("image - " + playerOne.get(1).getImage());
		testar.setIcon(icon);
		add(testar);
//		 Icon test = new Icon(playerOne.get(0).getImage());
//		 ImageIcon myPicture = playerOne.get(0).getImage();
//		 JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//		 add(picLabel);
		
//		ImageIcon image = new ImageIcon(playerOne.get(0).getImage());
	}
}
