package hearthstone;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
	ArrayList<Card> theDeck= new ArrayList<Card>();
	ArrayList<Card> playerOne = new ArrayList<Card>();
	ArrayList<Card> playerTwo = new ArrayList<Card>();
	Deck deck;
	Gui gui;
	Controller controller;
	
	
	public Controller(){
		this.controller = controller;
		
		deck = new Deck();
		theDeck = deck.getDeck();
		dealOutCards();	
		gui = new Gui(controller);
		gui.theCards(playerOne);
		
////		System.out.println("");
////		System.out.println("PlayerOne's Cards");
//		for(int i = 0; i<playerOne.size(); i++){		
////			System.out.println(playerOne.get(i).getName() + " atk:" + playerOne.get(i).getAttack() + " hp:" + playerOne.get(i).getHealth());
//		}
//		System.out.println("-----------");
//		System.out.println("PlayerTwo's Cards");
//		for(int i = 0; i<playerTwo.size(); i++){		
//			System.out.println(playerTwo.get(i).getName() + " atk:" + playerTwo.get(i).getAttack() + " hp:" + playerTwo.get(i).getHealth());
//		}
//		
//		int health = playerOne.get(1).getHealth();
//		
//		playerOne.get(1).setHealth(health-4);
//		System.out.println("");
//		System.out.println(playerOne.get(1).getName() + " atk:" + playerOne.get(1).getAttack() + " hp:" + playerOne.get(1).getHealth());
	}
	
	public void dealOutCards() {
		//Player one's Cards
		for (int i = 0; i < 2; i++) {
			Random rand = new Random();
			int cardToPick = rand.nextInt(theDeck.size());
			playerOne.add(theDeck.get(cardToPick));
			theDeck.remove(cardToPick);
		}
		//Players two's Cards
		for (int i = 0; i < 2; i++) {
			Random rand = new Random();
			int cardToPick = rand.nextInt(theDeck.size());
			playerTwo.add(theDeck.get(cardToPick));
			theDeck.remove(cardToPick);
		}
	}
	
	public ArrayList<Card> getPlayerOneCards(){
		return playerOne;
	}
	public ArrayList<Card> getPlayerTwoCards(){
		return playerTwo;
	}

}
