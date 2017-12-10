package hearthstone;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Gui extends JFrame implements ActionListener {
	summonControll summonControll;
	fightControll fightController;
	ArrayList<Card> newCards = new ArrayList<Card>();
	ArrayList<Card> cardsOnHand = new ArrayList<Card>();
	ArrayList<Card> cardsOnField = new ArrayList<Card>();
	ArrayList<Card> enemyCardsOnField = new ArrayList<Card>();
	
	private JLabel deckCards = new JLabel("");
	private JLabel manaLeft = new JLabel("Mana left this turn:");
	
//	private JLabel line = new JLabel("----------------------------------------------------------------"
//			+ "-----------------------------------------------------------------------------------------------------------------------------------------"
//			+ "-----------------------------------------------------------------------------------------------------------------------------------------"
//			+ "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	
	private JLabel playerName1 = new JLabel("Your Turn");
	private JLabel playerName2 = new JLabel("Opponents Turn");
	
	private JLabel slot1 = new JLabel("");
	private JLabel slot2 = new JLabel("");
	private JLabel slot3 = new JLabel("");
	private JLabel slot4 = new JLabel("");
	private JLabel slot5 = new JLabel("");
	
	private JLabel enemyCard1 = new JLabel("");
	private JLabel enemyCard2 = new JLabel("");
	private JLabel enemyCard3 = new JLabel("");
	private JLabel enemyCard4 = new JLabel("");
	private JLabel enemyCard5 = new JLabel("");
	
	private JLabel enemybattlePlace1 = new JLabel("");
	private JLabel enemybattlePlace2 = new JLabel("");
	private JLabel enemybattlePlace3 = new JLabel("");
	private JLabel enemybattlePlace4 = new JLabel("");
	private JLabel enemybattlePlace5 = new JLabel("");
	
	private JLabel enemybattlePlace1Atk = new JLabel("");
	private JLabel enemybattlePlace2Atk = new JLabel("");
	private JLabel enemybattlePlace3Atk = new JLabel("");
	private JLabel enemybattlePlace4Atk = new JLabel("");
	private JLabel enemybattlePlace5Atk = new JLabel("");
	
	private JLabel enemybattlePlace1Hp = new JLabel("");
	private JLabel enemybattlePlace2Hp = new JLabel("");
	private JLabel enemybattlePlace3Hp = new JLabel("");
	private JLabel enemybattlePlace4Hp = new JLabel("");
	private JLabel enemybattlePlace5Hp = new JLabel("");
	
	private JButton battlePlace1AtkButton = new JButton("");
	private JButton battlePlace2AtkButton = new JButton("");
	private JButton battlePlace3AtkButton = new JButton("");
	private JButton battlePlace4AtkButton = new JButton("");
	private JButton battlePlace5AtkButton = new JButton("");
	
	private JButton enemyBattlePlace1AtkButton = new JButton("");
	private JButton enemyBattlePlace2AtkButton = new JButton("");
	private JButton enemyBattlePlace3AtkButton = new JButton("");
	private JButton enemyBattlePlace4AtkButton = new JButton("");
	private JButton enemyBattlePlace5AtkButton = new JButton("");
	
	private JLabel battlePlace1 = new JLabel("");
	private JLabel battlePlace2 = new JLabel("");
	private JLabel battlePlace3 = new JLabel("");
	private JLabel battlePlace4 = new JLabel("");
	private JLabel battlePlace5 = new JLabel("");
	
	private JLabel battlePlace1Atk = new JLabel("");
	private JLabel battlePlace2Atk = new JLabel("");
	private JLabel battlePlace3Atk = new JLabel("");
	private JLabel battlePlace4Atk = new JLabel("");
	private JLabel battlePlace5Atk = new JLabel("");
	
	private JLabel battlePlace1Hp = new JLabel("");
	private JLabel battlePlace2Hp = new JLabel("");
	private JLabel battlePlace3Hp = new JLabel("");
	private JLabel battlePlace4Hp = new JLabel("");
	private JLabel battlePlace5Hp = new JLabel("");
	
	private JButton summon1 = new JButton("Summon");
	private JButton summon2 = new JButton("Summon");
	private JButton summon3 = new JButton("Summon");
	private JButton summon4 = new JButton("Summon");
	private JButton summon5 = new JButton("Summon");

	
	private JButton endTurn = new JButton("End Turn");
	
	private JButton rdy = new JButton("Rdy");
	
	
	private int intManaLeft = 0;
	
	private boolean slot1full = false;
	private boolean slot2full = false;
	private boolean slot3full = false;
	private boolean slot4full = false;
	private boolean slot5full = false;
	
	
	private JButton drawCard = new JButton("Draw card");
	boolean handFull = false;

	
	Controller controller;
	
	public Gui(Controller controller,fightControll fightController,summonControll summonControll) {
    this.fightController = fightController;
	this.controller = controller;	
	this.summonControll = summonControll;	

	setContentPane(new JLabel(new ImageIcon("images/bakgroundImage.png")));
	setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setPreferredSize(new Dimension(1900, 1000));
	pack();
	setLocationRelativeTo(null);
	setResizable(false);
	setVisible(true);
		
	fightController.fightControll(this);
	buildUI();
	}
	

	
	public void buildUI(){
				
		manaLeft.setFont(new Font("Serif", Font.BOLD, 30 ));
		playerName1.setFont(new Font("Serif", Font.BOLD, 30 ));
		playerName2.setFont(new Font("Serif", Font.BOLD, 30 ));
				 
//		line.setBounds(360, 350, 1300, 50);
		
		playerName2.setBounds(100, 250, 260, 40);
		playerName1.setBounds(100, 450, 260, 40);
		
		manaLeft.setBounds(1000, 650, 2000, 250);
		
		
		deckCards.setBounds(1570, 600, 300, 450);
		
		rdy.setBounds(50, 336, 220, 100);
		endTurn.setBounds(1600, 405, 250, 100);
		
		slot1.setBounds(100, 375, 300, 850);
		slot2.setBounds(260, 375, 300, 850);
		slot3.setBounds(420, 375, 300, 850);
		slot4.setBounds(580, 375, 300, 850);
		slot5.setBounds(740, 375, 300, 850);
						
	
		enemyCard1.setBounds(1680, -100, 300, 250);
		enemyCard2.setBounds(1520, -100, 300, 250);
		enemyCard3.setBounds(1360, -100, 300, 250);
		enemyCard4.setBounds(1200, -100, 300, 250);
		enemyCard5.setBounds(1040, -100, 300, 250);
				
		
		enemybattlePlace1Hp.setBounds(580, 110, 300, 400);
		enemybattlePlace2Hp.setBounds(780, 110, 300, 400);
		enemybattlePlace3Hp.setBounds(980, 110, 300, 400);
		enemybattlePlace4Hp.setBounds(1180, 110, 300, 400);
		enemybattlePlace5Hp.setBounds(1380, 110, 300, 400);
		
		enemybattlePlace1Atk.setBounds(490, 110, 300, 400);
		enemybattlePlace2Atk.setBounds(690, 110, 300, 400);
		enemybattlePlace3Atk.setBounds(890, 110, 300, 400);
		enemybattlePlace4Atk.setBounds(1090, 110, 300, 400);
		enemybattlePlace5Atk.setBounds(1290, 110, 300, 400);
		
		enemybattlePlace1.setBounds(480, 0, 300, 450);
		enemybattlePlace2.setBounds(680, 0, 300, 450);
		enemybattlePlace3.setBounds(880, 0, 300, 450);
		enemybattlePlace4.setBounds(1080, 0, 300, 450);
		enemybattlePlace5.setBounds(1280, 0, 300, 450);
		
		
		enemyBattlePlace1AtkButton.setBounds(480, 180, 150, 150);
		enemyBattlePlace2AtkButton.setBounds(680, 180, 150, 150);
		enemyBattlePlace3AtkButton.setBounds(880, 180, 150, 150);
		enemyBattlePlace4AtkButton.setBounds(1080, 180, 150, 150);
		enemyBattlePlace5AtkButton.setBounds(1280, 180, 150, 150);
		
		
		battlePlace1AtkButton.setBounds(480, 400, 150, 150);
		battlePlace2AtkButton.setBounds(680, 400, 150, 150);
		battlePlace3AtkButton.setBounds(880, 400, 150, 150);
		battlePlace4AtkButton.setBounds(1080, 400, 150, 150);
		battlePlace5AtkButton.setBounds(1280, 400, 150, 150);
		
		battlePlace1.setBounds(480, 50, 300, 850);
		battlePlace2.setBounds(680, 50, 300, 850);
		battlePlace3.setBounds(880, 50, 300, 850);
		battlePlace4.setBounds(1080, 50, 300, 850);
		battlePlace5.setBounds(1280, 50, 300, 850);
			
		
		battlePlace1Hp.setBounds(580, 130, 300, 850);
		battlePlace2Hp.setBounds(780, 130, 300, 850);
		battlePlace3Hp.setBounds(980, 130, 300, 850);
		battlePlace4Hp.setBounds(1180, 130, 300, 850);
		battlePlace5Hp.setBounds(1380, 130, 300, 850);
		
		battlePlace1Atk.setBounds(490, 130, 300, 850);
		battlePlace2Atk.setBounds(690, 130, 300, 850);
		battlePlace3Atk.setBounds(890, 130, 300, 850);
		battlePlace4Atk.setBounds(1090, 130, 300, 850);
		battlePlace5Atk.setBounds(1290, 130, 300, 850);
		
		drawCard.setBounds(1570, 700, 150, 250);
				
		summon1.setBounds(125, 930, 70, 25);
		summon2.setBounds(285, 930, 70, 25);
		summon3.setBounds(445, 930, 70, 25);
		summon4.setBounds(605, 930, 70, 25);
		summon5.setBounds(765, 930, 70, 25);

		
		add(playerName1);
		add(playerName2);
		
		add(rdy);
		add(endTurn);
		add(deckCards);
//		add(line);
		add(manaLeft);
		
		add(slot1);
		add(slot2);
		add(slot3);
		add(slot4);
		add(slot5);
		
		
		add(enemyCard1);
		add(enemyCard2);
		add(enemyCard3);
		add(enemyCard4);
		add(enemyCard5);
		
		add(enemybattlePlace1Hp);
		add(enemybattlePlace2Hp);
		add(enemybattlePlace3Hp);
		add(enemybattlePlace4Hp);
		add(enemybattlePlace5Hp);
		

		add(enemybattlePlace1Atk);
		add(enemybattlePlace2Atk);
		add(enemybattlePlace3Atk);
		add(enemybattlePlace4Atk);
		add(enemybattlePlace5Atk);
		
		add(enemybattlePlace1);
		add(enemybattlePlace2);
		add(enemybattlePlace3);
		add(enemybattlePlace4);
		add(enemybattlePlace5);
		
		add(enemyBattlePlace1AtkButton);
		add(enemyBattlePlace2AtkButton);
		add(enemyBattlePlace3AtkButton);
		add(enemyBattlePlace4AtkButton);
		add(enemyBattlePlace5AtkButton);
		
		add(battlePlace1AtkButton);
		add(battlePlace2AtkButton);
		add(battlePlace3AtkButton);
		add(battlePlace4AtkButton);
		add(battlePlace5AtkButton);
		
		add(battlePlace1);
		add(battlePlace2);
		add(battlePlace3);
		add(battlePlace4);
		add(battlePlace5);
			
		add(battlePlace1Hp);
		add(battlePlace2Hp);
		add(battlePlace3Hp);
		add(battlePlace4Hp);
		add(battlePlace5Hp);
		
		add(battlePlace1Atk);
		add(battlePlace2Atk);
		add(battlePlace3Atk);
		add(battlePlace4Atk);
		add(battlePlace5Atk);
		
		
		add(drawCard);
		
		add(summon1);
		add(summon2);
		add(summon3);
		add(summon4);
		add(summon5);

		
		//load images from start not given by controller.
		 resetBattleImagesAndText();
		 
		enemyCard1.setIcon(loadImages.getCardFiller());
		enemyCard2.setIcon(loadImages.getCardFiller());
		enemyCard3.setIcon(loadImages.getCardFiller());
		enemyCard4.setIcon(loadImages.getCardFiller());
		enemyCard5.setIcon(loadImages.getCardFiller());
		
		deckCards.setIcon(loadImages.getCardFiller());
		
		
	
		makeAktionButtonWork();
		
		
		//Make deckbutton invis.
		drawCard.setOpaque(false);
		drawCard.setContentAreaFilled(false);
		drawCard.setBorderPainted(false);
		
		
		
		//actionlisteners.
		rdy.addActionListener(this);
		drawCard.addActionListener(this);
		endTurn.addActionListener(this);
		
		summon1.addActionListener(this);
		summon2.addActionListener(this);
		summon3.addActionListener(this);
		summon4.addActionListener(this);
		summon5.addActionListener(this);
		
		
		battlePlace1AtkButton.addActionListener(this);
		battlePlace2AtkButton.addActionListener(this);
		battlePlace3AtkButton.addActionListener(this);
		battlePlace4AtkButton.addActionListener(this);
		battlePlace5AtkButton.addActionListener(this);
		
		enemyBattlePlace1AtkButton.addActionListener(this);
		enemyBattlePlace2AtkButton.addActionListener(this);
		enemyBattlePlace3AtkButton.addActionListener(this);
		enemyBattlePlace4AtkButton.addActionListener(this);
		enemyBattlePlace5AtkButton.addActionListener(this);
		
	}
	
	public void lockAllButtons(){		
		drawCard.setVisible(false);
		endTurn.setVisible(false);
		
		summon1.setVisible(false);
		summon2.setVisible(false);
		summon3.setVisible(false);
		summon4.setVisible(false);
		summon5.setVisible(false);
		
		battlePlace1AtkButton.setVisible(false);
		battlePlace2AtkButton.setVisible(false);
		battlePlace3AtkButton.setVisible(false);
		battlePlace4AtkButton.setVisible(false);
		battlePlace5AtkButton.setVisible(false);
		endTurn.setVisible(false);
	}
	
	
	public void resetBattleImagesAndText(){
	battlePlace1.setIcon(loadImages.getEmptySlot());
	battlePlace2.setIcon(loadImages.getEmptySlot());
	battlePlace3.setIcon(loadImages.getEmptySlot());
	battlePlace4.setIcon(loadImages.getEmptySlot());
	battlePlace5.setIcon(loadImages.getEmptySlot());
	
	enemybattlePlace1.setIcon(loadImages.getEmptySlot());
	enemybattlePlace2.setIcon(loadImages.getEmptySlot());
	enemybattlePlace3.setIcon(loadImages.getEmptySlot());
	enemybattlePlace4.setIcon(loadImages.getEmptySlot());
	enemybattlePlace5.setIcon(loadImages.getEmptySlot());
	
	Font theFont = new Font("Serif",Font.BOLD,14);
	
	enemybattlePlace1Atk.setText("");
	enemybattlePlace1Atk.setFont(theFont);
	
	enemybattlePlace1Hp.setText("");
	enemybattlePlace1Hp.setFont(theFont);	
	enemybattlePlace1Hp.setForeground (Color.BLACK);
	
	enemybattlePlace2Atk.setText("");
	enemybattlePlace2Hp.setFont(theFont);
	
	enemybattlePlace2Hp.setText("");
	enemybattlePlace2Hp.setFont(theFont);
	enemybattlePlace2Hp.setForeground (Color.BLACK);
	
	enemybattlePlace3Atk.setText("");
	enemybattlePlace3Atk.setFont(theFont);
	
	enemybattlePlace3Hp.setText("");
	enemybattlePlace3Hp.setFont(theFont);
	enemybattlePlace3Hp.setForeground (Color.BLACK);
	
	enemybattlePlace4Atk.setText("");
	enemybattlePlace4Atk.setFont(theFont);
	
	enemybattlePlace4Hp.setText("");
	enemybattlePlace4Hp.setFont(theFont);
	enemybattlePlace4Hp.setForeground (Color.BLACK);
	
	enemybattlePlace5Atk.setText("");
	enemybattlePlace5Atk.setFont(theFont);
	
	enemybattlePlace5Hp.setText("");
	enemybattlePlace5Hp.setFont(theFont);
	enemybattlePlace5Hp.setForeground (Color.BLACK);
	
	battlePlace1Atk.setText("");
	battlePlace1Atk.setFont(theFont);
	
    battlePlace1Hp.setText("");
    battlePlace1Hp.setFont(theFont);
	battlePlace1Hp.setForeground (Color.BLACK);
	
	battlePlace2Atk.setText("");
	battlePlace2Atk.setFont(theFont);
	
    battlePlace2Hp.setText("");
    battlePlace2Hp.setFont(theFont);
	battlePlace2Hp.setForeground (Color.BLACK);
	
	battlePlace3Atk.setText("");
	battlePlace3Atk.setFont(theFont);
	
    battlePlace3Hp.setText("");
    battlePlace3Hp.setFont(theFont);
	battlePlace3Hp.setForeground (Color.BLACK);
	
	battlePlace4Atk.setText("");
	battlePlace4Atk.setFont(theFont);
	
    battlePlace4Hp.setText("");
    battlePlace4Hp.setFont(theFont);
	battlePlace4Hp.setForeground (Color.BLACK);
	
	battlePlace5Atk.setText("");
	battlePlace5Atk.setFont(theFont);
	
    battlePlace5Hp.setText("");
    battlePlace5Hp.setFont(theFont);
	battlePlace5Hp.setForeground (Color.BLACK);
	
	}
	public void showHandCards(ArrayList<Card> cards,ArrayList<Card>newCardsOnField, ArrayList<Card>enemyCardsOnFields){
		cardsOnHand.clear();
		cardsOnHand.addAll(cards);
		
		enemyCardsOnField.clear();
		enemyCardsOnField.addAll(enemyCardsOnFields);

		cardsOnField.clear();
		cardsOnField.addAll(newCardsOnField);

		slot1.setIcon(loadImages.getFiller());
		slot2.setIcon(loadImages.getFiller());
		slot3.setIcon(loadImages.getFiller());
		slot4.setIcon(loadImages.getFiller());
		slot5.setIcon(loadImages.getFiller());
		
//		makeAktionButtonWork();
		resetBattleImagesAndText();
			
		if(enemyCardsOnFields.size()>0){
			
			enemybattlePlace1.setIcon(enemyCardsOnFields.get(0).getBattleImage());
			enemybattlePlace1Atk.setText("Atk: "+String.valueOf(enemyCardsOnFields.get(0).getAttack()));
			enemybattlePlace1Hp.setText("Hp: "+String.valueOf(enemyCardsOnFields.get(0).getHealth()));
			if(enemyCardsOnFields.get(0).getHealth()<enemyCardsOnFields.get(0).getOriginalHealth()){
				enemybattlePlace1Hp.setForeground (Color.red);
			}
			if(enemyCardsOnFields.size()>1){
				enemybattlePlace2.setIcon(enemyCardsOnFields.get(1).getBattleImage());
				enemybattlePlace2Atk.setText("Atk: "+String.valueOf(enemyCardsOnFields.get(1).getAttack()));
				enemybattlePlace2Hp.setText("Hp: "+String.valueOf(enemyCardsOnFields.get(1).getHealth()));
				if(enemyCardsOnFields.get(1).getHealth()<enemyCardsOnFields.get(1).getOriginalHealth()){
					enemybattlePlace2Hp.setForeground (Color.red);
				}
			}
			if(enemyCardsOnFields.size()>2){
				enemybattlePlace3.setIcon(enemyCardsOnFields.get(2).getBattleImage());
				enemybattlePlace3Atk.setText("Atk: "+String.valueOf(enemyCardsOnFields.get(2).getAttack()));
				enemybattlePlace3Hp.setText("Hp: "+String.valueOf(enemyCardsOnFields.get(2).getHealth()));
				if(enemyCardsOnFields.get(2).getHealth()<enemyCardsOnFields.get(2).getOriginalHealth()){
					enemybattlePlace3Hp.setForeground (Color.red);
				}
			}
			if(enemyCardsOnFields.size()>3){
				enemybattlePlace4.setIcon(enemyCardsOnFields.get(3).getBattleImage());
				enemybattlePlace4Atk.setText("Atk: "+String.valueOf(enemyCardsOnFields.get(3).getAttack()));
				enemybattlePlace4Hp.setText("Hp: "+String.valueOf(enemyCardsOnFields.get(3).getHealth()));
				if(enemyCardsOnFields.get(3).getHealth()<enemyCardsOnFields.get(3).getOriginalHealth()){
					enemybattlePlace4Hp.setForeground (Color.red);
				}
			}
			if(enemyCardsOnFields.size()>4){
				enemybattlePlace5.setIcon(enemyCardsOnFields.get(4).getBattleImage());
				enemybattlePlace5Atk.setText("Atk: "+String.valueOf(enemyCardsOnFields.get(4).getAttack()));
				enemybattlePlace5Hp.setText("Hp: "+String.valueOf(enemyCardsOnFields.get(4).getHealth()));
				if(enemyCardsOnFields.get(4).getHealth()<enemyCardsOnFields.get(4).getOriginalHealth()){
					enemybattlePlace5Hp.setForeground (Color.red);
				}
			}
			
		}
		
		if(cardsOnField.size()>0){
//			System.out.print(cardsOnField.get(0).getName() + ", ");
			battlePlace1.setIcon(cardsOnField.get(0).getBattleImage());
			battlePlace1Atk.setText("Atk: "+String.valueOf(cardsOnField.get(0).getAttack()));
			battlePlace1Hp.setText("Hp: "+String.valueOf(cardsOnField.get(0).getHealth()));
			if(cardsOnField.get(0).getHealth()<cardsOnField.get(0).getOriginalHealth()){
				battlePlace1Hp.setForeground (Color.red);
			}
			else
				battlePlace1Hp.setForeground (Color.BLACK);
			if(cardsOnField.size()>1){
//				System.out.print(cardsOnField.get(1).getName() + ", ");
				battlePlace2.setIcon(cardsOnField.get(1).getBattleImage());
				battlePlace2Atk.setText("Atk: "+String.valueOf(cardsOnField.get(1).getAttack()));
				battlePlace2Hp.setText("Hp: "+String.valueOf(cardsOnField.get(1).getHealth()));
				if(cardsOnField.get(1).getHealth()<cardsOnField.get(1).getOriginalHealth()){
					battlePlace2Hp.setForeground (Color.red);
				}
				else
					battlePlace2Hp.setForeground (Color.BLACK);
			}
			if(cardsOnField.size()>2){
//				System.out.print(cardsOnField.get(2).getName() + ", ");
				battlePlace3.setIcon(cardsOnField.get(2).getBattleImage());
				battlePlace3Atk.setText("Atk: "+String.valueOf(cardsOnField.get(2).getAttack()));
				battlePlace3Hp.setText("Hp: "+String.valueOf(cardsOnField.get(2).getHealth()));
				if(cardsOnField.get(2).getHealth()<cardsOnField.get(2).getOriginalHealth()){
					battlePlace3Hp.setForeground (Color.red);
				}
				else
					battlePlace3Hp.setForeground (Color.BLACK);
			}
			if(cardsOnField.size()>3){
//				System.out.print(cardsOnField.get(3).getName() + ", ");
				battlePlace4.setIcon(cardsOnField.get(3).getBattleImage());
				battlePlace4Atk.setText("Atk: "+String.valueOf(cardsOnField.get(3).getAttack()));
				battlePlace4Hp.setText("Hp: "+String.valueOf(cardsOnField.get(3).getHealth()));
				if(cardsOnField.get(3).getHealth()<cardsOnField.get(3).getOriginalHealth()){
					battlePlace4Hp.setForeground (Color.red);
				}
				else
					battlePlace4Hp.setForeground (Color.BLACK);
			}
			if(cardsOnField.size()>4){
//				System.out.println(cardsOnField.get(4).getName() + ", ");
				battlePlace5.setIcon(cardsOnField.get(4).getBattleImage());
				battlePlace5Atk.setText("Atk: "+String.valueOf(cardsOnField.get(4).getAttack()));
				battlePlace5Hp.setText("Hp: "+String.valueOf(cardsOnField.get(4).getHealth()));
				if(cardsOnField.get(4).getHealth()<cardsOnField.get(4).getOriginalHealth()){
					battlePlace5Hp.setForeground (Color.red);
				}
				else
					battlePlace5Hp.setForeground (Color.BLACK);
			}
			
		}
		if(cards.size()>0){
			
			slot1.setIcon(cards.get(0).getImage());
			summon1.setEnabled(true);
//			System.out.println(intManaLeft);
//			System.out.println("testar - " + (intManaLeft - (cards.get(0).getCost())));

			if(intManaLeft-(cards.get(0).getCost())>=0){
//				showSumm1();
			}
			if(intManaLeft-cards.get(0).getCost()<0){
				hideSumm1();
			}
		}
		
		if(cards.size()>1){
			slot2.setIcon(cards.get(1).getImage());
			summon2.setEnabled(true);
		}
		if(cards.size()>2){
			slot3.setIcon(cards.get(2).getImage());
			summon3.setEnabled(true);
		}
		if(cards.size()>3){
			slot4.setIcon(cards.get(3).getImage());
			summon4.setEnabled(true);
		}
		if(cards.size()>4){
			slot5.setIcon(cards.get(4).getImage());
			summon5.setEnabled(true);
			 hideDraw();
		}		
	}
	
	
	public void changeManaLeft(int left){
		this.intManaLeft = left;
		manaLeft.setText("Mana left this turn: " + left);
	}
	
	public void makeAktionButtonWork(){

		drawCard.setOpaque(false);
		drawCard.setContentAreaFilled(false);
		drawCard.setBorderPainted(false);
		drawCard.setEnabled(true);
		
		endTurn.setVisible(true);

		
		enemyBattlePlace1AtkButton.setOpaque(false);
		enemyBattlePlace1AtkButton.setContentAreaFilled(false);
		enemyBattlePlace1AtkButton.setBorderPainted(false);
		enemyBattlePlace1AtkButton.setEnabled(false);
		
		enemyBattlePlace2AtkButton.setOpaque(false);
		enemyBattlePlace2AtkButton.setContentAreaFilled(false);
		enemyBattlePlace2AtkButton.setBorderPainted(false);
		enemyBattlePlace2AtkButton.setEnabled(false);
		
		enemyBattlePlace3AtkButton.setOpaque(false);
		enemyBattlePlace3AtkButton.setContentAreaFilled(false);
		enemyBattlePlace3AtkButton.setBorderPainted(false);
		enemyBattlePlace3AtkButton.setEnabled(false);
		
		enemyBattlePlace4AtkButton.setOpaque(false);
		enemyBattlePlace4AtkButton.setContentAreaFilled(false);
		enemyBattlePlace4AtkButton.setBorderPainted(false);
		enemyBattlePlace4AtkButton.setEnabled(false);
		
		enemyBattlePlace5AtkButton.setOpaque(false);
		enemyBattlePlace5AtkButton.setContentAreaFilled(false);
		enemyBattlePlace5AtkButton.setBorderPainted(false);
		enemyBattlePlace5AtkButton.setEnabled(false);

		
		drawCard.setVisible(true);
		
		summon1.setVisible(true);
		summon2.setVisible(true);
		summon3.setVisible(true);
		summon4.setVisible(true);
		summon5.setVisible(true);
//		System.out.println("here in makeAktionButtonWork?");
		
		if(cardsOnField.size()>0){
		if(cardsOnField.get(0).getSleep()==false){
			battlePlace1AtkButton.setVisible(true);
		}
		if(cardsOnField.size()>1){
		if(cardsOnField.get(1).getSleep()==false){
			battlePlace2AtkButton.setVisible(true);
		}}
		if(cardsOnField.size()>2){
		if(cardsOnField.get(2).getSleep()==false){
			battlePlace3AtkButton.setVisible(true);
		}}
		if(cardsOnField.size()>3){
		if(cardsOnField.get(3).getSleep()==false){
			battlePlace4AtkButton.setVisible(true);
		}}
		if(cardsOnField.size()>4){
		if(cardsOnField.get(4).getSleep()==false){
			battlePlace5AtkButton.setVisible(true);
		}}
		}
		drawCard.setVisible(true);
		
		drawCard.setOpaque(false);
		drawCard.setContentAreaFilled(false);
		drawCard.setBorderPainted(false);
		
		battlePlace1AtkButton.setOpaque(false);
		battlePlace1AtkButton.setContentAreaFilled(false);
		battlePlace1AtkButton.setBorderPainted(false);
		
		battlePlace2AtkButton.setOpaque(false);
		battlePlace2AtkButton.setContentAreaFilled(false);
		battlePlace2AtkButton.setBorderPainted(false);
		
		battlePlace3AtkButton.setOpaque(false);
		battlePlace3AtkButton.setContentAreaFilled(false);
		battlePlace3AtkButton.setBorderPainted(false);
		
		battlePlace4AtkButton.setOpaque(false);
		battlePlace4AtkButton.setContentAreaFilled(false);
		battlePlace4AtkButton.setBorderPainted(false);
		
		battlePlace5AtkButton.setOpaque(false);
		battlePlace5AtkButton.setContentAreaFilled(false);
		battlePlace5AtkButton.setBorderPainted(false);
	}
	
	public void disableFightImages(int oneClicked){
		if(enemyCardsOnField.size()>0){
			enemyBattlePlace1AtkButton.setEnabled(true);
			if(enemyCardsOnField.size()>1){
			enemyBattlePlace2AtkButton.setEnabled(true);
			}
			if(enemyCardsOnField.size()>2){
			enemyBattlePlace3AtkButton.setEnabled(true);
			}
			if(enemyCardsOnField.size()>3){
			enemyBattlePlace4AtkButton.setEnabled(true);
			}
			if(enemyCardsOnField.size()>4){
			enemyBattlePlace5AtkButton.setEnabled(true);
			}
		}
		
		
		drawCard.setVisible(false);
//		summon1.setEnabled(false);
//		summon2.setEnabled(false);
//		summon3.setEnabled(false);
//		summon4.setEnabled(false);
//		summon5.setEnabled(false);
		
		if(oneClicked==1){
			battlePlace2AtkButton.setVisible(false);
			battlePlace3AtkButton.setVisible(false);
			battlePlace4AtkButton.setVisible(false);
			battlePlace5AtkButton.setVisible(false);
		}
		if(oneClicked==2){
			battlePlace1AtkButton.setVisible(false);
			battlePlace3AtkButton.setVisible(false);
			battlePlace4AtkButton.setVisible(false);
			battlePlace5AtkButton.setVisible(false);
		}
		if(oneClicked==3){
			battlePlace2AtkButton.setVisible(false);
			battlePlace1AtkButton.setVisible(false);
			battlePlace4AtkButton.setVisible(false);
			battlePlace5AtkButton.setVisible(false);
		}
		if(oneClicked==4){
			battlePlace2AtkButton.setVisible(false);
			battlePlace3AtkButton.setVisible(false);
			battlePlace1AtkButton.setVisible(false);
			battlePlace5AtkButton.setVisible(false);
		}
		if(oneClicked==5){
			battlePlace2AtkButton.setVisible(false);
			battlePlace3AtkButton.setVisible(false);
			battlePlace4AtkButton.setVisible(false);
			battlePlace1AtkButton.setVisible(false);
		}
	}

	public void resetFightImage(int card){
		if(card == 1){
			battlePlace1.setIcon(cardsOnField.get(0).getBattleImage());
//			System.out.println("here in resetFightImage");
		}
		if(card == 2){
			battlePlace2.setIcon(cardsOnField.get(1).getBattleImage());
//			System.out.println("here in resetFightImage");
		}
		if(card == 3){
			battlePlace3.setIcon(cardsOnField.get(2).getBattleImage());
//			System.out.println("here in resetFightImage");
		}
		if(card == 4){
			battlePlace4.setIcon(cardsOnField.get(3).getBattleImage());
//			System.out.println("here in resetFightImage");
		}
		if(card == 5){
			battlePlace5.setIcon(cardsOnField.get(4).getBattleImage());
//			System.out.println("here in resetFightImage");
		}
	}
	public void hideDraw(){
		drawCard.setEnabled(false);
		drawCard.setText("");
	}
	public void showDraw(){
		drawCard.setEnabled(true);
		drawCard.setText("Draw Card");
	}
	
	public void hideSumm1(){
		summon1.setEnabled(false);	
	}
	
	public void changeBackFightImage(int minion){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == endTurn) {
			lockAllButtons();
			controller.DoneThisTurn();
		}
		
		if (e.getSource() == rdy) {
			System.out.println("rdy from gui");
			rdy.setVisible(false);
//			line.setBounds(0, 350, 2000, 50);
			controller.rdy();
			
		}
		
		if (e.getSource() == enemyBattlePlace1AtkButton) {
			fightController.clickOnEnemyBattleOne();
		}
		if (e.getSource() == enemyBattlePlace2AtkButton) {
			fightController.clickOnEnemyBattleTwo();
		}
		if (e.getSource() == enemyBattlePlace3AtkButton) {
			fightController.clickOnEnemyBattleThree();
		}
		if (e.getSource() == enemyBattlePlace4AtkButton) {
			fightController.clickOnEnemyBattleFour();
		}
		if (e.getSource() == enemyBattlePlace5AtkButton) {
			fightController.clickOnEnemyBattleFive();
		}
		
		if (e.getSource() == battlePlace5AtkButton && cardsOnField.get(4).getSleep()==false ) {
		 if(cardsOnField.size()>4){
			battlePlace5.setIcon(cardsOnField.get(4).fightImage());
//			System.out.println("Sending to fighControll");
			fightController.clickOnBattleFive();
		  }
		}
		
		if (e.getSource() == battlePlace4AtkButton && cardsOnField.get(3).getSleep()==false ) {
			if(cardsOnField.size()>3){
			battlePlace4.setIcon(cardsOnField.get(3).fightImage());
//			System.out.println("Sending to fighControll");
			fightController.clickOnBattleFour();
			}
		}
		
		if (e.getSource() == battlePlace3AtkButton && cardsOnField.get(2).getSleep()==false ) {
			if(cardsOnField.size()>2){
			battlePlace3.setIcon(cardsOnField.get(2).fightImage());
//			System.out.println("Sending to fighControll");
			fightController.clickOnBattleThree();
			}
		}
		
		if (e.getSource() == battlePlace2AtkButton && cardsOnField.get(1).getSleep()==false ) {
			 if(cardsOnField.size()>1){
			battlePlace2.setIcon(cardsOnField.get(1).fightImage());
//			System.out.println("Sending to fighControll");
			fightController.clickOnBattleTwo();
			
			 }
		}
		
		if (e.getSource() == battlePlace1AtkButton && cardsOnField.get(0).getSleep()==false ) {
			 if(cardsOnField.size()>0){
			battlePlace1.setIcon(cardsOnField.get(0).fightImage());
//			System.out.println("Sending to fighControll");
			fightController.clickOnBattleOne();
		
			 }
		}
		
		if (e.getSource() == drawCard) {			
			controller.getCard();
		}
		//första kortet	
		if (e.getSource() == summon1) {	
			if(cardsOnHand.size()>0){
			Card card = cardsOnHand.get(0);			
			if(!(slot5full) && slot1full && slot2full && slot3full && slot4full){
//				battlePlace5.setIcon(cardsOnHand.get(0).getBattleImage());
				battlePlace5Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(0).getAttack()));
				battlePlace5Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(0).getHealth()));
				slot5full=true;
				cardsOnField.add(cardsOnHand.get(0));
				controller.summonCard(0, card);
				
			}
			
			if(!(slot4full) && slot1full && slot2full && slot3full){
//				battlePlace4.setIcon(cardsOnHand.get(0).getBattleImage());
				battlePlace4Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(0).getAttack()));
				battlePlace4Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(0).getHealth()));
				slot4full=true;
				cardsOnField.add(cardsOnHand.get(0));
				controller.summonCard(0, card);
			}
			
			if(!(slot3full) && slot1full && slot2full){
//				battlePlace3.setIcon(cardsOnHand.get(0).getBattleImage());
				battlePlace3Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(0).getAttack()));
				battlePlace3Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(0).getHealth()));
				slot3full=true;
				cardsOnField.add(cardsOnHand.get(0));
				controller.summonCard(0, card);
				
			}
			
			if(!(slot2full) && slot1full){
//				battlePlace2.setIcon(cardsOnHand.get(0).getBattleImage());
				battlePlace2Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(0).getAttack()));
				battlePlace2Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(0).getHealth()));
				slot2full=true;
				cardsOnField.add(cardsOnHand.get(0));
				controller.summonCard(0, card);
				
			}
			
			if(!(slot1full)){
//			battlePlace1.setIcon(cardsOnHand.get(0).getBattleImage());
			battlePlace1Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(0).getAttack()));
			battlePlace1Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(0).getHealth()));
			slot1full=true;
			cardsOnField.add(cardsOnHand.get(0));
			controller.summonCard(0, card);
			}
			
			}			
		}
		//ANDRA KORTET
		if (e.getSource() == summon2) {	
			if(cardsOnHand.size()>1){
			Card card = cardsOnHand.get(1);			
			if(!(slot5full) && slot1full && slot2full && slot3full && slot4full){
//				battlePlace5.setIcon(cardsOnHand.get(1).getBattleImage());
				battlePlace5Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(1).getAttack()));
				battlePlace5Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(1).getHealth()));
				slot5full=true;
				cardsOnField.add(cardsOnHand.get(1));
				controller.summonCard(1, card);
				
			}
			
			if(!(slot4full) && slot1full && slot2full && slot3full){
//				battlePlace4.setIcon(cardsOnHand.get(1).getBattleImage());
				battlePlace4Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(1).getAttack()));
				battlePlace4Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(1).getHealth()));
				slot4full=true;
				cardsOnField.add(cardsOnHand.get(1));
				controller.summonCard(1, card);
				
			}
			
			if(!(slot3full) && slot1full && slot2full){
//				battlePlace3.setIcon(cardsOnHand.get(1).getBattleImage());
				battlePlace3Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(1).getAttack()));
				battlePlace3Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(1).getHealth()));
				slot3full=true;
				cardsOnField.add(cardsOnHand.get(1));
				controller.summonCard(1, card);
				
			}
			
			if(!(slot2full) && slot1full){
//				battlePlace2.setIcon(cardsOnHand.get(1).getBattleImage());
				battlePlace2Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(1).getAttack()));
				battlePlace2Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(1).getHealth()));
				slot2full=true;
				cardsOnField.add(cardsOnHand.get(1));
				controller.summonCard(1, card);
				
			}
			
			if(!(slot1full)){
//			battlePlace1.setIcon(cardsOnHand.get(1).getBattleImage());
			battlePlace1Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(1).getAttack()));
			battlePlace1Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(1).getHealth()));
			slot1full=true;
			cardsOnField.add(cardsOnHand.get(1));
			controller.summonCard(1, card);
			
			}		
			}			
		}
		//TREDJE KORTET
		if (e.getSource() == summon3) {	
			if(cardsOnHand.size()>2){
			Card card = cardsOnHand.get(2);			
			if(!(slot5full) && slot1full && slot2full && slot3full && slot4full){
//				battlePlace5.setIcon(cardsOnHand.get(2).getBattleImage());
				battlePlace5Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(2).getAttack()));
				battlePlace5Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(2).getHealth()));
				slot5full=true;
				cardsOnField.add(cardsOnHand.get(2));
				controller.summonCard(2, card);
				
			}
			
			if(!(slot4full) && slot1full && slot2full && slot3full){
//				battlePlace4.setIcon(cardsOnHand.get(2).getBattleImage());
				battlePlace4Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(2).getAttack()));
				battlePlace4Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(2).getHealth()));
				slot4full=true;
				cardsOnField.add(cardsOnHand.get(2));
				controller.summonCard(2, card);
				
			}
			
			if(!(slot3full) && slot1full && slot2full){
//				battlePlace3.setIcon(cardsOnHand.get(2).getBattleImage());
				battlePlace3Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(2).getAttack()));
				battlePlace3Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(2).getHealth()));
				slot3full=true;
				cardsOnField.add(cardsOnHand.get(2));
				controller.summonCard(2, card);
				
			}
			
			if(!(slot2full) && slot1full){
//				battlePlace2.setIcon(cardsOnHand.get(2).getBattleImage());
				battlePlace2Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(2).getAttack()));
				battlePlace2Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(2).getHealth()));
				slot2full=true;
				cardsOnField.add(cardsOnHand.get(2));
				controller.summonCard(2, card);
				
			}
			
			if(!(slot1full)){
//			battlePlace1.setIcon(cardsOnHand.get(2).getBattleImage());
			battlePlace1Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(2).getAttack()));
			battlePlace1Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(2).getHealth()));
			slot1full=true;
			cardsOnField.add(cardsOnHand.get(2));
			controller.summonCard(2, card);
			
			}		
			}			
		}
		//FJÄRDE KORTET
		if (e.getSource() == summon4) {	
			if(cardsOnHand.size()>3){
			Card card = cardsOnHand.get(3);			
			if(!(slot5full) && slot1full && slot2full && slot3full && slot4full){
//				battlePlace5.setIcon(cardsOnHand.get(3).getBattleImage());
				battlePlace5Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(3).getAttack()));
				battlePlace5Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(3).getHealth()));
				slot5full=true;
				cardsOnField.add(cardsOnHand.get(3));
				controller.summonCard(3, card);
				
			}
			
			if(!(slot4full) && slot1full && slot2full && slot3full){
//				battlePlace4.setIcon(cardsOnHand.get(3).getBattleImage());
				battlePlace4Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(3).getAttack()));
				battlePlace4Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(3).getHealth()));
				slot4full=true;
				cardsOnField.add(cardsOnHand.get(3));
				controller.summonCard(3, card);
				
			}
			
			if(!(slot3full) && slot1full && slot2full){
//				battlePlace3.setIcon(cardsOnHand.get(3).getBattleImage());
				battlePlace3Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(3).getAttack()));
				battlePlace3Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(3).getHealth()));
				slot3full=true;
				cardsOnField.add(cardsOnHand.get(3));
				controller.summonCard(3, card);
				
			}
			
			if(!(slot2full) && slot1full){
//				battlePlace2.setIcon(cardsOnHand.get(3).getBattleImage());
				battlePlace2Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(3).getAttack()));
				battlePlace2Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(3).getHealth()));
				slot2full=true;
				cardsOnField.add(cardsOnHand.get(3));
				controller.summonCard(3, card);
				
			}
			
			if(!(slot1full)){
//			battlePlace1.setIcon(cardsOnHand.get(3).getBattleImage());
			battlePlace1Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(3).getAttack()));
			battlePlace1Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(3).getHealth()));
			slot1full=true;
			cardsOnField.add(cardsOnHand.get(3));
			controller.summonCard(3, card);			
			}		
			}			
		}
		//FEMTE KORTET
		if (e.getSource() == summon5) {	
			if(cardsOnHand.size()>4){
			Card card = cardsOnHand.get(4);			
			if(!(slot5full) && slot1full && slot2full && slot3full && slot4full){
//				battlePlace5.setIcon(cardsOnHand.get(4).getBattleImage());
				battlePlace5Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(4).getAttack()));
				battlePlace5Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(4).getHealth()));
				slot5full=true;
				cardsOnField.add(cardsOnHand.get(4));
				controller.summonCard(4, card);
				
			}
			
			if(!(slot4full) && slot1full && slot2full && slot3full){
//				battlePlace4.setIcon(cardsOnHand.get(4).getBattleImage());
				battlePlace4Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(4).getAttack()));
				battlePlace4Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(4).getHealth()));
				slot4full=true;
				cardsOnField.add(cardsOnHand.get(4));
				controller.summonCard(4, card);
				
			}
			
			if(!(slot3full) && slot1full && slot2full){
//				battlePlace3.setIcon(cardsOnHand.get(4).getBattleImage());
				battlePlace3Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(4).getAttack()));
				battlePlace3Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(4).getHealth()));
				slot3full=true;
				cardsOnField.add(cardsOnHand.get(4));
				controller.summonCard(4, card);
				
			}
			
			if(!(slot2full) && slot1full){
//				battlePlace2.setIcon(cardsOnHand.get(4).getBattleImage());
				battlePlace2Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(4).getAttack()));
				battlePlace2Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(4).getHealth()));
				slot2full=true;
				cardsOnField.add(cardsOnHand.get(4));
				controller.summonCard(4, card);
				
			}
			
			if(!(slot1full)){
//			battlePlace1.setIcon(cardsOnHand.get(4).getBattleImage());
			battlePlace1Atk.setText("Atk: " + String.valueOf(cardsOnHand.get(4).getAttack()));
			battlePlace1Hp.setText("Hp: " + String.valueOf(cardsOnHand.get(4).getHealth()));
			slot1full=true;
//			cardsOnField.add(cardsOnHand.get(4));
			controller.summonCard(4, card);
			
			}		
			}			
		}
		
		
		
	}
	public String getAoeEnemyPosition(int whatMinion){
		String position = "";
		
		whatMinion = whatMinion+1;
		
		if(whatMinion==1){
			position = "480,0,300,450";
		}
		if(whatMinion==2){
			position = "680,0,300,450";
		}
		if(whatMinion==3){
			position = "880,0,300,450";
		}
		if(whatMinion==4){
			position = "1080,0,300,450";
		}
		if(whatMinion==5){
			position = "1280,0,300,450";
		}
		
		return position;
	}
	
	public String getPosition(int whatMinion){
		String position = "";
		if(whatMinion==1){
			position = "480,50,300,850";
		}
		if(whatMinion==2){
			position = "680,50,300,850";
		}
		if(whatMinion==3){
			position = "880,50,300,850";
		}
		if(whatMinion==4){
			position = "1080,50,300,850";
		}
		if(whatMinion==5){
			position = "1280,50,300,850";
		}

		return position;
	}
	
	public JLabel getEnemyBattleImage(int whatMinion){
		whatMinion = whatMinion+1;
		
		 JLabel toEffects = new JLabel("");
		 
		if(whatMinion==1){
			toEffects = enemybattlePlace1;
		}
		if(whatMinion==2){
			toEffects = enemybattlePlace2;
		}
		if(whatMinion==3){
			toEffects = enemybattlePlace3;
		}
		if(whatMinion==4){
			toEffects = enemybattlePlace4;
		}
		if(whatMinion==5){
			toEffects = enemybattlePlace5;
		}
				
		return toEffects;
	}
	
	public JLabel getbattleImage(int whatMinion){
		 JLabel toEffects = new JLabel("");
		if(whatMinion==1){
			toEffects = battlePlace1;
		}
		if(whatMinion==2){
			toEffects = battlePlace2;
		}
		if(whatMinion==3){
			toEffects = battlePlace3;
		}
		if(whatMinion==4){
			toEffects = battlePlace4;
		}
		if(whatMinion==5){
			System.out.println("GUI GIVE THIS!!");
			toEffects = battlePlace5;
		}
				
		return toEffects;
	}
}
