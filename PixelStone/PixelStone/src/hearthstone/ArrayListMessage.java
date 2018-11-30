package hearthstone;

import java.io.Serializable;
import java.util.ArrayList;

public class ArrayListMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7760495750667887068L;
	
	private ArrayList<Card> yourCardsOnField;
	private ArrayList<Card> enemyCardsOnField;
	
	
	public ArrayListMessage(ArrayList<Card> yourCardsOnField, ArrayList<Card> enemyCardsOnField){
		this.yourCardsOnField = yourCardsOnField;
		this.enemyCardsOnField = enemyCardsOnField;
	}
	
	public ArrayList<Card> getYourCardsOnField(){
		return yourCardsOnField;
	}

	public ArrayList<Card> getEnemyCardsOnField(){
		return enemyCardsOnField;
	}
}
