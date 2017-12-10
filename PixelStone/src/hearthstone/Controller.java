package hearthstone;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import ClientSide.ExAClient;
import Effects.EffectController;


public class Controller {
	ArrayList<Card> theDeck= new ArrayList<Card>();
	ArrayList<Card> playerOne = new ArrayList<Card>();
	ArrayList<Card> yourCardsOnHand = new ArrayList<Card>();	
	ArrayList<Card> yourCardsOnField = new ArrayList<Card>();
	ArrayList<Card> enemyCardsOnHand = new ArrayList<Card>();	
	ArrayList<Card> enemyCardsOnField = new ArrayList<Card>();
	ExAClient client;
	
	String playerName = "Name,Josse";
	EffectController effectController;
	Deck deck;
	Gui gui;
	fightControll fight;
	summonControll summon;
	loadImages images;
	int cardsLeft;
	int manaLeft = 0;
	
	
	
	public Controller( ExAClient client){
		this.client = client;
		String playerName = JOptionPane.showInputDialog("input Name");
		System.out.println(playerName);
		deck = new Deck();
		theDeck = deck.getDeck();
		cardsLeft = theDeck.size();
		effectController = new EffectController();
//		getStartCards();	
		images = new loadImages();
		summon = new summonControll(this);
		fight = new fightControll(this,effectController);		
		gui = new Gui(this,fight,summon);
		gui.lockAllButtons();
		effectController.getGuiAccess(gui);
		System.out.println("line 45 controller - Starting client wiht name: " + playerName);
	
	}
	

	public void rdy(){
		System.out.println("line 78 controller - sending rdy to client");		
			client.rdy();	
	}
	
	
	public void newRound(){
		wakeUpMinions();
		gui.makeAktionButtonWork();
		gui.showHandCards(yourCardsOnHand,client.getYourCardsOnField(),client.getEnemyCardsOnField());	
		yourCardsOnField = client.getYourCardsOnField();
		enemyCardsOnField = client.getEnemyCardsOnField();
	}
	
	
	public void wakeUpMinions(){
		for(int i = 0; i<yourCardsOnField.size(); i++){
			yourCardsOnField.get(i).setSleep(false);
		}
	}
	
	public void putMinionToSleep(int minion){
		yourCardsOnField.get(minion-1).setSleep(true);
		gui.resetFightImage(minion-1);
	}
	
	public void damage(int yourMinion, int enemyMinion){
		int yourDamage;
		int theirDamga;
		int theirHp;
		int yourHp;
		System.out.println("your -" +yourCardsOnField.get(yourMinion-1).getName());
		System.out.println("your - "+enemyCardsOnField.get(enemyMinion-1).getName());
		yourDamage = yourCardsOnField.get(yourMinion-1).getAttack();
		yourHp = yourCardsOnField.get(yourMinion-1).getHealth();
		theirDamga = enemyCardsOnField.get(enemyMinion-1).getAttack();
		theirHp = enemyCardsOnField.get(enemyMinion-1).getHealth();
		
		theirHp = (theirHp-yourDamage);
		yourHp = (yourHp-theirDamga);

		
		yourCardsOnField.get(yourMinion-1).setHealth(yourHp);
		enemyCardsOnField.get(enemyMinion-1).setHealth(theirHp);
		if(yourCardsOnField.get(yourMinion-1).getHealth()<=0){
			System.out.println("removing: " +yourCardsOnField.get(yourMinion-1).getName() );
			
			yourCardsOnField.remove(yourMinion-1);
		}
		if(enemyCardsOnField.get(enemyMinion-1).getHealth()<=0){
			enemyCardsOnField.remove(enemyMinion-1);
		}
		client.updateBoard(yourCardsOnField,enemyCardsOnField);	
	}
	
	
	public void updateBoard(ArrayList<Card> yourCardsOnField, ArrayList<Card> enemyCardsOnField){
		System.out.println("yourCardsOnField " + yourCardsOnField.size() + " enemyCardsOnField " + enemyCardsOnField.size());	
		gui.showHandCards(yourCardsOnHand,yourCardsOnField,enemyCardsOnField);	
	}
	
	
	
	public void getCard(){
		if(theDeck.size()>0){
		Random rand = new Random();
		int next = rand.nextInt(theDeck.size());
		int delete = next;		
		yourCardsOnHand.add(theDeck.get(next));
		theDeck.remove(delete);
		gui.showHandCards(yourCardsOnHand,yourCardsOnField,enemyCardsOnField);
		}
		else 
			gui.hideDraw();
			
	}
	
	public void summonCard(int handPlace, Card card){
//		System.out.println("before summ " + yourCardsOnHand.size());
		yourCardsOnField.add(yourCardsOnHand.get(handPlace));	
		yourCardsOnHand.remove(handPlace);		
		manaLeft = manaLeft - card.getCost();
		client.updateBoard(yourCardsOnField,enemyCardsOnField);
		gui.changeManaLeft(manaLeft);		
		
//		if(yourCardsOnHand.size()==0){
//			gui.hideSumm1();
//		}
//		if(theDeck.size()>0 && yourCardsOnHand.size()<5){
//			gui.showDraw();
//		}
//		gui.showHandCards(yourCardsOnHand,yourCardsOnField,enemyCardsOnField);
//		System.out.println("after summ " + yourCardsOnHand.size());
	}
	
//	public void summonedMinions(ArrayList<Card> cardsOnField){
//		this.yourCardsOnField = cardsOnField;
//	}
	
	public void enemySummonedMinions(ArrayList<Card> enemyCardsOnField){
		this.enemyCardsOnField =enemyCardsOnField;
	}
	
	public void setMinionSleep(int minion){
		if(minion==1){
			yourCardsOnField.get(0).setSleep(true);
		}
		if(minion==2){
			yourCardsOnField.get(1).setSleep(true);
		}
		if(minion==3){
			yourCardsOnField.get(2).setSleep(true);
		}
		if(minion==4){
			yourCardsOnField.get(3).setSleep(true);
		}
		if(minion==5){
			yourCardsOnField.get(4).setSleep(true);
		}
	}

	public void setMana(int mana){
		manaLeft = mana;
		gui.changeManaLeft(manaLeft);
		newRound();
	}
	
	public void DoneThisTurn(){
		client.doneThisTurn();
	}
	
	public String getName(){
		return playerName;
	}

}
