package hearthstone;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;


public class Controller {
	ArrayList<Card> theDeck= new ArrayList<Card>();
	ArrayList<Card> playerOne = new ArrayList<Card>();
	ArrayList<Card> yourCardsOnHand = new ArrayList<Card>();	
	ArrayList<Card> yourCardsOnField = new ArrayList<Card>();
	ArrayList<Card> enemyCardsOnHand = new ArrayList<Card>();	
	ArrayList<Card> enemyCardsOnField = new ArrayList<Card>();
	ExAClient client;
	
	String playerName = "Name,Josse";
	
	Deck deck;
	Gui gui;
	fightControll fight;
	summonControll summon;
	loadImages images;
	int cardsLeft;
	int manaLeft = 0;
	
	
	
	public Controller(){
		
		deck = new Deck();
		theDeck = deck.getDeck();
		cardsLeft = theDeck.size();
//		getStartCards();	
		images = new loadImages();
		summon = new summonControll(this);
		fight = new fightControll(this);
		yourCardsOnField.add(theDeck.get(2));
		yourCardsOnField.add(theDeck.get(2));
		yourCardsOnField.add(theDeck.get(2));
		yourCardsOnField.add(theDeck.get(2));
		
		gui = new Gui(this,fight,summon);
//		gui.showHandCards(yourCardsOnHand, yourCardsOnField, enemyCardsOnField);
		gui.lockAllButtons();
//		try {			
//			client = new ExAClient(this,"127.0.0.1", 1337, playerName);
//			System.out.println("here??");
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		wakeUpMinions();
//		yourCardsOnHand.add(theDeck.get(5));
//		yourCardsOnField.add(theDeck.get(5));
//		enemyCardsOnField.add(theDeck.get(5));
		
		
		
//		enemyCardsOnField.add(theDeck.get(5));
//		enemyCardsOnField.add(theDeck.get(15));
//		enemyCardsOnField.add(theDeck.get(2));
//		enemyCardsOnField.add(theDeck.get(1));
//		client.updateBoard(yourCardsOnField,enemyCardsOnField);
		
//		gui.changeManaLeft(manaLeft);
//		gui.showHandCards(yourCardsOnHand,client.getYourCardsOnField(),client.enemyCardsOnField);		
	}
	public void tellImHere(ExAClient client){
		this.client = client;
	}
	public void rdy(){
		System.out.println("rdy from controller");
		client.rdy();
	}
	
	
	public void newRound(){
		wakeUpMinions();
		gui.showHandCards(yourCardsOnHand,client.getYourCardsOnField(),client.getEnemyCardsOnField());	
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
//		System.out.println("yourMinion:" + yourCardsOnField.get(yourMinion-1).getName() +" atk:"
//		+ yourCardsOnField.get(yourMinion-1).getAttack()+" HP:" + yourCardsOnField.get(yourMinion-1).getHealth());
//		System.out.println(yourCardsOnField.get(yourMinion-1).getName() + "  your hp after: " +yourHp );
		
		yourCardsOnField.get(yourMinion-1).setHealth(yourHp);
		enemyCardsOnField.get(enemyMinion-1).setHealth(theirHp);
		if(yourCardsOnField.get(yourMinion-1).getHealth()<=0){
			System.out.println("removing: " +yourCardsOnField.get(yourMinion-1).getName() );
			
			yourCardsOnField.remove(yourMinion-1);
		}
		if(enemyCardsOnField.get(enemyMinion-1).getHealth()<=0){
			enemyCardsOnField.remove(enemyMinion-1);
		}
		gui.showHandCards(yourCardsOnHand,yourCardsOnField,enemyCardsOnField);		
	}
	
	public void getStartCards(){
//		Random rand = new Random();
//		int next = rand.nextInt(theDeck.size());
//		int delete = next;
//
//		for(Card card: yourCardsOnHand){
////			System.out.println("in cardsOnHand " + card.getName());
//		}		
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
		
		yourCardsOnField.add(yourCardsOnHand.get(handPlace));
		yourCardsOnHand.remove(handPlace);		
		manaLeft = manaLeft - card.getCost();
		client.updateBoard(yourCardsOnField,enemyCardsOnField);
		gui.changeManaLeft(manaLeft);
		
		
		if(yourCardsOnHand.size()==0){
			gui.hideSumm1();
		}
		if(theDeck.size()>0 && yourCardsOnHand.size()<5){
			gui.showDraw();
		}
	}
	
	public void summonedMinions(ArrayList<Card> cardsOnField){
		this.yourCardsOnField = cardsOnField;
	}
	
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
